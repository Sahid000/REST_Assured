package DataDriven;

import io.restassured.http.ContentType;
import org.json.simple.JSONObject;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import static io.restassured.RestAssured.given;

public class DataDrivenExample1 {

    @DataProvider(name = "DataForPost)")
    public Object[][] dataForPost() {

        Object[][] data = new Object[2][3];

//        data[0][0] = "Albert";
//        data[0][1] = "Einstein";
//        data[0][2] = 2;
//
//        data[0][0] = "Thomas";
//        data[0][1] = "Edison";
//        data[0][2] = 1;
//
//        return data;

        return new Object[][]{

                {"Graham", "Bell", 1},
                {"Henry", "Ford", 2}

        };
    }

    //@Test(dataProvider = "DataForPost")
        public void Test_Post(String firstName, String lastName, int subjectId){

        JSONObject request = new JSONObject();

        request.put("firstName", firstName);
        request.put("lastName", firstName);
        request.put("subject", subjectId);

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

    @DataProvider(name = "DeleteData")
    public Object[] dataForDelete(){

        return new Object[]{

                4,5,6,7
        };
    }


    @Test(dataProvider = "DeleteData" )
    public void Test_Delete(int userId){

        baseURI = "http://localhost:3000/";

        when().
                delete("/users/"+userId).
                then().
                statusCode(204);
    }

}
