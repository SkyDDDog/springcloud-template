FROM openjdk:17-jdk-alpine as builder

LABEL author="lear" \
	email="362664609@qq.com"

ADD ./springcloud-template-account/target/springcloud-template-account-*.jar /app.jar

RUN sh -c 'touch /app.jar'

EXPOSE 10006

CMD ["--server.port=10006"]

ENTRYPOINT ["java", "-jar","/app.jar"]