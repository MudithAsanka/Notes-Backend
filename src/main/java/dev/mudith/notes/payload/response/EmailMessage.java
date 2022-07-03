package dev.mudith.notes.payload.response;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EmailMessage {

    private String to;
    private String subject;
    private String message;

    public EmailMessage() {
    }

    public EmailMessage(String to, String subject, String message) {
        this.to = to;
        this.subject = subject;
        this.message = message;
    }
}
