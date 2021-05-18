package api;

import org.json.simple.JSONObject;
import static io.restassured.RestAssured.*;
import org.testng.annotations.Test;

public class API{

    @Test
    public void Post() {
        JSONObject POST = new JSONObject();

        POST.put("name", "Joshua");
        POST.put("job", "Lawyer");

        System.out.println(POST.toJSONString());

        given().
                body(POST.toJSONString()).
        when().
                post ("https://reqres.in/api/users").
        then().
            statusCode(201);
    }

    @Test
    public void PutOrPatch() {
        JSONObject POST = new JSONObject();

        POST.put("name", "Jack");
        POST.put("job", "Lawyer");

        System.out.println(POST.toJSONString());

        given().
                body(POST.toJSONString()).
        when().
                patch ("https://reqres.in/api/users/2").
        then().
            statusCode(200);
    }

    @Test
    public void Get() {

        when().
                get ("https://reqres.in/api/users/2").
        then().
            statusCode(200).log().all();
    }

    @Test
    public void Delete() {

        when().
                delete ("https://reqres.in/api/users/2").
        then().
            statusCode(204).log().all();
    }

}
