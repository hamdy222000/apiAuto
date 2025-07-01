package validations;

import io.restassured.response.Response;
import utils.MyValidations;

public class LoginValidations {

    public static void verifyValidLogin(Response res){
        MyValidations.verifyLogin(res , 200 , "login" , "token");
    }

    public static void verifyInvalidLogin(Response res){
        MyValidations.verifyLogin(res , 400 ,"login" , "error");
    }
}
