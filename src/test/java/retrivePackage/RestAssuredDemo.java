package retrivePackage;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class RestAssuredDemo {
@Test
    public void validateWorkSpacesWithoutExtractUsingHamcrast(){
        given().//given is reffered as precondition
                baseUri("https://api.getpostman.com").
                header("x-api-key","PMAK-639117dbd4f1f03347147db1-2f2d61b490f48ea49686cb1bc5065ce655").
                when().//when represent action
                get("workspaces").
                then().//after this then it will automatically work for response
                log().all().
                /*if we do not put log.all method then we will not get responses
                        response is showing
                       */
                // log().ifError().
                //above method will pass the test but if there is an error it will show error
                assertThat().//validation
                statusCode(200).
                and().
                body("workspaces.name",hasItem("My WorkSpace3"),
                        "workspaces.type",hasItem("personal"),
                        "workspaces[0].name",equalTo("My WorkSpace3"),
                        "workspaces.name",hasSize(17)).//it will give the size of
                //these are the ways we can validate 1. using Hamcrest library which are hasitems for multiple workspace,
                // hasitem for single workspace ,equalTo for particular item

                header("Vary",equalTo("Accept-Encoding"));

    }
    @Test
    public void validateworkSpaceUsingJsonFile(){
       Response res= given().//response is an interface and res is an object
                baseUri("https://api.getpostman.com").
                header("x-api-key","PMAK-639117dbd4f1f03347147db1-2f2d61b490f48ea49686cb1bc5065ce655").
                when().
                get("workspaces").
                then().
                log().all().
                assertThat().
                statusCode(200).
               extract().response();//jsonpath we need to extract

       // here js is an object or refrence variable and Jason Path is class too
       JsonPath js=res .jsonPath();
       String firstId= js.get("workspaces[0].id");//here i want to get id of first workspace
        System.out.println(firstId);
        Assert.assertEquals(firstId,"2bbedd5b-a1a0-46fa-84b5-7799030fd076");//validation
        String secondId=js.get("workspaces[0].name");//here i want to get name of first workspace
        System.out.println(secondId);
        Assert.assertEquals(secondId,"My WorkSpace3");
/*How do we validate ?
 1.Using hamcrest library we can validate example hasitem,hasSize,equalTo. for particular item,
 multiple item we use hasitems
 2.Validate with status code
 3.Validate with Assert.assertEquals we use from testNG.
 4.Validate with Jsonpath
 5. sometimes we extract the response that time we use jsonpath and we validate jsonpath
UI means  it is in front end whatever we can see it is coming from server and showing on screen.
*/


    }
}
