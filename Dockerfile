FROM openjdk:17-alpine
ARG JAR_FILE=target/crypto-investment.jar
ADD ${JAR_FILE} crypto-investment.jar
ENTRYPOINT ["java", "-Dfile.dir=prices", "-jar", "crypto-investment.jar"]