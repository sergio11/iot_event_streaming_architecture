# Start with a base image containing Java runtime
FROM openjdk:8-jdk-alpine
# Add Maintainer Info
LABEL maintainer="sss4esob@gmail.com"
LABEL description="TeVeo! Web Platform"

# Args for image
ARG PORT=8088
ARG JAR_FILE=teveo_platform.jar

COPY ${JAR_FILE} /app.jar

EXPOSE ${PORT}

ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/app.jar"]
