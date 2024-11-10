import os
import cv2
import numpy as np
import mediapipe as mp

from train_model import SignLanguageModel, SignLanguageTrainer

MG_HEIGHT, IMG_WIDTH = 224, 224
MAX_IMAGES_PER_FOLDER = 100
DATA_DIR = "resources/asl_dataset"
OUTPUT_LANDMARKS_FILE = "resources/landmarks_data.npy"
OUTPUT_LABELS_FILE = "resources/labels.npy"

class HandLandmarkExtractor:
    def __init__(self):
        """Initialize the MediaPipe Hands solution."""
        self.mp_hands = mp.solutions.hands
        self.hands = self.mp_hands.Hands(static_image_mode=True, max_num_hands=1)

    def extract_landmarks(self, image):
        """Extract and flatten landmarks from an image using MediaPipe."""
        image_rgb = cv2.cvtColor(image, cv2.COLOR_BGR2RGB)
        results = self.hands.process(image_rgb)

        if results.multi_hand_landmarks:
            flattened_landmarks = []
            for hand_landmarks in results.multi_hand_landmarks:
                for landmark in hand_landmarks.landmark:
                    flattened_landmarks.extend([landmark.x, landmark.y, landmark.z])
            return flattened_landmarks
        else:
            return [0] * 63

class DatasetProcessor:
    def __init__(self, data_dir, max_images_per_folder):
        self.data_dir = data_dir
        self.max_images_per_folder = max_images_per_folder
        self.landmark_extractor = HandLandmarkExtractor()

    def process_folder(self, folder_name):
        """Process all images in a given folder and return corresponding landmarks and labels."""
        folder_path = os.path.join(self.data_dir, folder_name)
        images = os.listdir(folder_path)

        data, labels = [], []
        image_count = 0

        for filename in images:
            if image_count >= self.max_images_per_folder:
                break

            image_path = os.path.join(folder_path, filename)
            img = cv2.imread(image_path)

            if img is None:
                print(f"Error loading image: {image_path}")
                continue

            landmarks = self.landmark_extractor.extract_landmarks(img)
            data.append(landmarks)
            labels.append(folder_name)
            image_count += 1

        return data, labels

class LabelEncoder:
    @staticmethod
    def encode_labels(labels):
        """Encode string labels as integers."""
        label_map = {label: idx for idx, label in enumerate(sorted(set(labels)))}
        encoded_labels = np.array([label_map[label] for label in labels])
        return encoded_labels, label_map


class DataSaver:
    @staticmethod
    def save_data(data, labels, landmarks_file, labels_file):
        """Save the processed data and labels as .npy files."""
        np.save(landmarks_file, data)
        np.save(labels_file, labels)
        print(f"Data saved to {landmarks_file} and {labels_file}")


class SignLanguageDataPreprocessor:
    def __init__(self, data_dir, max_images_per_folder, landmarks_file, labels_file):
        self.data_dir = data_dir
        self.max_images_per_folder = max_images_per_folder
        self.landmarks_file = landmarks_file
        self.labels_file = labels_file

        self.dataset_processor = DatasetProcessor(data_dir, max_images_per_folder)
        self.data_saver = DataSaver()

    def preprocess_data(self):
        """Preprocess the dataset by extracting landmarks and labels."""
        data, labels = [], []

        for folder_name in sorted(os.listdir(self.data_dir)):
            folder_data, folder_labels = self.dataset_processor.process_folder(folder_name)
            data.extend(folder_data)
            labels.extend(folder_labels)
            print(f"Processed folder {folder_name}")

        encoded_labels, label_map = LabelEncoder.encode_labels(labels)

        self.data_saver.save_data(data, encoded_labels, self.landmarks_file, self.labels_file)

        return np.array(data), encoded_labels

def main():
    """"""
    preprocessor = SignLanguageDataPreprocessor(
        DATA_DIR, MAX_IMAGES_PER_FOLDER, OUTPUT_LANDMARKS_FILE, OUTPUT_LABELS_FILE)
    data, labels = preprocessor.preprocess_data()

    model = SignLanguageModel()
    trainer = SignLanguageTrainer(model, data, labels)

    trainer.train()
    trainer.save_model('sign_language_model.pth')

if __name__ == "__main__":
    main()