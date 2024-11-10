import torch
import torch.nn as nn
import torch.optim as optim
from torch.utils.data import DataLoader, Dataset

class SignLanguageModel(nn.Module):
    def __init__(self):
        super(SignLanguageModel, self).__init__()
        self.fc1 = nn.Linear(63, 256)
        self.bn1 = nn.BatchNorm1d(256)
        self.fc2 = nn.Linear(256, 128)
        self.bn2 = nn.BatchNorm1d(128)
        self.fc3 = nn.Linear(128, 64)
        self.bn3 = nn.BatchNorm1d(64)
        self.fc4 = nn.Linear(64, 26)
        self.dropout = nn.Dropout(0.5)

    def forward(self, x):
        x = torch.relu(self.bn1(self.fc1(x)))
        x = self.dropout(x)
        x = torch.relu(self.bn2(self.fc2(x)))
        x = self.dropout(x)
        x = torch.relu(self.bn3(self.fc3(x)))
        x = self.fc4(x)
        return x

class SignLanguageDataset(Dataset):
    def __init__(self, data, labels):
        self.data = data
        self.labels = labels

    def __len__(self):
        return len(self.data)

    def __getitem__(self, idx):
        return self.data[idx], self.labels[idx]

class SignLanguageTrainer:
    def __init__(self, model, data, labels, batch_size=32, epochs=50, learning_rate=0.001, patience=5):
        """
        Initialize the trainer with the model, data, labels, and training parameters.
        """
        self.model = model
        self.data = data
        self.labels = labels
        self.batch_size = batch_size
        self.epochs = epochs
        self.learning_rate = learning_rate
        self.patience = patience

        self.criterion = nn.CrossEntropyLoss()
        self.optimizer = optim.Adam(self.model.parameters(), lr=self.learning_rate)

        self.scheduler = optim.lr_scheduler.ReduceLROnPlateau(self.optimizer, 'min', patience=3, factor=0.5)

    def train(self):
        """
        Train the model using the specified data, labels, and hyperparameters.
        """
        best_loss = float('inf')
        patience_counter = 0

        data_tensor = torch.tensor(self.data, dtype=torch.float32)
        labels_tensor = torch.tensor(self.labels, dtype=torch.long)

        dataset = SignLanguageDataset(data_tensor, labels_tensor)
        dataloader = DataLoader(dataset, batch_size=self.batch_size, shuffle=True)

        for epoch in range(self.epochs):
            self.model.train()
            running_loss = 0.0
            correct_preds = 0
            total_preds = 0

            for inputs, targets in dataloader:
                self.optimizer.zero_grad()

                outputs = self.model(inputs)
                loss = self.criterion(outputs, targets)

                loss.backward()
                self.optimizer.step()

                running_loss += loss.item()

                _, predicted = torch.max(outputs, 1)

                correct_preds += (predicted == targets).sum().item()
                total_preds += targets.size(0)

            epoch_loss = running_loss / len(dataloader)
            accuracy = correct_preds / total_preds

            self.scheduler.step(epoch_loss)

            current_lr = self.scheduler.optimizer.param_groups[0]['lr']
            print(f"Epoch {epoch + 1}/{self.epochs}, Loss: {epoch_loss:.4f}, Accuracy:"
                  f" {accuracy:.4f}, Learning Rate: {current_lr:.6f}")

            if epoch_loss < best_loss:
                best_loss = epoch_loss
                patience_counter = 0
            else:
                patience_counter += 1
                if patience_counter >= self.patience:
                    print(f"Early stopping at epoch {epoch + 1}")
                    break

        print("Training complete!")

    def save_model(self, path):
        """
        Save the trained model's weights to the specified file.
        """
        torch.save(self.model.state_dict(), path)
        print(f"Model saved as '{path}'")