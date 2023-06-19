FROM eclipse-temurin:11

LABEL maintainer = "chidiudo"

WORKDIR /app

COPY target/family-tree-app.jar /app/family-tree-app.jar

ENTRYPOINT ["java", "-jar", "family-tree-app.jar"]