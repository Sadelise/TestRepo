package lukuvinkkikirjasto.domain;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.jpa.domain.AbstractPersistable;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@EqualsAndHashCode(callSuper = true)
public class Book extends AbstractPersistable<Long> implements Tip {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String title;
    private String author;
    private String description;
    private String ISBN;

    private boolean read = false;

    public Book(String title, String author) {
        this(1L, title, author, "", "", false);
    }

    public boolean markRead() {
        if (this.read) {
            return false;
        }
        this.read = true;
        return true;
    }

    @Override
    public String toString() {
        String r;
        if (read) {
            r = "Read";
        } else {
            r = "Not read";
        }
        return "Author: " + this.author + "\nTitle: " + this.title + "\nDescription: " + this.description + "\nISBN: " + this.ISBN + "\n" + r;
    }
}
