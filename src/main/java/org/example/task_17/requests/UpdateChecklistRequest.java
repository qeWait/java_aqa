package org.example.task_17.requests;

import lombok.Data;

@Data
public class UpdateChecklistRequest {
    private String checklistId;
    private String newName;
    private String trelloKey;
    private String trelloToken;
}
