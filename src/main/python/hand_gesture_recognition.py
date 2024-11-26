import cv2
import mediapipe as mp
import torch
import numpy as np
import time
from model.train_model import SignLanguageModel

class HandDetector:
    """Class for detecting hand landmarks using MediaPipe."""
    def __init__(self, min_detection_confidence=0.5, min_tracking_confidence=0.5):
        self.mp_hands = mp.solutions.hands
        self.hands = self.mp_hands.Hands(
            min_detection_confidence=min_detection_confidence,
            min_tracking_confidence=min_tracking_confidence
        )

    def extract_hand_landmarks(self, frame):
        """Extract and flatten landmarks from an image using MediaPipe."""
        rgb_frame = cv2.cvtColor(frame, cv2.COLOR_BGR2RGB)
        results = self.hands.process(rgb_frame)

        if results.multi_hand_landmarks:
            landmarks = []
            for landmark in results.multi_hand_landmarks[0].landmark:
                landmarks.append([landmark.x, landmark.y, landmark.z])
            return np.array(landmarks).flatten()
        return None

class GestureRecognizer:
    """Class for loading the model and making predictions on hand landmarks."""
    def __init__(self, model_filepath):
        self.model = SignLanguageModel()
        self.model.load_state_dict(torch.load(model_filepath, weights_only=True))
        self.model.eval()

    def predict(self, landmarks_array):
        """Predict the sign language gesture from the hand landmarks."""

        landmarks_array = landmarks_array / np.max(landmarks_array)
        input_tensor = torch.tensor(landmarks_array, dtype=torch.float32).unsqueeze(0)

        with torch.no_grad():
            outputs = self.model(input_tensor)
            _, predicted_class = torch.max(outputs, 1)

        predicted_label = chr(predicted_class.item() + ord('A'))
        return predicted_label

class SignLanguageApp:
    """Main class to run the sign language recognition application."""
    def __init__(self, model_filepath, webcam_index=0):
        self.hand_detector = HandDetector()
        self.gesture_recognizer = GestureRecognizer(model_filepath)
        self.cap = cv2.VideoCapture(webcam_index)
        self.previous_label = None
        self.start_time = None
        self.hold_threshold = 1.0  # seconds

    def run(self):
        """Run the webcam loop for sign language recognition."""
        if not self.cap.isOpened():
            print("Error: Could not open webcam.")
            return

        while self.cap.isOpened():
            ret, frame = self.cap.read()
            if not ret:
                continue

            frame = cv2.flip(frame, 1)

            landmarks_array = self.hand_detector.extract_hand_landmarks(frame)
            if landmarks_array is not None:
                predicted_label = self.gesture_recognizer.predict(landmarks_array)

                # Check if the gesture is held for the required duration
                current_time = time.time()
                if predicted_label == self.previous_label:
                    if self.start_time is None:
                        self.start_time = current_time
                    elif current_time - self.start_time >= self.hold_threshold:
                        print(predicted_label, flush=True)
                        self.start_time = None  # Reset after printing
                else:
                    # Reset if the gesture changes
                    self.previous_label = predicted_label
                    self.start_time = current_time

                cv2.putText(frame, f'Predicted: {predicted_label}', (12, 60),
                            cv2.FONT_HERSHEY_COMPLEX, 2, (0, 0, 0), 4, cv2.LINE_AA)

            cv2.imshow("Sign Language Gesture Recognition", frame)

            if cv2.waitKey(1) & 0xFF == ord('q'):
                break

        self.cap.release()
        cv2.destroyAllWindows()

def main():
    model_filepath = "src/main/python/model/ASL_model_92%.pth"
    app = SignLanguageApp(model_filepath)
    app.run()

if __name__ == "__main__":
    main()
    
