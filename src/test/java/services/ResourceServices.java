package services;

import io.restassured.response.Response;
import utils.MyResponse;

public class ResourceServices {

    private static final String basePath = "/unknown";


    public static Response getResourceList(){
        String endPoint = basePath ;
        String message = "Sending GET request to fetch resource data of page = 1 via endpoint: '" + endPoint + "'";

        return MyResponse.getList(endPoint , message);
    }

    public static Response getSingleResource(int resourceID){
        String endPoint = basePath + "/" + resourceID ;
        String message = "Sending GET request to fetch resource with ID = " + resourceID + " via endpoint: '" + endPoint + "'";

        return MyResponse.getSingleElement(endPoint , message);
    }
}
