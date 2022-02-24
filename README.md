# Order Distribution System

## Project description

Order Distribution System (ODS) is a middleware application that integrate different ordering systems of customers with the suppliers.

ODS process incoming orders in XML format and creates individual per supplier XML product summaries files, with the purpose to be sent to suppliers.
The application is written with Java and Spring Boot.

## Solution description

For the implementation of the project, a Watcher object monitors the directory where the incoming orders files are collected.
Once a file is added to this directory (**orderFiles**), the watcher captures the event and starts processing the added file. Files should have a predefined XML format as described in the requirements and follows a specific naming pattern also covered by requirements. 

The responsibility of processing an input file and transform its XML format into internal entities objects is handled by ProcessInputOrderFileService. 
The resulting internal entities collection is handed to OutputProductsForSuppliersService, that transforms them in specified XML output files for every supplier. Generated files are located in a centralized **exported** directory, each corresponding supplier having a dedicated folder under this directory. All files for a supplier are centralized in the supplier specific folder.    
ParsingService is orchestrating both of processing services allowing future flexibility of switching either input or output data formats.

### Technologies used

<div >

<img style="margin: 10px" src="https://img.icons8.com/color/48/000000/java-coffee-cup-logo.png" alt="Java" height="45"/>

<img style="margin: 10px" src="https://du0ulnyus7r80.cloudfront.net/wp-content/uploads/2020/02/spring-boot-logo-png-4-transparent.png" alt="Spring" height="45" />

<img style="margin: 10px" src="https://upload.wikimedia.org/wikipedia/commons/thumb/9/9c/IntelliJ_IDEA_Icon.svg/1200px-IntelliJ_IDEA_Icon.svg.png" alt="IntelliJ" height="45"/>
</div>


### Additional Libraries

- JAXB, Java Architecture For XML Binding - for converting XML to Java Objects and vice versa.

### Start the application

- Run the application in your IDE (all the dependencies used are in pom.xml)
- The starting point of the app is located inside the WatcherService class.
