package dev.mudith.notes.payload.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserRequest {

    private String firstName;
    private String lastName;
    private String email;
    private String dateOfBirth;
    private String mobile;
    private String password;
    private String accountStatus;
    private String accountType;

    public UserRequest() {
    }

    public UserRequest(String firstName, String lastName, String email, String dateOfBirth, String mobile, String password, String accountStatus, String accountType) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.dateOfBirth = dateOfBirth;
        this.mobile = mobile;
        this.password = password;
        this.accountStatus = accountStatus;
        this.accountType = accountType;
    }
}
