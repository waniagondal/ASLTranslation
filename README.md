# GestureBridge

### Overview
Gesture bridge is a **sign language translation application** that captures sign language gestures via a camera, 
interprets the signs, converts them into written text, and then vocalizes the text for an accessible, real-time 
communication experience.  

The application will be both educational and assistive, supporting interactions between individuals who 
communicate in sign language and those unfamiliar with it, bridging communication barriers effectively. The 
project’s primary user base will be individuals who are deaf or hard of hearing, and its secondary users include 
family, friends, and colleagues who wish to communicate seamlessly with them.

### Contributors
Wania Sikandar Gondal, Fang (Trent) Sheng, Yibin Wang, Shuxiao Song, Gavin Jiawei Song

### Table of Contents
- [**Features**](#features-)
- [**Installation Instructions**](#installation-instructions-)
- [**Usage Guide**](#usage-guide)
- [**License**](#license)
- [**Feedback and Contributions**](#feedback-and-contributions)

### Features  
- **Real-Time Sign Language Recognition**: Recognized sign language through webcam feed and translates them instantly.
The project currently supports fingerspelling only, but more vocabulary will be added in the future.


- **Language Translation**: Translates recognized language into multiple languages, allowing the user to communicate
with a wider range of people.


- **Text-to-Speech Conversion**: Vocalizes the recognized text for real-time communication.


- **Voice Customization**: Allows the user to customize the speech output by modifying voice type, pitch, and speed.


- **Speech-to-Text Transcription**: Transcribes voice input from the other individual into text displayed for the deaf
or hard of hearing.

### Installation Instructions  
#### Requirements
To run this project successfully, you will need to install the following:
- Python (version 3.7 or higher)
- MediaPipe (version 0.10.18)
- NumPy (version 1.26.4)
- OpenCV-Python (version 4.10.0.84)
- Pytorch (version 2.5.1)
- TorchVision (version 0.20.1)
- Google Cloud Libraries (version 26.49.0): Cloud Translation API, Cloud Speech-to-Text API, Cloud Text-to-Speech API
- Google CheckStyle

#### Installing Python
To install Python (version 3.7 or higher), click this link and follow the instructions:  
(link here)

#### Installing Dependencies
To install Python and MediaPipe dependencies, you can download them using the
model_requirements.txt file in the src folder (this should be performed in Python):
```
pip install -r model_requirements.txt
```
To install the Google Cloud APIs, please follow the instructions provided in the links below:
- Google Cloud Translation API (link here)
- Google Cloud Text-to-Speech API (link here)
- Google Cloud Speech-to-Text API (link here)

#### Installing Google Checkstyle
- If you are using IDEs (e.g., IntelliJ IDEA, Eclipse), follow corresponding instructions to
install Google Checkstyle as a plugin.
- For Maven projects, you can also install Google Checkstyle by adding the following code to
your pom.xml file:
```
<plugin>
    <groupId>org.apache.maven.plugins</groupId>
    <artifactId>maven-checkstyle-plugin</artifactId>
    <version>3.2.2</version>
    <configuration>
        <configLocation>google_checks.xml</configLocation>
        <encoding>UTF-8</encoding>
    </configuration>
    <executions>
        <execution>
            <phase>verify</phase>
            <goals>
                <goal>check</goal>
            </goals>
        </execution>
    </executions>
</plugin>
```
#### Common Issues
(need more content here)

### Usage Guide
- After the project is downloaded, please allow access to your webcam to enable real-time
sign language recognition feature


- Gesture the content you wish to express, and it will show up in the “Sign Language 
Recognition” text box below.


- To translate the recognized into different languages to communicate with different 
individuals, select a language from the drop-down menu below the text box and click on 
the “Translate” button.


- To convert the recognized sign language from text to speech, click on the “Text to 
Speech” button, and the speech output will be generated. If you wish for the speech output
to be in a different language, please ensure you have translated the text into the desired 
language before using this function.


- To modify the voice of the speech output, click on “Settings”. A pop-up page will appear 
with a series of sliders to help you adjust the voice type (male/female), pitch, speed 
(and volume) of the speech output.


-  To transcribe spoken language to text, click on the “Begin Transcription” button and 
speak into the microphone, then click “End Transcription”. Words will appear in 
the transcription area.

### License
This code is intended to be accessible for all users as long as the original source is cited.

### Feedback and Contributions
We welcome feedback and contributions to help us improve this project! If you wish to get 
involved, follow these instructions:

#### Report Issues
If you want to report a bug/error or request more features, please open an issue in the 
Issues Section on GitHub.

#### Submit Contributions
If you want to contribute to the project:
1. Fork the repository
2. Create your own branch
3. Follow Google Checkstyle and code your changes
4. Push your commits to your forked repository
5. Create a pull request and describe the changes you made

#### Provide Feedback
If you want to provide suggestion and feedback, or ask questions, please contact us 
at (email here)





