package utils;

import io.restassured.response.Response;
import org.testng.asserts.SoftAssert;
import utils.filesManage.ReadJsonFile;

public class MyValidations {

    //===helper methods===//
    private static void verifyStatusCode(Response res , int expectedStatusCode , SoftAssert softAssert){
        Attach.infoMessage("Verify that status code = " + expectedStatusCode);
        softAssert.assertEquals(res.statusCode() , expectedStatusCode , "Status code is not correct,");
    }

    private static void verifyPageNo(Response res , int expectedPageNo , SoftAssert softAssert){
        Attach.infoMessage("Verify that page = " + expectedPageNo);
        int actualPageNo = Integer.parseInt(MyResponse.getValue(res , "page"));
        softAssert.assertEquals(actualPageNo , expectedPageNo , "The page number is not correct,");
    }

    private static void verifyFindElement(Response res , String existedElement , String elementName , SoftAssert softAssert){
        Attach.infoMessage("Verify that the response body contain the registered " + elementName + " '" + existedElement + "'");
        boolean isElementExists = res.getBody().asString().contains(existedElement);
        softAssert.assertTrue(isElementExists , "The " + elementName + " '" + existedElement +  "' is not exist in the response body,");
    }

    private static void verifyEmptyBody(Response res  , SoftAssert softAssert){
        Attach.infoMessage("Verify that the response body is empty");
        boolean isEmpty = res.getBody().asString().equals("{}");
        softAssert.assertTrue(isEmpty , "Response body is not empty,");
    }

    private static void verifyResponseBody(Response res  , String fileData , String BasePath , String key1 , String key2 , SoftAssert softAssert){
        String expectedValue1 = ReadJsonFile.getKey(fileData , BasePath + "." + key1);
        String expectedValue2 = ReadJsonFile.getKey(fileData , BasePath + "." + key2);
        String actualValue1 = MyResponse.getValue(res , key1);
        String actualValue2 = MyResponse.getValue(res , key2);
        Attach.infoMessage("Verify that Response body is correct ");
        softAssert.assertEquals(actualValue1 , expectedValue1 , key1 + " is not as expected,");
        softAssert.assertEquals(actualValue2 , expectedValue2 , key2 + " is not as expected,");
    }

    private static void verifyResponseBody(Response res  , String fileData , String key , SoftAssert softAssert){
        String expectedValue = ReadJsonFile.getKey(fileData , key);
        String actualValue = MyResponse.getValue(res , key);
        Attach.infoMessage("Verify from " + key);
        softAssert.assertEquals(actualValue , expectedValue , key + " is not as expected,");
    }

    //===validations methods===//
    public static void verifyGetList(Response res , int expectedPageNo , String existedElement , String elementName){
        SoftAssert softAssert = new SoftAssert();

        verifyStatusCode(res , 200 , softAssert);
        verifyPageNo(res , expectedPageNo , softAssert);
        verifyFindElement(res , existedElement , elementName , softAssert);

        softAssert.assertAll();
    }

    public static void verifyGetSingleElement(Response res  , String existedElement , String elementName){
        SoftAssert softAssert = new SoftAssert();

        verifyStatusCode(res , 200 , softAssert);
        verifyFindElement(res , existedElement , elementName , softAssert);

        softAssert.assertAll();
    }

    public static void verifyGetElementNotFound(Response res  , String elementName){
        SoftAssert softAssert = new SoftAssert();

        verifyStatusCode(res , 404 , softAssert);
        verifyEmptyBody(res , softAssert);

        softAssert.assertAll();
    }

    public static void verifyCreateElement(Response res  , String fileData , String BasePath , String key1 , String key2){
        SoftAssert softAssert = new SoftAssert();

        verifyStatusCode(res , 201 , softAssert);
        verifyResponseBody(res , fileData , BasePath , key1 , key2 , softAssert);

        softAssert.assertAll();
    }

    public static void verifyUpdateElement(Response res  , String fileData , String BasePath , String key1 , String key2){
        SoftAssert softAssert = new SoftAssert();

        verifyStatusCode(res , 200 , softAssert);
        verifyResponseBody(res , fileData , BasePath , key1 , key2 , softAssert);

        softAssert.assertAll();
    }

    public static void verifyDeleteElement(Response res){
        SoftAssert softAssert = new SoftAssert();

        verifyStatusCode(res , 204 , softAssert);

        softAssert.assertAll();
    }

    public static void verifySign(Response res , int expectedCode  , String fileData , String key  ){
        SoftAssert softAssert = new SoftAssert();

        verifyStatusCode(res , expectedCode , softAssert);
        verifyResponseBody(res , fileData , key , softAssert);

        softAssert.assertAll();
    }



}
