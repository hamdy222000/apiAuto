package utils;

import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;


import static io.restassured.RestAssured.given;

public class MyResponse {


    //===main requests methods===//
    private static Response get(String endPoint){
        return  customRequest()
                  .get(endPoint);
    }

    private static Response post(String endPoint , String body){
        return  customRequest()
                  .body(body)
                .when()
                  .post(endPoint);
    }


    private static Response put(String endPoint , String body){
        return customRequest()
                   .body(body)
                .when()
                   .put(endPoint);
    }

    private static Response patch(String endPoint , String body){
        return customRequest()
                   .body(body)
                .when()
                   .patch(endPoint);
    }

    private static Response delete(String endPoint){
        return  customRequest()
                  .delete(endPoint);
    }

    //===helper methods===//
    private static RequestSpecification customRequest(){
        return  given()
                .baseUri(Config.BASE_URL)
                .header("Content-Type", "application/json")
                .header(Config.API_KEY , Config.API_VALUE);
    }

    public static String getValue(Response res , String key){
        Object value = res.then().extract().body().jsonPath().get(key);
        return value != null ? value.toString() : "";
    }

    //===main services methods===//
    public static Response getList(String endPoint , String message){
        Attach.infoMessage(message);
        return MyResponse.get(endPoint);
    }

    public static Response getSingleElement(String endPoint , String message){
        Attach.infoMessage(message);
        return MyResponse.get(endPoint);
    }


    public static Response bodyRequest(String requestType , String endPoint , String body , String message){
        Attach.infoMessage(message);
        if (requestType.equalsIgnoreCase("post")) {
            return MyResponse.post(endPoint, body);
        }else if (requestType.equalsIgnoreCase("put")) {
            return MyResponse.put(endPoint, body);
        } else if (requestType.equalsIgnoreCase("patch")) {
            return MyResponse.patch(endPoint, body);
        } else {
            throw new IllegalArgumentException("Invalid requestType: " + requestType + ". Only 'post' or 'put' or 'patch' allowed.");
        }
    }

    public static Response deleteElement(String endPoint , String message){
        Attach.infoMessage(message);
        return MyResponse.delete(endPoint);
    }
}
