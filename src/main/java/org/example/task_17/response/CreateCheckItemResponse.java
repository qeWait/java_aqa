package org.example.task_17.response;

import io.restassured.path.json.JsonPath;
import lombok.Data;

@Data
public class CreateCheckItemResponse {
    private Integer statusCode;
    private JsonPath response;

    public CreateCheckItemResponse(Integer statusCode, JsonPath response) {
        this.statusCode = statusCode;
        this.response = response;
    }

    public String getCheckItemId(){
        return response.get("id");
    }

    public String getCheckItemName(){
        return response.get("name");
    }

    public String getCheckItemState(){
        return response.get("state");
    }

    public String getChecklistId(){
        return response.get("645d36f7ed8c8483b7ef73f4");
    }
}
