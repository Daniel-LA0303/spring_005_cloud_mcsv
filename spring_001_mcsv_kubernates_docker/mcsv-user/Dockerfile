FROM openjdk:17-slim

WORKDIR /app

# Copy the jar file to the container
COPY ./target/mcsv-user.jar .

# Run the jar file with port
EXPOSE 8081

ENTRYPOINT ["java", "-jar", "mcsv-user.jar"]