package Test_GETPOSTPUTDELETE;

import io.restassured.http.ContentType;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.when;

public class Test_POST {

    @Test
    public void test_02(){

        JSONObject request = new JSONObject();

        request.put("name", "Shahid");
        request.put("job", "SQA");

        System.out.println(request);
        System.out.println(request.toJSONString());

        given().
                header("Content-Type", "application/json").
                contentType(ContentType.JSON).
                body(request.toJSONString()).
                when().
                post("https://reqres.in/api/users").
                then().
                statusCode(201).
                log().all();

     }
}
