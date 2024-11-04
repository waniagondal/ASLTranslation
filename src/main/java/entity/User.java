package entity;

public class User {
    private final String userID;
    private final String password;
    private final String languagePref;

    User(String userID, String password, String languagePref) {
        this.userID = userID;
        this.password = password;
        this.languagePref = languagePref;
    }

    public String getUserID() {
        return userID;
    }

    public String getLanguagePref() {
        return languagePref;
    }

    public String getPassword() {
        return password;
    }
}
