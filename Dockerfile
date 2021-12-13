FROM adoptopenjdk/openjdk11:ubi

RUN mkdir /app
COPY build/libs/*.jar /app/app.jar

ENTRYPOINT ["java","-jar","/app/app.jar"]