package org.example.task_17.response;

import io.restassured.path.json.JsonPath;
import lombok.Data;

@Data
public class UpdateChecklistResponse {
    private Integer statusCode;
    private JsonPath response;

    public UpdateChecklistResponse(Integer statusCode, JsonPath response) {
        this.statusCode = statusCode;
        this.response = response;
    }

    public String getChecklistId(){
        return response.get("id");
    }
    public String getChecklistName(){
        return response.get("name");
    }
    public String getIdBoard(){
        return response.get("idBoard");
    }
    public String getIdCard(){
        return response.get("idCard");
    }
}
