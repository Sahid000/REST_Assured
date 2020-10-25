package Local_JSONSERVER;

import io.restassured.http.ContentType;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;

public class Test_Example {

    //@Test
    public void Test_get(){

        baseURI = "http://localhost:3000/";

        given().
                param("name", "Automations").
                get("/comments").
        then().
                statusCode(200).
                log().all();
    }

    //@Test (priority = 2)
    public void Test_Post(){


        JSONObject request = new JSONObject();

        request.put("firstName", "Kakka");
        request.put("lastName", "Miha");
        request.put("subject", 1);

        baseURI = "http://localhost:3000/";

        given().
                contentType(ContentType.JSON).
                accept(ContentType.JSON).
                header("Content-Type", "application/json").
                body(request.toJSONString()).
        when().
                post("/users").
        then().
                statusCode(201).
                log().all();
    }

    //@Test (priority = 3)
    public void Test_Patch(){


        JSONObject request = new JSONObject();

        request.put("lastName", "Abbas");

        baseURI = "http://localhost:3000/";

        given().
                contentType(ContentType.JSON).
                accept(ContentType.JSON).
                header("Content-Type", "application/json").
                body(request.toJSONString()).
                when().
                patch("/users/4").
                then().
                statusCode(200).
                log().all();
    }

    //@Test (priority = 4)
    public void Test_Put(){


        JSONObject request = new JSONObject();

        request.put("firstName", "Limon");
        request.put("lastName", "Kakku");
        request.put("subject", 1);

        baseURI = "http://localhost:3000/";

        given().
                contentType(ContentType.JSON).
                accept(ContentType.JSON).
                header("Content-Type", "application/json").
                body(request.toJSONString()).
                when().
                put("/users/4").
                then().
                statusCode(200).
                log().all();
    }

    //@Test (priority = 5){
    public void Test_Delete(){

        baseURI = "http://localhost:3000/";

        when().
                delete("/users/4").
        then().
                statusCode(204);
    }

}
