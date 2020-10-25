package Test_GETPOSTPUTDELETE;

import io.restassured.http.ContentType;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.when;

public class Test_DELETE {

    @Test
    public void test_05(){

          when().
                delete("https://reqres.in/api/users/2").
          then().
                statusCode(204).
                log().all();

    }
}
