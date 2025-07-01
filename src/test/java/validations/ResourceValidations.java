package validations;

import io.restassured.response.Response;
import utils.MyValidations;
import utils.filesManage.ReadJsonFile;

public class ResourceValidations {

    public static void verifyGetResources(Response res){
        int pageNO = 1;
        String existedResource = ReadJsonFile.getKey("resource" , "existed_resource.name");

        MyValidations.verifyGetList(res , pageNO , existedResource , "resource");
    }

    public static void verifyGetSingleResource(Response res){
        String existedResource = ReadJsonFile.getKey("resource" , "resource2.name");

        MyValidations.verifyGetSingleElement(res , existedResource , "resource");
    }

    public static void verifyResourceNotFound(Response res){
        MyValidations.verifyGetElementNotFound(res , "resource");
    }
}
