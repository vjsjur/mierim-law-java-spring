package mierim.model.entity;

import javax.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Book implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String title;
    private String author;
    private String publisher;
    private Integer pages;

    public boolean equals(Object obj) {

        Book book = (Book) obj;

        return (book.getTitle() != null && book.getTitle().equals(title)) && (book.getAuthor() != null && book.getAuthor().equals(author));
    }

    public int hashCode() {
        int hash = 1;
        if(title != null)
            hash = hash * 31 + title.hashCode();
         
        if(author != null)
            hash = hash * 29 + author.hashCode();
 
        return hash;
    }
}
