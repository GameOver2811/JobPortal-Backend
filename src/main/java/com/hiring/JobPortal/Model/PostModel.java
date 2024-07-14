package com.hiring.JobPortal.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "Job")
public class PostModel {
    private String profile;
    private String des;
    private int exp;
    private String[] tech;
}
