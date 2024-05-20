# Use a single base image
FROM openjdk:22-jdk

# Set the author label
LABEL authors="rahulpannati"

# Copy the wait-for-mysql.sh script into the Docker image
COPY ./wait-for-mysql.sh /wait-for-mysql.sh

# Make the script executable
RUN chmod +x /wait-for-mysql.sh

# Add the application JAR file into the Docker image
ADD target/student-app.jar student-app.jar

# Set the entrypoint command to start the application
ENTRYPOINT ["java", "-jar", "/student-app.jar"]