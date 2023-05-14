package org.example.task_17.requests;

import lombok.Data;

@Data
public class DeleteCheckItemRequest {
    private String checklistId;
    private String checkItemId;
    private String trelloKey;
    private String trelloToken;
}
