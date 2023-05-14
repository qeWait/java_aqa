package org.example.task_17.requests;

import lombok.Data;

@Data
public class CreateCheckItemRequest {
    private String name;
    private String checklistId;
    private String trelloKey;
    private String trelloToken;
}
