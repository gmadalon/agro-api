package br.com.mgn.agro.entity;

import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.util.CollectionUtils;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Document
@ToString
@EqualsAndHashCode(callSuper=false)
@NoArgsConstructor
public class Farm extends AbstractEntity {
  
    @Getter
    @Setter
    @DBRef
    private Person owner;

    @Getter
    @Setter
    private String name;

    @Getter
    @Setter
    private String description;
  
    @Getter
    @Indexed
    private Set<String> keywords = new HashSet<>();

    public Farm(Person owner, String name, String description) {
        this.owner = owner;
        this.name = name;
        this.description = description;
    }
    
    public static Farm of(Person owner, String name, String description) {
        return new Farm(owner, name, description);
    }

    public void addKeyWord(String keyWord) {
        keywords.add(keyWord);
    }

    public void removeKeyWord(String keyWord) {
        keywords.remove(keyWord);
    }

    public void replaceAll(Collection<String> keyWords) {
        
        if(!CollectionUtils.isEmpty(keyWords)) {
            for( String keyWord : keyWords ) {
                this.keywords.add(keyWord);
            } 
        }

    }

    
}
