FROM openjdk:17

WORKDIR /usr/src/app

ARG JAR_PATH=./build/libs

COPY ${JAR_PATH}/cron-0.0.1-SNAPSHOT.jar ${JAR_PATH}/cron-0.0.1-SNAPSHOT.jar

CMD ["java","-jar","./build/libs/cron-0.0.1-SNAPSHOT.jar"]