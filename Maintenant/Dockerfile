# FROM openjdk:11
# WORKDIR /app
# COPY ./ ./
# CMD ["java", "-jar", "target/maintenant-0.0.1-SNAPSHOT.jar"]

FROM openjdk
COPY ./target/maintenant-1.0-SNAPSHOT-jar-with-dependencies.jar ./
WORKDIR ./
CMD ["java", "-jar", "maintenant-1.0-SNAPSHOT-jar-with-dependencies.jar"]
