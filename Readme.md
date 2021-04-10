# PRE-REQUISITES
1. Install Java 8+.
2. Install Maven
3. Set Environment Variables for JAVA_HOME & MAVEN_HOME

# How to run the application
1. Download the project or Clone the project from git hub repository.
2. Unzip the files.
3. Open the command prompt from where your pom.xml is placed.
4. Run the command mvn clean compile.
5. Run the command mvn package.
6. Run the command cd /target where your libraries packaged in this location.
7. Copy the ajira-challenge.jar and paste it to your desired location. (Eg- C:\test\)
7. Copy the attached configuration for each test cases from the folder location "/configurations" to your desired location (Eg- C:\test\).
8. Place your input files at your desired loaction (Eg- C:\test\input\)
9. Run the application by using below command.
java -jar "C:\test\ajira-challenge.jar" C:\test\input\case1.csv C:\test\configurations\case1.csv C:\test\output\case1.csv


