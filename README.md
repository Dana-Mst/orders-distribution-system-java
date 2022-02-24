# Order Distribution System

## Project description

Order Distribution System (ODS) is a middleware application that integrate different ordering systems of customers with the suppliers.

ODS process incoming orders in XML format and creates the XML files that will be sent to the suppliers.
The application is written with Java and Spring Boot.

## Solution description

For the implementation of the project, I created a Watcher object that monitors the directory where the orders from different ordering systems are collected.
Once a file is added to this directory (orderFiles), the watcher captures the event and starts processing the added file.

The processing is happening in the ParsingService.

### Technologies used

<div >

<img style="margin: 10px" src="https://img.icons8.com/color/48/000000/java-coffee-cup-logo.png" alt="Java" height="45"/>

<img style="margin: 10px" src="https://du0ulnyus7r80.cloudfront.net/wp-content/uploads/2020/02/spring-boot-logo-png-4-transparent.png" alt="Spring" height="45" />

<img style="margin: 10px" src="https://upload.wikimedia.org/wikipedia/commons/thumb/9/9c/IntelliJ_IDEA_Icon.svg/1200px-IntelliJ_IDEA_Icon.svg.png" alt="IntelliJ" height="45"/>
</div>


### Additional Libraries

- JAXB, Java Architecture For XML Binding - for converting XML to Java Objects and vice versa.

### Start the application

- Run the application in your IDE (all the dependencies are in pom.xml)
