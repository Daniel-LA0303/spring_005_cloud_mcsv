FROM openjdk:17-slim as builder

WORKDIR /app/mcsv-user

# Copy the pom.xml file to download dependencies
COPY ./pom.xml /app
# Copy the complete project in the container
COPY ./mcsv-user/.mvn ./.mvn
#we need to copy the mvnw file to save the cache of maven
COPY ./mcsv-user/mvnw .
#we copy the file pom to download the dependencies
COPY ./mcsv-user/pom.xml .

#skip test and ejecution in each build and delete the target folder
RUN ./mvnw clean package -Dmaven.test.skip -Dmaven.main.skip -Dspring-boot.repackage.skip && rm -r ./target/

# Copy the complete project in the container
COPY ./mcsv-user/src ./src

#we run the maven command to download the dependencies and run project
RUN ./mvnw clean package -DskipTests

# ------------------ Second stage ------------------
#we cretae a new image with the image previous
FROM openjdk:17-slim

WORKDIR /app

#we create a directory to save the logs of spring boot
RUN mkdir ./logs

COPY --from=builder /app/mcsv-user/target/mcsv-user.jar .

# Run the jar file with port
EXPOSE 8081

#ENTRYPOINT ["java", "-jar", "mcsv-users-0.0.1-SNAPSHOT.jar"]
CMD ["java", "-jar", "mcsv-user.jar"]

