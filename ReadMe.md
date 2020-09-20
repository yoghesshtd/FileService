#### **Application to list files and their attributes based on user input**

Main class: `src\main\java\com\dbs\fileservice\FileService\FileServiceApplication.java`

**Project setup:**

 - JDK: 8
 - API: Spring boot 
 - UI: Thymeleaf + Bootstrap
-------------------------------------------
API has 2 endpoints:
1. Get All files based on given file path: /all
    - Request param name: path --> Full path of directory
2. Get all attributes of given file: /attributes
    - Request param: filePath --> complete path of a file
    
Web UI has been created using Thymeleaf, which is integrated with above endpoints.

**Steps to run the application:** 
1. Build application and bundle executable jar file: `mvn clean package`
2. Start application by executing bundled jar file from project root: `java -jar target\FileService-0.0.1-SNAPSHOT.jar`
3. By default, application runs on port 8080
4. Access below url for home page: http://localhost:8080
5. THere are 2 options now:
    - Provide valid directory path and hit List Files button --> This displays the complete list of files with their respective path in a grid
      Direct REST  endpoint for API: http://localhost:8080/all?path=C%3A%5CYoghessh
      
    - Provide complete path of a file and hit List Attributes --> Displays attributes of the given file in a grid
      Direct REST  endpoint for API: http://localhost:8080/attributes?filePath=C%3A%5CYoghessh%5CDBS%5CRef.txt
      
      
  