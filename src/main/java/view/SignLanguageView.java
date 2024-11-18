package view;

import frameworks_and_drivers.PythonScriptRunner;

import javax.swing.*;
import java.awt.*;

public class SignLanguageGUI {
    private JTextArea displayArea;  // To show letters
    private PythonScriptRunner scriptRunner;
    private boolean running;

    public SignLanguageGUI(String pythonInterpreter, String scriptPath) {
        this.scriptRunner = new PythonScriptRunner(pythonInterpreter, scriptPath);
        initializeUI();
    }

    private void initializeUI() {
        JFrame frame = new JFrame("Sign Language Recognition");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 200);

        displayArea = new JTextArea();
        displayArea.setFont(new Font("Arial", Font.BOLD, 24));
        displayArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(displayArea);

        frame.add(scrollPane, BorderLayout.CENTER);
        frame.setVisible(true);
    }

    public void startRecognition() {
        running = true;
        new Thread(() -> {
            try {
                scriptRunner.runScriptContinuous((prediction) -> {
                    if (running) {
                        displayArea.append(prediction);
                    }
                });
            } catch (Exception e) {
                e.printStackTrace();
            }
        }).start();
    }

    public static void main(String[] args) {
        String pythonInterpreter = "python3";  // Adjust path if needed
        String scriptPath = "src/main/python/hand_gesture_recognition.py";

        SignLanguageGUI gui = new SignLanguageGUI(pythonInterpreter, scriptPath);
        gui.startRecognition();
    }
}
