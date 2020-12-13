package br.com.mgn.agro.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Field;

public abstract class AbstractEntity {

    @Id
    @Field("_id")
    private String id;    
}
