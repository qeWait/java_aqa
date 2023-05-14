package org.example_test.task_17_test;

import org.example.task_17.bo.TrelloBO;
import org.example.task_17.requests.CreateCheckItemRequest;
import org.example.task_17.requests.CreateChecklistRequest;
import org.example.task_17.requests.DeleteCheckItemRequest;
import org.example.task_17.requests.UpdateChecklistRequest;
import org.example.task_17.response.CreateCheckItemResponse;
import org.example.task_17.response.CreateChecklistResponse;
import org.example.task_17.response.DeleteCheckItemResponse;
import org.example.task_17.response.UpdateChecklistResponse;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class TrelloAPITest {
    Properties properties = new Properties();

    String trelloKey;
    String trelloToken;
    String cardId;
    TrelloBO trelloBO;
    String checklistName;
    String checkItemName;
    String newChecklistName;

    @BeforeTest
    public void initProperty() throws IOException {
        properties.load(new FileReader("/Users/pavlo/Documents/GitHub/java_aqa/src/main/resources/application.properties"));

        trelloKey = properties.getProperty("trello.key");
        trelloToken = properties.getProperty("trello.token");
        cardId = properties.getProperty("trello.card.id");

        trelloBO = new TrelloBO(trelloKey, trelloToken);

        checklistName = "My first todo list";
        checkItemName = "Do AQA tasks";
        newChecklistName = "My todo list";
    }

    @Test
    public void restAssuredTest(){
        //create checklist
        CreateChecklistRequest createChecklistRequest = new CreateChecklistRequest();
        createChecklistRequest.setTrelloKey(trelloBO.getTrelloKey());
        createChecklistRequest.setTrelloToken(trelloBO.getTrelloToken());
        createChecklistRequest.setName(checklistName);
        createChecklistRequest.setCardId(cardId);

        CreateChecklistResponse createChecklistResponse = trelloBO.createChecklist(createChecklistRequest);

        Assert.assertEquals(createChecklistResponse.getStatusCode(), 200);
        Assert.assertEquals(createChecklistResponse.getChecklistName(), checklistName);

        //create checkitem
        CreateCheckItemRequest createCheckItemRequest = new CreateCheckItemRequest();

        createCheckItemRequest.setTrelloKey(trelloBO.getTrelloKey());
        createCheckItemRequest.setTrelloToken(trelloBO.getTrelloToken());
        createCheckItemRequest.setName(checkItemName);
        createCheckItemRequest.setChecklistId(createChecklistResponse.getChecklistId());

        CreateCheckItemResponse createCheckItemResponse = trelloBO.createCheckItem(createCheckItemRequest);

        Assert.assertEquals(createCheckItemResponse.getStatusCode(), 200);


        //delete checkitem
        DeleteCheckItemRequest deleteCheckItemRequest = new DeleteCheckItemRequest();

        deleteCheckItemRequest.setChecklistId(createCheckItemRequest.getChecklistId());
        deleteCheckItemRequest.setCheckItemId(createCheckItemResponse.getCheckItemId());
        deleteCheckItemRequest.setTrelloKey(trelloBO.getTrelloKey());
        deleteCheckItemRequest.setTrelloToken(trelloBO.getTrelloToken());

        DeleteCheckItemResponse deleteCheckItemResponse = trelloBO.deleteCheckItem(deleteCheckItemRequest);

        Assert.assertEquals(deleteCheckItemResponse.getStatusCode(), 200);

        //update checklist
        UpdateChecklistRequest updateChecklistRequest = new UpdateChecklistRequest();

        updateChecklistRequest.setChecklistId(createChecklistResponse.getChecklistId());
        updateChecklistRequest.setNewName(newChecklistName);
        updateChecklistRequest.setTrelloKey(trelloBO.getTrelloKey());
        updateChecklistRequest.setTrelloToken(trelloBO.getTrelloToken());

        UpdateChecklistResponse updateChecklistResponse = trelloBO.updateChecklist(updateChecklistRequest);

        Assert.assertEquals(updateChecklistResponse.getStatusCode(), 200);
        Assert.assertEquals(updateChecklistResponse.getChecklistName(), newChecklistName);
    }
}
