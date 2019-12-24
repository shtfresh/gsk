FROM openjdk:12-oraclelinux7
RUN mkdir /app
COPY ./target /app/
COPY ./Wallet_DB201912241112 /app/
ENV DB_USER ADMIN
ENV DB_PASSWORD Welcome!123456
ENV DB_URL jdbc:oracle:thin:@db201912241112_medium?TNS_ADMIN=/app/Wallet_DB201912241112
EXPOSE 30010
WORKDIR /app
RUN chmod 777 /app/target/madhack-release.jar
CMD ["java", "-jar", "./target/madhack-release.jar"]