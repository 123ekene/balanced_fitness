package com.balanced.app.ws.io.entity;



import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;

@Entity(name="users") //Name of the table to store user records. User entity is used to presist data into a database
public class UserEntity implements Serializable {
    private static final long serialVersionUID = 8456597338888326648L;

    @Id //primary key
    @GeneratedValue //auto incremented when a new value is added
    private long id;

    @Column(nullable = false) //value in inserted into column can not be null
    private String userId;

    @Column(nullable = false, length = 50)//value inserted into column can not be null. Max length is 50 characters
    private String firstName;

    @Column(nullable = false, length = 50)//value inserted into column can not be null. Max length is 50 characters
    private String lastName;

    @Column(nullable = false, length = 120, unique = true)//value inserted into column can not be null. Max length is 50 characters
    private String email;

    @Column(nullable = false) //value in inserted into column can not be null
    private String encryptedPassword;


    private String emailVerificationToken;

 //  @Column(nullable = false, columnDefinition = "boolean default false") //value in inserted into column can not be null. Make default value false
    @Column(nullable = false)
    private Boolean emailVerificationStatus ;//= false;


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEncryptedPassword() {
        return encryptedPassword;
    }

    public void setEncryptedPassword(String encryptedPassword) {
        this.encryptedPassword = encryptedPassword;
    }

    public String getEmailVerificationToken() {
        return emailVerificationToken;
    }

    public void setEmailVerificationToken(String emailVerificationToken) {
        this.emailVerificationToken = emailVerificationToken;
    }

    public Boolean getEmailVerificationStatus() {
        return emailVerificationStatus;
    }

    public void setEmailVerificationStatus(Boolean emailVerificationStatus) {
        this.emailVerificationStatus = emailVerificationStatus;
    }
}
