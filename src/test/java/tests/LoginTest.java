package tests;

import io.restassured.response.Response;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import services.LoginServices;
import utils.Listeners.TestngListeners;
import validations.LoginValidations;

@Listeners(TestngListeners.class)
public class LoginTest {

    @Test
    public void successfulLogin(){
        Response res = LoginServices.validLogin();
        LoginValidations.verifyValidLogin(res);
    }

    @Test
    public void unsuccessfulLogin(){
        Response res = LoginServices.invalidLogin();
        LoginValidations.verifyInvalidLogin(res);
    }
}
