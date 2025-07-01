package tests;

import io.restassured.response.Response;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import services.RegisterServices;
import utils.Listeners.TestngListeners;
import validations.RegisterValidations;

@Listeners(TestngListeners.class)
public class RegisterTest {


    @Test
    public void successfulRegistration(){
        Response res = RegisterServices.validRegistration();
        RegisterValidations.verifyValidRegistration(res);
    }

    @Test
    public void unsuccessfulRegistration(){
        Response res = RegisterServices.invalidRegistration();
        RegisterValidations.verifyInvalidRegistration(res);
    }
}
