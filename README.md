# AndroidTesting
[![Build Status](https://travis-ci.org/thsaravana/AndroidTesting.svg?branch=master)](https://travis-ci.org/thsaravana/AndroidTesting) [![Quality Gate](https://sonarqube.com/api/badges/gate?key=AndroidTesting)](https://sonarqube.com/dashboard/index/AndroidTesting)

A sample android application to portray multiple stuff like Unit testing, Espresso, Code Coverage, SonarQube integration, etc..

./gradlew connectedAndroidTest -Pandroid.testInstrumentationRunnerArguments.annotation=com.samples.androidtesting.annotation.EspressoTest createDebugCoverageReport sonarqube
