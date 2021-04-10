# PRE-REQUISITES
1. Install Java 8+.
2. Install Maven
3. Set Environment Variables for JAVA_HOME & MAVEN_HOME

# How to run the application
1. Download the project or Clone the project from git hub repository https://github.com/Mani1423/ajira_challenge.git.
2. Unzip the files if you have downloaded.
3. Open the command prompt from where your pom.xml is placed.
4. Run the command "mvn clean compile".
5. Run the command mvn package.
6. Run the command cd /target where your libraries packaged in this location as "ajira-challenge.jar".
7. Copy the ajira-challenge.jar and paste it to your desired location. (Eg- C:\test\)
7. Copy the attached configuration for each test cases from the folder location "/configurations" to your desired location (Eg- C:\test\).
8. Place your input files at your desired loaction (Eg- C:\test\input\)
9. Run the application by using below command.
java -jar "C:\test\ajira-challenge.jar" C:\test\input\case1.csv C:\test\configurations\case1.csv C:\test\output\case1.csv
java -jar "C:\test\ajira-challenge.jar" C:\test\input\case2.csv C:\test\configurations\case2.csv C:\test\output\case2.csv
java -jar "C:\test\ajira-challenge.jar" C:\test\input\case3.csv C:\test\configurations\case3.csv C:\test\output\case3.csv
java -jar "C:\test\ajira-challenge.jar" C:\test\input\case4.csv C:\test\configurations\case4.csv C:\test\output\case4.csv

# How to test the application using test cases
1. Run the command "mvn test"

