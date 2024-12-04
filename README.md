# GESTUREBRIDGE —— HUMAN CONNECTION FOR ALL 👋🌉

## PROJECT OVERVIEW
**GestureBridge** is a groundbreaking **sign language translation application** that leverages machine learning to create seamless communication between individuals who use sign language and those who don't. This innovative platform captures ASL sign language gestures through a camera, interprets them, converts them into written text, and vocalizes that text—offering a **real-time, accessible communication experience**.

At its core, GestureBridge is more a bridge to fostering **greater inclusivity and understanding** between communities. By breaking down communication barriers, we hope to empower individuals who are deaf or hard of hearing, as well as their families, friends, and colleagues. We believe that **human connection** is the foundation of any thriving society, and our mission is to help people connect through language, regardless of the medium they use. 🤝💬

The platform will initially support ASL fingerspelling, with plans to extend vocabulary and functionality over time. GestureBridge will continually evolve to offer better, more accurate sign language recognition and translation, creating a more inclusive environment for all

## CONTRIBUTORS
- Wania Sikandar Gondal (@waniagondal)
- Yibin Wang (@YIBIN35)
- Fang (Trent) Sheng (F@4NG66)
- Gavin Jiawei Song (@gavinsong45)
- Shuxiao Song (@SSX-song)

