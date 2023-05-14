package org.example.task_17.response;

import io.restassured.path.json.JsonPath;
import lombok.Data;

@Data
public class DeleteCheckItemResponse {
    private Integer statusCode;
    private JsonPath response;

    public DeleteCheckItemResponse(Integer statusCode, JsonPath response) {
        this.statusCode = statusCode;
        this.response = response;
    }
}
