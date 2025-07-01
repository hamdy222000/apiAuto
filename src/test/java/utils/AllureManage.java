package utils;



import io.qameta.allure.Allure;


import java.io.File;
import java.nio.file.Files;


public class AllureManage {

    public static void addLogsToReport(String logfileName){
        File log = new File("testOut/logs/logfile_" + logfileName + ".txt");
        try {
            Allure.addAttachment("logs" , Files.readString(log.toPath()));
        }catch (Exception e){
            Logs.error("cannot add logs to allure report " + e.getMessage());
        }
    }






}

