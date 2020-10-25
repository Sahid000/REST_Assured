package Test_GETPOSTPUTDELETE;

import io.restassured.http.ContentType;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class Test_PATCH {

    @Test
    public void test_04(){

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
                patch("https://reqres.in/api/users/2").
         then().
                statusCode(200).
                log().all();

    }
}
