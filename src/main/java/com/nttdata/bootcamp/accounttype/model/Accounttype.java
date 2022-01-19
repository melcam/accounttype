package com.nttdata.bootcamp.accounttype.model;

import java.util.UUID;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "accounttype")
public class Accounttype {
    @Id
    private String id=UUID.randomUUID().toString();
    private String type;
    private Boolean status;
}
