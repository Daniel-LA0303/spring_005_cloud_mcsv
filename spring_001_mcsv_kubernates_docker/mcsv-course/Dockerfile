FROM openjdk:17-slim as builder

WORKDIR /app/mcsv-course

# Copy the pom.xml file to download dependencies
COPY ./pom.xml /app
# Copy the complete project in the container
COPY ./mcsv-course/.mvn ./.mvn
#we need to copy the mvnw file to save the cache of maven
COPY ./mcsv-course/mvnw .
#we copy the file pom to download the dependencies
COPY ./mcsv-course/pom.xml .

#skip test and ejecution in each build and delete the target folder
RUN ./mvnw clean package -Dmaven.test.skip -Dmaven.main.skip -Dspring-boot.repackage.skip && rm -r ./target/

# Copy the complete project in the container
COPY ./mcsv-course/src ./src

#we run the maven command to download the dependencies and run project
RUN ./mvnw clean package -DskipTests

# ------------------ Second stage ------------------
#we cretae a new image with the image previous
FROM openjdk:17-slim

WORKDIR /app

#we create a directory to save the logs of spring boot
RUN mkdir ./logs

COPY --from=builder /app/mcsv-course/target/mcsv-course.jar .

# Run the jar file with port
EXPOSE 8081

CMD ["java", "-jar", "mcsv-course.jar"]

