package services;

import io.restassured.response.Response;
import utils.MyResponse;
import utils.filesManage.ReadJsonFile;

public class RegisterServices {

    private static final String basePath = "/register";

    public static Response validRegistration(){
        String requestType = "post";
        String endPoint = basePath ;
        String body = ReadJsonFile.getKey("register" , "register_successful");
        String message = "Sending Post request with body \n" + body + "\nto successful registration via endpoint: '" + endPoint + "'";

        return MyResponse.bodyRequest(requestType , endPoint , body , message);
    }

    public static Response invalidRegistration(){
        String requestType = "post";
        String endPoint = basePath ;
        String body = ReadJsonFile.getKey("register" , "register_unsuccessful");
        String message = "Sending Post request with body \n" + body + "\nto unsuccessful registration via endpoint: '" + endPoint + "'";

        return MyResponse.bodyRequest(requestType , endPoint , body , message);
    }
}
