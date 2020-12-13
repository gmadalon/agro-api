package br.com.mgn.agro.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Document
@Getter
@ToString
@EqualsAndHashCode
public class Person {

    @Id
    private Long id;
  
    @Setter
    private String forename;
    @Setter
    private String lastname;
    @Setter
    private String email;

    protected Person(String forename, String lastname, String email) {
        this.forename = forename;
        this.lastname = lastname;
        this.email = email;
    }

    public static Person of(String forename, String lastname, String email) {
        return new Person(forename,lastname, email);
    }

}
