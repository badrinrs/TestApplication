# TestApplication
A Test Application for Compose Test Automation with Release builds

## Steps to run compose test automation
### How to run the app
  ```./gradlew clean assembleRelease assembleReleaseAndroidTest```
  
  ```adb install app-release```
  
  ```adb install app-release-androidTest```

  ```adb shell am instrument -w com.cucumber.testapplication.test/androidx.test.runner.AndroidJUnitRunner```

### Expected
  The tests should finish successfully

### Actual
  The tests hang on splash screen
