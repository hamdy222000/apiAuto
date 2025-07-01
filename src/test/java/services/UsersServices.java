package services;

import io.restassured.response.Response;
import utils.MyResponse;
import utils.filesManage.ReadJsonFile;

public class UsersServices {

    private static final String basePath = "/users";


    public static Response getUsersList(){
        String endPoint = basePath + "?page=2";
        String message = "Sending GET request to fetch users data of page = 2 via endpoint: '" + endPoint + "'";

        return MyResponse.getList(endPoint , message);
    }

    public static Response getSingleUser(int userID){
        String endPoint = basePath + "/" + userID ;
        String message = "Sending GET request to fetch user with ID = " + userID + " via endpoint: '" + endPoint + "'";

        return MyResponse.getSingleElement(endPoint , message);
    }

    public static Response createUser(){
        String requestType = "post";
        String endPoint = basePath ;
        String body = ReadJsonFile.getKey("users" , "create_user");
        String message = "Sending Post request with body \n" + body + "\nto create new user via endpoint: '" + endPoint + "'";

        return MyResponse.bodyRequest(requestType , endPoint , body , message);
    }

    public static Response updateUser(int userID , String requestType){
        String endPoint = basePath + "/" + userID;
        String body = ReadJsonFile.getKey("users" , "update_user");
        String message = "Sending " + requestType + " request with body \n" + body +
                "\nto update the data of the user with ID = " + userID + " via endpoint: '" + endPoint + "'";

        return MyResponse.bodyRequest(requestType , endPoint , body , message);
    }

    public static Response deleteUser(int userID){
        String endPoint = basePath + "/" + userID ;
        String message = "Sending Delete request to delete user with ID = " + userID + " via endpoint: '" + endPoint + "'";

        return MyResponse.deleteElement(endPoint , message);
    }

}
