package org.example.task_17.response;

import io.restassured.path.json.JsonPath;
import lombok.Data;

@Data
public class CreateChecklistResponse {
    private Integer statusCode;
    private JsonPath response;

    public CreateChecklistResponse(Integer statusCode, JsonPath response) {
        this.statusCode = statusCode;
        this.response = response;
    }

    public String getChecklistId(){
        return response.get("id");
    }
    public String getChecklistName(){
        return response.get("name");
    }
    public String getBoardId(){
        return response.get("idBoard");
    }
    public String getCardId(){
        return response.get("idCard");
    }
}