## TABLE OF CONTENTS
- [**GESTUREBRIDGE MANIFESTO**](#gesturebridge-manifesto)
- [**FEATURES**](#features)
- [**INSTALLATION GUIDE**](#installation-guide)
- [**USAGE GUIDE**](#usage-guide)
- [**LICENSE**](#license)
- [**FEEDBACK AND CONTRIBUTIONS**](#feedback-and-contributions)

## GESTUREBRIDGE MANIFESTO
At **GestureBridge**, we don’t just create software—we create **connections**. Our mission is to build a world where **language is no barrier** to understanding, communication, and human connection. We believe that **language**—whether spoken, written, or gestured—should empower people to share ideas, thoughts, and emotions without limitations. 

By using **GestureBridge**, you're not just accessing a tool—you're contributing to **a future where inclusivity, empathy, and understanding are the foundation** of all interactions. Together, we aim to create a more **accessible world** where **everyone is heard**, and **everyone belongs**, no matter how they communicate. 🌍💬

## FEATURES

- **Real-Time Sign Language Recognition** 🤖: GestureBridge can instantly recognize sign language via your webcam feed, allowing seamless interaction. Currently, the application supports fingerspelling, with plans to incorporate more gestures in future updates.
  
```
    public void startRecognition() throws IOException, InterruptedException {
        predictor.startRecognition(this::predictionToPresenter);
    }
    private void predictionToPresenter(String prediction) {
        SignLanguageRecognitionOutputData outputData = new SignLanguageRecognitionOutputData(prediction);
        signLanguagePresenter.updateView(outputData);
    }
```

- **Multilingual Language Translation** 🌐: Recognized signs are translated into multiple languages, broadening communication between individuals across linguistic divides.
  
```
    String translatedText = languageDataAccessObject.translate(language, text);
    SignLanguageTranslationOutputData signLanguageTranslationOutputData =
        new SignLanguageTranslationOutputData(translatedText);
    signLanguageTranslationPresenter.prepareSuccessView(signLanguageTranslationOutputData);
```

- **Text-to-Speech Conversion** 🔊: GestureBridge vocalizes the recognized text in real-time, allowing for spoken communication.

```
    TextToSpeechOutputData outputData = textToSpeechService.convertTextToSpeech(inputData);
    outputBoundary.prepareOutput(outputData);
```

- **Voice Customization 🎤**: Users can personalize the speech output by adjusting voice type, pitch, speed, and volume, making the interaction feel more natural, and respecting the identities of the users.

```
    voiceSettingsDataAccessObject.changeSettings(audioSettings);

    final CustomizeVoiceOutputData customizeVoiceOutputData = new CustomizeVoiceOutputData(audioSettings, false);
    voiceSettingsPresenter.prepareSuccessView(customizeVoiceOutputData);
```

- **Speech-to-Text Transcription** 📝: Voice input from the other individual is transcribed into text, displayed for the deaf or hard of hearing person.

```
    public void processSpeech(SpeechToTextInputData inputData) throws Exception {
        String onSpeechRecognition = speechRecognizer.recognize(inputData.getAudioData());
        SpeechToTextOutputData outputData = new SpeechToTextOutputData(onSpeechRecognition);
        speechToTextPresenter.deliverTranscription(outputData);
    }
```

## INSTALLATION GUIDE

### Requirements
To successfully run this project, you will need to install the following dependencies:

- **Python** (version 3.7 or higher)
- **MediaPipe** (version 0.10.18)
- **NumPy** (version 1.26.4)
- **OpenCV-Python** (version 4.10.0.84)
- **Pytorch** (version 2.5.1)
- **TorchVision** (version 0.20.1)
- **Google Cloud Libraries** (version 26.49.0) for Cloud Translation, Speech-to-Text, and Text-to-Speech APIs
- **CSC207 CheckStyle** (for code formatting)

### Installing Python and Machine Learning Dependencies
1. [Download Python](https://www.python.org/downloads/) (version 3.7 or higher) and install it.
2.  To install required Python libraries, run (in Python):

    ```bash
    pip install -r model_requirements.txt
    ```
    
### Installing Google Cloud APIs
Install the **Google Cloud APIs** by following the setup guides:
    - [Cloud Translation API](https://cloud.google.com/translate/docs/setup)
    - [Cloud Text-to-Speech API](https://cloud.google.com/text-to-speech/docs/before-you-begin)
    - [Cloud Speech-to-Text API](https://cloud.google.com/speech-to-text/docs/before-you-begin)

### Installing Checkstyle
- We recommend using IDEs for this project (e.g., IntelliJ IDEA, Eclipse). To install the CSC207 checkstyle, make sure the file
mystyle.xml is included in your repository, then paste the following code to checkstyle.xml file
```
<ConfigurationLocation id="a12e12d0-c511-43fb-8087-db6b548f5394" type="PROJECT_RELATIVE" scope="All" description="207 Checks">$PROJECT_DIR$/mystyle.xml</ConfigurationLocation>
```
- Set the checkstyle as default to check your code any time.

### Common Issues
**Q: I added the dependencies in my pom file, but the program still doesn't run, why?**
A: Try clicking on the pom file, go to the "Maven" option, and click "Reload Project". If it doesn't work ,try re-installing the dependencies
and checking if they are in the right version

**Q: I tried running the program but I'm getting API errors, why?**
A: It might be because you haven't added an appropriate API key. For Google Cloud APIs, you need to generate them on the console and use your own
API to access the functions. For more instructions, click [here](https://cloud.google.com/apis/docs/getting-started)

## USAGE GUIDE
1. **Webcam Access**: After downloading, ensure your webcam is accessible for sign language recognition.
   
3. **Gesture Recognition**: Perform a gesture to express the content, which will appear in the “Sign Language Recognition” text box.
   
3. **Translation**: Choose a language from the dropdown and click “Translate” to convert the recognized text into another language.
   
https://github.com/user-attachments/assets/1fb94de8-56ec-4cf3-808c-aa642d2d0cf1

4. **Text-to-Speech**: After translating the text, click “Text to Speech” to hear the translation.

https://github.com/user-attachments/assets/98782227-67ba-4af5-92a1-0d3fb0cc90cf
 
5. **Voice Customization**: Modify the voice settings (e.g., type, pitch, speed) by clicking the “Settings” button.

https://github.com/user-attachments/assets/1e16e11c-c808-40c7-af77-c3f6855e25c7

6. **Speech-to-Text**: To transcribe spoken language into text, click “Begin Transcription” and speak into the microphone, then click "End Transcription" once you have finished. Your transcription will appear in the transcription area.

https://github.com/user-attachments/assets/2aa36b9e-4560-4695-8f43-04b9d3be390e

## LICENSE
This project is licensed under the **Creative Commons** license. 

## FEEDBACK AND CONNECTIONS
We believe in the power of **collaboration** and the **importance of human connection**. Your feedback and contributions are vital to us. By participating, you're helping us create a more inclusive world where communication knows no barriers. 🌏

### Feedback
We value your opinions and suggestions to help us improve the project!
Here's how you can provide feedback:

- **How to Provide Feedback**:  
  - Send an email to [wania.gondal@mail.utoronto.ca](mailto:wania.gondal@mail.utoronto.ca) with "GestureBridge" in the subject.
  - Include your feedback, along with any relevant screenshots or code snippets.
  - You will receive an acknowledgement of your feedback within 48 hours.
  - Please check the issues tracker for further updates. If you provided your GitHub username when giving feedback, we will notify you when posting new changes.

### Contributions
We welcome contributions! Here's how you can help make GestureBridge even better:

1. **Fork the Repository**: Click the "Fork" button on GitHub.
2. **Clone Your Fork**: Clone the repository to your local machine using Git or GitHub Desktop.
3. **Create a Branch**:  
    ```bash
    git checkout -b feature/your-feature-name
    ```
4. **Make Your Changes**: Code, improve documentation, or fix bugs.
5. **Commit Your Changes**:
    ```bash
    git commit -m "Your description of changes"
    ```
6. **Push to Your Fork**:
    ```bash
    git push origin feature/your-feature-name
    ```
7. **Submit a Pull Request**: Open a PR on GitHub to propose your changes.

#### Guidelines for a Good Pull Request
- Ensure your branch is up to date with `main` to avoid conflicts.
- Provide a clear and detailed description of your changes.
- Ensure your changes adhere to **CSC207 CheckStyle**.

#### Review and Merge Protocols**
- Contributions and pull requests are reviewed weekly by the maintainers
- Your contribution should be constructive, addressing either an existing issue or 
help add a new feature
- Your contribution should pass all checkstyle scans before being pushed
- Once approved, your pull request will be merged to the main branch, and you will
be credited as a contributor!
