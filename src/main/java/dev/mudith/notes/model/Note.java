package dev.mudith.notes.model;

import com.sun.javafx.beans.IDProperty;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@Document("notes")
public class Note {

    @Id
    private String noteId;
    @DBRef
    private User user;
    private String title;
    private String description;

    public Note() {
    }

    public Note(User user, String title, String description) {
        this.user = user;
        this.title = title;
        this.description = description;
    }
}
