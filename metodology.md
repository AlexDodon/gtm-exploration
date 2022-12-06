- there are two sides to setting up the exploration environment:
    - android application
    - gtm account and containers

- for the android application
    - setup the included android app
        - record setup instructions
            - instructions followed in setting up the app
                - get android studio
                - new project
                - basic activity
                - java
                - api 21: Android 5
            - removed all code related to setting up the two fragments of the basic app
            - added  3 events that run a callback each 2 seconds sequentially
    - run app in emulator from cli
    - kill it after a minute and 10 seconds
    - record ip packets

- setup new android container for each test
    - followed [this](https://developers.google.com/tag-platform/tag-manager/android/v5) for adding gtm support to android
    - created project in firebase with google analytics
    - added firebse to the app by following [this](https://firebase.google.com/docs/android/setup)
        - added the following line in buildscript > dependencies of the project build.gradle

                classpath 'com.google.gms:google-services:4.3.14'

        - added the follogin line in the plugins part of the app build.gradle

                id 'com.google.gms.google-services'
        - registered the app in the firebase app, downloaded google-services.json and put it in the app root directory
            - this file can be found in `collected/googleServices`
    - added google analytics to app by following [this](https://firebase.google.com/docs/analytics/get-started?platform=android)
        - added the following lines to the app build.gradle:

                implementation platform('com.google.firebase:firebase-bom:31.1.0')
                implementation 'com.google.firebase:firebase-analytics'
    - created gtm account and container
    - added gtm to the app by adding the following line to the app build.gradle:

            compile 'com.google.android.gms:play-services-tagmanager:18.0.2'
    - Click Versions in the top navigation bar.
    - Click Actions > Download on the selected container version.
    - include the container version to `app/src/main/assets/containers`
        - we saved the container version to `collected/emptyContainerVersion`

- third party tag
    - appsflyer
    - integration
        - add sdk in the app build file

                implementation 'com.appsflyer:af-android-sdk:6.9.0' 
        - add the following dependencies to the manifest

                <uses-permission android:name="android.permission.INTERNET" />
                <uses-permission android:name="android.permission.ACCESS_NETWORK_STATE" />
            - curios if we can do without it and in what situation?
            

- things to test
    - followed [this](https://nibarius.github.io/learning-frida/2022/05/21/sniffing-tls-traffic) to setup polar proxy for tls mitm
    - run with empty container
        - add analytics tag
            - remove analytics tag
        - add third party tag
            - remove third party tag
        - add analytics and third party tag
            - remove third party first
            - remove analytics 

findings:
    - run with empty container and
        - events logged
            - identified an encrypted quic connection to a google ip: 142.250.200.228
                - likely websockets over quic
        - no events logged
            - during a short capture; no comms were found