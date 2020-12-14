package br.com.mgn.agro.entity;

import org.springframework.data.annotation.Id;

import lombok.Getter;
import lombok.Setter;

public abstract class AbstractEntity {

    @Id
    @Getter
    @Setter
    private String id;
}
