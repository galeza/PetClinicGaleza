# PetClinicGaleza

This is maven Java and Selenium testing framework for https://github.com/thymeleaf/thymeleafexamples-petclinic


# Getting Started
Download project from github. Project can be run in eclipse or in console using following commands: 

1. run tests:
mvn -Dtest=PetClinicTest test
2. run a concrete test:
mvn -Dtest=PetClinicTest#validatePetName test
3. run tests with resport:
mvn surefire-report:report
4. run maven clean install:
mvn clean install surefire-report:report
5. the simpliest run:
mvn test 


# Project structure
This is a Maven project with the following structure:

├── src/main/java/ - contains page objects, util classes, helpers, driver
├── src/main/resources - contains project properties
├── src/test/java - contains base test class, listener, tests
├── src/test/resources - contains logs, log4j2 xml configuration file.

1. Structure

![Alt text](./project_structure.png?raw=true "Project Structure")

Project uses the following test automation concepts: 
	page factory
	base classes
	html classes
	test listeners
	test ng and assertj assertions 	
	annotations
	screenshots
	saving errors in text files

2. Project details:

* *Maven project* *
- all dependencies are managed using the pom.xml file

* *Test NG* *
- unit testing library

* *Java JDK 8* *
- used for streams

* *Page Factory* *
- **ru.yandex.qatools.htmlelements** library is used
- pattern for creating page object and page fragment classes
- the elements of page object/fragment classes have names and locators
- names and locators are implemented using annotations

* *projectlombok* *
- for generating getters and setters

* *assertj* *
- used for soft assertion

# Prerequisites

## Built With:
Java 8
Eclipse + SonarLint + Maven compiler 1.8
Selenium 3.141.59 version

# How to use eclipse

## run from eclipse
-setup the built in run. 
Run > maven tests
Use the following pattern: maven clean, install, test

# Logs

Logs are store in the following dirctory: src/test/resources/results.
After each run a separated folder with log files and screenshots (in case of failure) is created.

# Reports

Test reports are generated in the target/surfire-reports directory. Below an example of the emailable-report:


Report example:
![Alt text](./report_example.png?raw=true "Report Example")

# Versioning
Version 1.0

# Author
Agnieszka Galeza

# License



# Acknowledgments
http://test-able.blogspot.com/2017/01/where-can-i-find-full-test-automation.html
https://github.com/thymeleaf/thymeleafexamples-petclinic
https://github.com/yandex-qatools
