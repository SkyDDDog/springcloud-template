FROM openjdk:17-jdk-alpine as builder

LABEL author="lear" \
	email="362664609@qq.com"

ADD ./springcloud-template-praise-consumer/target/springcloud-template-praise-consumer-*.jar /app.jar

RUN sh -c 'touch /app.jar'

EXPOSE 10004

CMD ["--server.port=10004"]

ENTRYPOINT ["java", "-jar","/app.jar"]