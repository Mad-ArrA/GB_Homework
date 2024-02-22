package ru.gb.hm14.lesson;

import java.io.IOException;
import java.util.logging.*;

public class Sample03 {

    public static void main(String[] args) {

        /*Sample s = Sample.get();
        Sample s2 = Sample.get();
        Sample s3 = Sample.get();
        Sample s4 = Sample.get();*/

        try
        {
            LogManager.getLogManager().readConfiguration(
                Sample03.class.getResourceAsStream("/config/logging.properties"));
        }
        catch (IOException e){
            e.printStackTrace();
        }

        Logger logger = Logger.getLogger(Sample03.class.getName());

        /*try {
            FileHandler allfilehandler = new FileHandler("jul.samplefull.log");
            allfilehandler.setLevel(Level.ALL);
            allfilehandler.setFormatter(new XMLFormatter());
            logger.addHandler(allfilehandler);

            FileHandler errfilehandler = new FileHandler("jul.sampleex.log");
            errfilehandler.setLevel(Level.SEVERE);
            errfilehandler.setFormatter(new XMLFormatter());
            logger.addHandler(errfilehandler);
        }
        catch (Exception e){
            e.printStackTrace();
        }*/


        logger.info("Пользователь нажал на кнопку 1.");
        logger.warning("Произошло событие.\nПродолжаем работать.");
        logger.log(Level.SEVERE, "Произошло серьезное исключение,\nработа приложения будет завершена.");

        // ConsoleHandler
        // Filehandler
        // Memoryhandler
        // Sockethandler



    }

}
