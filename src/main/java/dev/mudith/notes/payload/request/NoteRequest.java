package dev.mudith.notes.payload.request;

import dev.mudith.notes.model.User;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class NoteRequest {

    private String noteId;
    private User user;
    private String title;
    private String description;

    public NoteRequest() {
    }

    public NoteRequest(User user, String title, String description) {
        this.user = user;
        this.title = title;
        this.description = description;
    }

}
