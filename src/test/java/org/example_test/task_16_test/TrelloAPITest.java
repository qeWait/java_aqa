package org.example_test.task_16_test;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import kong.unirest.HttpResponse;
import kong.unirest.Unirest;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import static io.restassured.RestAssured.given;

public class TrelloAPITest {
    Properties properties = new Properties();

    String trelloKey;
    String trelloToken;
    String cardId;

    @BeforeTest
    public void initProperty() throws IOException {
        properties.load(new FileReader("/Users/pavlo/Documents/GitHub/java_aqa/src/main/resources/application.properties"));
        trelloKey = properties.getProperty("trello.key");
        trelloToken = properties.getProperty("trello.token");
        cardId = properties.getProperty("trello.card.id");

    }

    @Test
    public void restAssuredTest(){
        //create checklist
        Response response = given().when().log().all().header("Content-Type", "").post("https://api.trello.com/1/checklists" +
                "?key=" + trelloKey +
                "&token=" + trelloToken +
                "&idCard=" + cardId +
                "&name=in-code"
        ).then().assertThat().statusCode(200).extract().response();


        JsonPath createChecklistResponseJSON = response.jsonPath();

        //create checkitem
        Response response1 = given().when().log().all().header("Content-Type", "").post("https://api.trello.com/1/checklists/"
                + createChecklistResponseJSON.get("id") + "/checkItems" +
                "?key=" + trelloKey +
                "&token=" + trelloToken +
                "&name=in-code-item"
        ).then().assertThat().statusCode(200).extract().response();


        JsonPath createCheckitemResponseJSON = response1.jsonPath();


        //delete checkitem
        given().when().log().all().header("Content-Type", "").delete("https://api.trello.com/1/checklists/"
                + createChecklistResponseJSON.get("id") +
                "/checkItems/" + createCheckitemResponseJSON.get("id") +
                "?key=" + trelloKey +
                "&token=" + trelloToken
        ).then().assertThat().statusCode(200);

        //update checklist
        given().when().log().all().header("Content-Type", "").put("https://api.trello.com/1/checklists/"
                + createChecklistResponseJSON.get("id") +
                "?key=" + trelloKey +
                "&token=" + trelloToken +
                "&name=tetetete"
        ).then().assertThat().statusCode(200);
    }

    @Test
    public void unirestTest(){
        //create checklist
        HttpResponse <kong.unirest.JsonNode> response = Unirest.post("https://api.trello.com/1/checklists")
                .queryString("key", trelloKey)
                .queryString("token", trelloToken)
                .queryString("name", "unirest")
                .queryString("idCard", "64578c857507c7928ddaff6e")
                .asJson();

        Assert.assertTrue(response.isSuccess());
        String checklistId = response.getBody().getObject().get("id").toString();

        //create checkitem
        HttpResponse <kong.unirest.JsonNode> response1 = Unirest.post("https://api.trello.com/1/checklists/" + checklistId + "/checkitems")
                .queryString("key", trelloKey)
                .queryString("token", trelloToken)
                .queryString("name", "unirest-item")
                .asJson();

        Assert.assertTrue(response1.isSuccess());
        String checkItemId = response1.getBody().getObject().get("id").toString();


        //delete checkitem
        HttpResponse <kong.unirest.JsonNode> response2 = Unirest.delete("https://api.trello.com/1/checklists/" + checklistId + "/checkitems/"+checkItemId)
                .queryString("key", trelloKey)
                .queryString("token", trelloToken)
                .asJson();

        Assert.assertTrue(response2.isSuccess());

        //update checklist
        HttpResponse <kong.unirest.JsonNode> response3 = Unirest.put("https://api.trello.com/1/checklists/" + checklistId)
                .queryString("key", trelloKey)
                .queryString("token", trelloToken)
                .queryString("name", "unirest-new-name")
                .asJson();

        Assert.assertTrue(response3.isSuccess());
    }

}
