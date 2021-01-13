# Cash value to text converter

This project illustrate as an API provider as a part of the code test.
The API contains the feature to converter a value in number with one delimiter to text in English.

## Getting Started

The instructions will get you a copy of the project up and running on your local machine for development and testing 
purposes. See deployment for notes on how to deploy the project on a live system.

They were tested on IntelliJ IDEA with mac laptop.

### Prerequisites

Ensure that the machine is installed with JDK/JRE, and the classpath is applied in the environment variable.

It is very preferable to use an IDE, like Eclipse or IntelliJ IDEA.

## Specifications
INPUT: <0..999999>(.<0..99>)?

OUTPUT: 
  1) Fixed instruction "Enter the number: "
  2) Result in string of words

## Installing

Java API (jar file) can be either executed on terminal or imported as module on a project.

### Execute on terminal
Open the terminal and go to the root of the project. Copy and run the command.
```
java -cp NumberToTextConverter.jar src/com/main/NumberConverter.java
```

Pay attention that there will be a fixed instruction string in the output "Enter the number: " before enabling to type the input, when the JAR is executed directly, ie. on the terminal.

### Import in IDE
1) Download/clone the JAR file in your machine
2) In IntelliJ, go to File -> Project Structure
3) Below Project Settings, pick Modules
4) Click '+' and find the JAR file and import in the project

The project example can be found in ImportJarExample Java project

## Running the tests

The test is performed by using test driven development (TDD) and simple form of QuickCheck concept.
Both can be found in test folder.

The QuickCheck is not stable test, but it contributes to check if the pattern are as expected in well-defined cases, like
if the value is higher or equals to 1000, then we can expect that the output will contain "thousand". 
The test runs with a random generator, then ensuring that the number of value that are generated in one run is high enough 
and run the test few times more if the test is succeeded.

## Deployment

The code base of converter can be found in project "CodeTest_NumberToText".

To deploy into JAR file, follow those steps in IntelliJ:
1) File -> Project Structure
2) Open Artifacts below Project Settings
3) Click '+' 
4) Select JAR -> Module with dependencies.
5) Check the name in 'Module' is same as name of the project.
6) In 'Main Class', pick the java class file that contains the main method.
7) Click OK.
8) The new JAR file should occur on the windows.
9) Close the windows.
10) Go to Build -> Build Artifacts and select Build below Action.
11) The JAR file is generated and can be found in out/artifacts folder.

### Updating the JAR file
When the code change is made. Ensuring that the version is updated in MANIFEST.MF
Go to Build -> Build Artifacts and select Rebuild below Action (Attention, not build)

## Authors

* **Kenneth Andersen** - *Author* - [Kennik89](https://github.com/Kennik89)
