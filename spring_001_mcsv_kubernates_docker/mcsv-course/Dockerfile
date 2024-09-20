FROM openjdk:17-slim

WORKDIR /app

# Copy the jar file to the container
COPY ./target/mcsv-course.jar .

# Run the jar file with port
EXPOSE 8082

ENTRYPOINT ["java", "-jar", "mcsv-course.jar"]