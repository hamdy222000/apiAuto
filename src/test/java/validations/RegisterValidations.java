package validations;

import io.restassured.response.Response;
import utils.MyValidations;

public class RegisterValidations {

    public static void verifyValidRegistration(Response res){
        MyValidations.verifyLogin(res , 200 , "register" , "token");
    }

    public static void verifyInvalidRegistration(Response res){
        MyValidations.verifyLogin(res , 400 ,"register" , "error");
    }
}
