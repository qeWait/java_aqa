package org.example.task_17.bo;

import io.restassured.response.Response;
import org.example.task_17.requests.CreateCheckItemRequest;
import org.example.task_17.requests.CreateChecklistRequest;
import org.example.task_17.requests.DeleteCheckItemRequest;
import org.example.task_17.requests.UpdateChecklistRequest;
import org.example.task_17.response.CreateCheckItemResponse;
import org.example.task_17.response.CreateChecklistResponse;
import org.example.task_17.response.DeleteCheckItemResponse;
import org.example.task_17.response.UpdateChecklistResponse;

import static io.restassured.RestAssured.given;

public class TrelloBO {
    private String trelloKey;
    private String trelloToken;

    public TrelloBO(String trelloKey, String trelloToken) {
        this.trelloKey = trelloKey;
        this.trelloToken = trelloToken;
    }

    public CreateChecklistResponse createChecklist(CreateChecklistRequest createChecklistRequest){
        Response response = given().when().log().all().header("Content-Type", "").post("https://api.trello.com/1/checklists" +
                "?key=" + createChecklistRequest.getTrelloKey() +
                "&token=" + createChecklistRequest.getTrelloToken() +
                "&idCard=" + createChecklistRequest.getCardId() +
                "&name=" + createChecklistRequest.getName()
        ).then().extract().response();

        return new CreateChecklistResponse(response.getStatusCode(), response.jsonPath());
    }

    public CreateCheckItemResponse createCheckItem(CreateCheckItemRequest createCheckitemRequest){
        Response response = given().when().log().all().header("Content-Type", "").post("https://api.trello.com/1/checklists/"
                + createCheckitemRequest.getChecklistId() + "/checkItems" +
                "?key=" + createCheckitemRequest.getTrelloKey() +
                "&token=" + createCheckitemRequest.getTrelloToken() +
                "&name=" + createCheckitemRequest.getName()
        ).then().extract().response();

        return new CreateCheckItemResponse(response.getStatusCode(), response.jsonPath());
    }

    public DeleteCheckItemResponse deleteCheckItem(DeleteCheckItemRequest deleteCheckItemRequest){
        Response response = given().when().log().all().header("Content-Type", "").delete("https://api.trello.com/1/checklists/"
                + deleteCheckItemRequest.getChecklistId() +
                "/checkItems/" + deleteCheckItemRequest.getCheckItemId() +
                "?key=" + deleteCheckItemRequest.getTrelloKey() +
                "&token=" + deleteCheckItemRequest.getTrelloToken()
        ).then().extract().response();

        return new DeleteCheckItemResponse(response.getStatusCode(), response.jsonPath());
    }

    public UpdateChecklistResponse updateChecklist(UpdateChecklistRequest updateChecklistRequest){
        Response response = given().when().log().all().header("Content-Type", "").put("https://api.trello.com/1/checklists/"
                + updateChecklistRequest.getChecklistId() +
                "?key=" + updateChecklistRequest.getTrelloKey() +
                "&token=" + updateChecklistRequest.getTrelloToken() +
                "&name=" + updateChecklistRequest.getNewName()
        ).then().extract().response();

        return new UpdateChecklistResponse(response.getStatusCode(), response.jsonPath());
    }

    public String getTrelloKey() {
        return trelloKey;
    }

    public String getTrelloToken() {
        return trelloToken;
    }
}
