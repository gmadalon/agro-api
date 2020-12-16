package br.com.mgn.agro.entity;

import java.time.LocalDate;

import javax.validation.constraints.NotBlank;

import org.hibernate.validator.constraints.br.CPF;
import org.springframework.data.mongodb.core.index.IndexDirection;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.util.StringUtils;

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
    @NotBlank(message = "First name is required!")
    private String forename;
    @Setter
    @Getter
    @NotBlank(message = "Last name is required!")
    private String lastName;
    @Setter
    @Getter
    @NotBlank(message = "Email is required!")
    @Indexed(name = "email_idx", direction = IndexDirection.DESCENDING, unique = true)
    private String email;
    @Getter
    @CPF(message="CPF is invalid")
    @Indexed(name = "cpf_idx", direction = IndexDirection.DESCENDING, unique = true)
    private String cpf;
    @Getter
    @Setter
    private LocalDate birthDate;
    @Getter
    private String phone;
    @Getter
    @Setter
    private String documentId;

    public Person(String forename, String lastName, String email) {
        this.forename = forename;
        this.lastName = lastName;
        this.email = email;
    }

    public static Person of(String forename, String lastname, String email) {
        return new Person(forename,lastname, email);
    }

    public void setPhone(String phone) {

        if(!StringUtils.hasText(phone)) {
            phone = phone.replaceAll("[^\\d.]", "");
        }
        this.phone = phone;
    }
    

}
