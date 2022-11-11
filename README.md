# Final project of Nybble Accademy
-> The project consist in automatizing 25 test cases chosen by my own working with [Ticktick](https://ticktick.com/) application.
The project requires good oop programming practices, a descriptive analysis made with Allure, high and low level tests cases development in addition with Jiras's kanvan board work. It has been developed using IntelliJ + Gradle in addition with SpotBugs for static code analysis.

-> **Functions tested**
* HABITS
* LISTS
* REGISTER-LOGIN-LOGOUT
* SEARCH
* SETTING
* STATISTICS VISUAL
* TAGS
* TASKS
* RECYCLING BIN

-> **Preconditions**
For running this project is necessary to have IntelliJ and Gradle installed
A web navegator may be necessary to see allure reports

-> **Comands**
In the command line > 
* **gradle clean test -PenvFile=qa.properties** for running all the tests in the project
* **gradle clean -x test -PenvFile=qa.properties tags -PtestSuite="tag"** for running tests that have a @Tag()
* **allure serve build\allure-results** for generating a report


  
