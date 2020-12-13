package br.com.mgn.agro.entity;

import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Document
@ToString
@EqualsAndHashCode(callSuper=false)
@NoArgsConstructor
public class Person extends AbstractEntity  {
  
    @Setter
    @Getter
    private String forename;
    @Setter
    @Getter
    private String lastname;
    @Setter
    @Getter
    private String email;

    public Person(String forename, String lastname, String email) {
        this.forename = forename;
        this.lastname = lastname;
        this.email = email;
    }

    public static Person of(String forename, String lastname, String email) {
        return new Person(forename,lastname, email);
    }

}
