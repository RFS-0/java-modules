package ch.resrc.domain.user;

public class User {
    String email;
    String givenName;
    String familyName;
    String password;

    public User(String email, String givenName, String familyName, String password) {
        this.email = email;
        this.givenName = givenName;
        this.familyName = familyName;
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getGivenName() {
        return givenName;
    }

    public void setGivenName(String givenName) {
        this.givenName = givenName;
    }

    public String getFamilyName() {
        return familyName;
    }

    public void setFamilyName(String familyName) {
        this.familyName = familyName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
