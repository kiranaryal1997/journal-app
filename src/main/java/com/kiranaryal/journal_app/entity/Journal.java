package com.kiranaryal.journal_app.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;

@Document(collection = "journals")
@Data
@NoArgsConstructor
public class Journal {

    @Id
    private ObjectId id;
    @NonNull
    private String title;
    private String content;
    private LocalDate date;
}
