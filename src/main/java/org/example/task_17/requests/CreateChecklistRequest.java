package org.example.task_17.requests;

import lombok.Data;

@Data
public class CreateChecklistRequest {
    private String cardId;
    private String name;
    private String trelloKey;
    private String trelloToken;
}
