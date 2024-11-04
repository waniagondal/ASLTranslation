package entity;

import java.util.List;

public class Gesture {
    private final String gestureID;
    private final String gestureName;
    private final List<List> gestureCoordinates;
    private final String translation;
    private final int confidenceScore;

    Gesture(String gestureID, String gestureName, List<List> gestureCoordinates, String translation,
            int confidenceScore) {
        this.gestureID = gestureID;
        this.gestureName = gestureName;
        this.gestureCoordinates = gestureCoordinates;
        this.translation = translation;
        this.confidenceScore = confidenceScore;
    }

    public int getConfidenceScore() {
        return confidenceScore;
    }

    public List<List> getGestureCoordinates() {
        return gestureCoordinates;
    }

    public String getGestureID() {
        return gestureID;
    }

    public String getGestureName() {
        return gestureName;
    }

    public String getTranslation() {
        return translation;
    }
}
