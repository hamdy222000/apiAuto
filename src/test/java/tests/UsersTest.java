package tests;

import io.restassured.response.Response;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import services.UsersServices;
import utils.Listeners.TestngListeners;
import validations.UsersValidations;

@Listeners(TestngListeners.class)
public class UsersTest {

    @Test
    public void getUsersData(){
        Response res = UsersServices.getUsersList();
        UsersValidations.verifyGetUsers(res);
    }

    @Test
    public void getDataOfSingleUser(){
        Response res = UsersServices.getSingleUser(2);
        UsersValidations.verifyGetSingleUser(res);
    }

    @Test
    public void getUnfoundUser(){
        Response res = UsersServices.getSingleUser(23);
        UsersValidations.verifyUserNotFound(res);

    }

    @Test
    public void createUser() {
        Response res = UsersServices.createUser();
        UsersValidations.verifyCreateUser(res);
    }

    @Test
    public void updateUserViaPutRequest(){
        Response res = UsersServices.updateUser(1 , "put");
        UsersValidations.verifyUpdateUser(res);

    }

    @Test
    public void updateUserViaPatchRequest(){
        Response res = UsersServices.updateUser(2 , "patch");
        UsersValidations.verifyUpdateUser(res);

    }

    @Test
    public void deleteUser(){
        Response res = UsersServices.deleteUser(3);
        UsersValidations.verifyDeleteUser(res);

    }






}
