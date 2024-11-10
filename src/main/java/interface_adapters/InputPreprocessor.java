package interface_adapters;

import entity.Gesture;
import java.util.List;

public class InputPreprocessor {
// just a breif implement
    private InputPreprocessor() {
        throw new UnsupportedOperationException("Utility class should not be instantiated");
    }

    public static float[] preprocess(List<List<Float>> gestureCoordinates) {

        int pointCount = gestureCoordinates.size();
        float[] modelInput = new float[pointCount * 2];  // assume every points have x and y coor

        for (int i = 0; i < pointCount; i++) {
            List<Float> point = gestureCoordinates.get(i);
            modelInput[i * 2] = point.get(0);  // x
            modelInput[i * 2 + 1] = point.get(1);  // y
        }
        return modelInput;
    }
}