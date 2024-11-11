# CSC207-Project
Final Project for CSC207

Team User Story:
1. Gesture Detection/Tracking ✅
2. Model training ✅
3. Integration of Model so text is displayed ✅
4. text display + pretty UI/UX integration ✅
5. Testing (done through checking accuracy on each gesture - wania (not shown in commits) ✅

__
1. **Secondary User Story:** As a user who is unfamiliar with sign language, I want the application to vocalize the interpreted text so I can hear what the person (who is hard of hearing) is communicating with their sign language **(Shuxiao)**.
**Expanded Implementation Plan:**
-Use the Google Text-to-Speech API to convert interpreted text into spoken language.
-Inject this API into a button labeled "Speak" or "Voice Output."
-Set up a speak button that triggers the API with the interpreted text as input.
-Design a loading or processing indicator (e.g., a spinner or progress bar) to show that the speech synthesis is in progress.
__
2. **Language Selection Story:** As a user, I want to use sign language and have translations in various spoken languages (like English or French), so I can communicate with a wider range of users **(Ebin)**.
**Expanded Implementation Plan:**
-Use the Google Translate API to translate the interpreted text into the selected spoken language.
-Add a language selection dropdown that offers a variety of languages.
-Include a UI dropdown or toggle menu for language selection.
-Save the user’s preferred language in their profile settings (if logged in).
-Speech Output in Selected Language
-Chain the Google Translate API output with the Google Text-to-Speech API.
-After translating the text, send the translated text to the Text-to-Speech API to vocalize it in the selected language.
__
3. **Customization Story:** As a user, I want to customize the voice and speed of the spoken output in the application, so I can tailor the experience to my preferences or need **(Gavin)**.
**Expanded Implementation Plan:**
-Create a settings menu with options to adjust: Voice type (male, female, etc.), Speaking speed (slow, normal, fast)
-Store these settings in user preferences if logged in.
-Configure parameters for voice and speed customization within the Google Text-to-Speech API requests.
-Bind the selected customization settings in the UI to dynamically adjust API requests.
__
4. **Login Story:** As a user, I want to log in using either email or social media to securely access my profile and settings **(Wania)**.
**Expanded Implementation Plan:**
-Implement authentication options for both email and social media login (e.g., using OAuth for Google, Facebook).
-Use secure methods to handle user credentials and token storage (Lab Five for Inspiration)
-Display error messages for login failures (e.g., incorrect password, network issues).
__
5. **Transcription for Hearing Impairments Story:** As a user with hearing impairments, I want the application to transcribe the spoken words of others into text, so I can read what they are saying and engage in the conversation effectively **(Trent(Fang))**.
**Expanded Implementation Plan:**
-Use the Speech-To-Text API to convert audio input into text transcription.
-Enable a microphone button that triggers the transcription function and listens for audio input.
-Display transcribed text in real-time or with minimal delay in a dedicated area on the app interface.
-Provide an option to pause or stop transcription as needed.
