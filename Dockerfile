FROM openjdk:12-oraclelinux7
RUN mkdir /app
COPY ./target /app/
EXPOSE 30010
WORKDIR /app
CMD ["java", "-jar", "target/madhack-release.jar"]