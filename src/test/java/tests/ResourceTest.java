package tests;

import io.restassured.response.Response;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import services.ResourceServices;
import utils.Listeners.TestngListeners;
import validations.ResourceValidations;

@Listeners(TestngListeners.class)
public class ResourceTest {

    @Test
    public void getResourcesData(){
        Response res = ResourceServices.getResourceList();
        ResourceValidations.verifyGetResources(res);
    }

    @Test
    public void getDataOfSingleResource(){
        Response res = ResourceServices.getSingleResource(2);
        ResourceValidations.verifyGetSingleResource(res);
    }

    @Test
    public void getUnfoundResource(){
        Response res = ResourceServices.getSingleResource(25);
        ResourceValidations.verifyResourceNotFound(res);

    }

}
