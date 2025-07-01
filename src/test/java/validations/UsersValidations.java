package validations;

import io.restassured.response.Response;

import utils.MyValidations;
import utils.filesManage.ReadJsonFile;

public class UsersValidations {

    public static void verifyGetUsers(Response res){
        int pageNO = 2;
        String existedUser = ReadJsonFile.getKey("users" , "existed_user.first_name");

        MyValidations.verifyGetList(res , pageNO , existedUser , "user");
    }

    public static void verifyGetSingleUser(Response res){
        String existedUser = ReadJsonFile.getKey("users" , "user2.first_name");

        MyValidations.verifyGetSingleElement(res , existedUser , "user");
    }

    public static void verifyUserNotFound(Response res){
        MyValidations.verifyGetElementNotFound(res , "user");
    }

    public static void verifyCreateUser(Response res){
        MyValidations.verifyCreateElement(res , "users" , "create_user" , "name" , "job");
    }

    public static void verifyUpdateUser(Response res){
        MyValidations.verifyUpdateElement(res , "users" , "update_user" , "name" , "job");
    }

    public static void verifyDeleteUser(Response res){
        MyValidations.verifyDeleteElement(res);
    }



}
