package Testing;

import io.restassured.path.json.JsonPath;
import io.restassured.specification.RequestSpecification;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static io.restassured.RestAssured.*;
import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ApiTest {
    final static String url="https://flights-api.buraky.workers.dev/";
    final static String Id="1";
    @Test
    public  void checkResponseStatus(){
        //Gets the Status Code which return value of Request then print it
        int statusCode= given(). when().get(url).getStatusCode();
        //Print the status code
        System.out.println("The response status is "+statusCode);

        //Get the Status Code which return value of Request then assert with expected value
        given().when().get(url).then().assertThat().statusCode(200);
    }
    @Test
    public void printBody()
    {
        //Print the body
        System.out.println(given().when().get(url).getBody().asString());
    }
    @Test
    public void printSpecificPartOfResponseBodyWithId()
    {
        //It return the associated 'from' value by searching for the 'Id'
        //You can change the id value from above
        String from = when().get(url).then().extract().path("data.find { it.id == "+Id+"}.from");
        String to = when().get(url).then().extract().path("data.find { it.id == "+Id+"}.to");
        String date = when().get(url).then().extract().path("data.find { it.id == "+Id+"}.date");
        System.out.println(from);
        System.out.println(to);
        System.out.println(date);
    }

    @Test
    public void CheckHeader()
    {
        given() .when().get(url).then().assertThat().contentType("application/json");
    }
    @Test
    public void  NotNull()
    {
        JsonPath jsonPath = given() .when().get(url).then().extract().jsonPath();
        List<Map<String, ?>> datas = jsonPath.getList("data");
        for (Map<String, ?> data : datas) {
            // Check if each key exists and has appropriate values
            Integer id = (Integer) data.get("id");
            String from = (String) data.get("from");
            String to = (String) data.get("to");
            String date = (String) data.get("date");

            assertNotNull(String.valueOf(id));
            assertNotNull(from);
            assertNotNull(to);
            assertNotNull(date);
            assertTrue(date.matches("\\d{4}-\\d{2}-\\d{2}"));
        }
    }


}
