FROM amazoncorretto:17
WORKDIR /app
COPY target/deleBlog-0.0.1-SNAPSHOT.jar /app/
EXPOSE 4003
RUN bash -c 'touch /app/deleBlog-0.0.1-SNAPSHOT.jar'
ENTRYPOINT ["java", "-jar","/app/deleBlog-0.0.1-SNAPSHOT.jar"]