package payLoad;

import org.testng.annotations.Test;

import java.io.File;

import static io.restassured.RestAssured.given;

public class JsonPathPost {

    @Test
    public void PostWithJsonPath(){
        given().
                baseUri("https://api.getpostman.com").
                header("x-api-key","PMAK-639117dbd4f1f03347147db1-2f2d61b490f48ea49686cb1bc5065ce655").
                body(new File("C:\\Users\\farza\\IdeaProjects\\MyPracticeRestAssured\\src\\test\\java\\workspaces.json")).
                post("workspaces").
                then().
                log().all().
                statusCode(200);

    }
}
