package entity;

public class User {
    private final String userID;
    private final String languagePref;

    User(String userID, String languagePref) {
        this.userID = userID;
        this.languagePref = languagePref;
    }

    public String getUserID() {
        return userID;
    }

    public String getLanguagePref() {
        return languagePref;
    }
}
