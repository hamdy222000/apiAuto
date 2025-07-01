package services;

import io.restassured.response.Response;
import utils.MyResponse;
import utils.filesManage.ReadJsonFile;

public class LoginServices {
    private static final String basePath = "/login";

    public static Response validLogin(){
        String requestType = "post";
        String endPoint = basePath ;
        String body = ReadJsonFile.getKey("login" , "login_successful");
        String message = "Sending Post request with body \n" + body + "\nto successful login via endpoint: '" + endPoint + "'";

        return MyResponse.bodyRequest(requestType , endPoint , body , message);
    }

    public static Response invalidLogin(){
        String requestType = "post";
        String endPoint = basePath ;
        String body = ReadJsonFile.getKey("login" , "login_unsuccessful");
        String message = "Sending Post request with body \n" + body + "\nto unsuccessful login via endpoint: '" + endPoint + "'";

        return MyResponse.bodyRequest(requestType , endPoint , body , message);
    }
}
