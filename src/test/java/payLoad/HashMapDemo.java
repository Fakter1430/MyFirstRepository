package payLoad;

import java.util.HashMap;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;


public class HashMapDemo {
    //REST Assured is a Java library for testing RESTful APIs
    //Hashmap is a class where objects/element will be key and value pair.
    HashMap<String,String> element= new HashMap<>();
    HashMap<String,Object> root=new HashMap<>();
@Test
  public void PostWithHaspmap(){

    element.put( "name"," My workspaces hashmap new");
    element.put("type","personal");
    element.put("visibility","Only me");
    element.put("description","This is training");

      root.put("workspace",element);

      given().
              baseUri("https://api.getpostman.com").
              header("x-api-key","PMAK-639117dbd4f1f03347147db1-2f2d61b490f48ea49686cb1bc5065ce655").
              body(root).
             post("workspaces").
              then().
              log().all().
              assertThat().
              statusCode(200);
   /*inside the json file there is body from postman so from 1 carle braces to another carle brace is 1 object
    before workspace there is a carle brace starting and very last carle brace is called object 1 but called root.
            before the name there is carle brace and after description there is 1 carle brace is called object 2

    dependency = we need to bring jackson databind from maven repository
    java to json and json to java -what is the name bhaiya said



            */

  }

}
