/* User.java
   User POJO class
   Author: Hope Ringane (221174109)
   Date: 11 May 2025 */

package za.ac.cput.domain;

import jakarta.persistence.*;

import java.time.ZonedDateTime;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)

public abstract class User {
    @Id
    protected String userId;
    protected String firstName;
    protected String lastName;
    protected String phoneNumber;
    protected String email;
    protected String password;
    protected ZonedDateTime createdAt;

    public String getUserId() {
        return userId;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public ZonedDateTime getCreatedAt() {
        return createdAt;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setCreatedAt(ZonedDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public abstract String toString();
}


