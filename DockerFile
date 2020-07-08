FROM java:8-jdk-alpine
COPY ./target/location-1.jar /usr/app/
WORKDIR /usr/app
RUN sh -c 'touch location-1.jar'
ENTRYPOINT ["java","-jar","location-1.jar"]