package utils;

import io.qameta.allure.Allure;

public class Attach {
    private Attach(){};

    public static void infoMessage(String message){
        Allure.step(message);
        Logs.info(message);
    }

    public static void warnMessage(String message){
        Allure.step(message);
        Logs.warn(message);
    }

    public static void errorMessage(String message){
        Allure.step(message);
        Logs.error(message);
    }
}
