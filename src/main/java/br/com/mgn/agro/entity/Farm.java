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
import lombok.ToString;
import nonapi.io.github.classgraph.json.Id;

@Document
@ToString
@EqualsAndHashCode
public class Farm {

    @Id
    private Long id;

    @Getter
    @DBRef
    private Person owner;

    @Getter
    private String name;

    @Getter
    private String description;
  
    @Indexed
    private Set<String> keywords = new HashSet<>();

    protected Farm(Person owner, String name, String description) {
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

    public Set<String> getKeywords() {
        return Collections.unmodifiableSet(this.keywords);
    }

    
}
