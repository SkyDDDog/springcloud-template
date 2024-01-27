FROM openjdk:17-jdk-alpine as builder

LABEL author="lear" \
	email="362664609@qq.com"

ADD ./springcloud-template-praise-provider/target/springcloud-template-praise-provider-*.jar /app.jar

RUN sh -c 'touch /app.jar'

EXPOSE 10003

CMD ["--server.port=10003"]

ENTRYPOINT ["java", "-jar","/app.jar"]