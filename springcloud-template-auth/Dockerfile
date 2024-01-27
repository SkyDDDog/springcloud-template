FROM openjdk:17-jdk-alpine as builder

LABEL author="lear" \
	email="362664609@qq.com"

ADD ./springcloud-template-auth/target/springcloud-template-auth-*.jar /app.jar

RUN sh -c 'touch /app.jar'

EXPOSE 10002

CMD ["--server.port=10002"]

ENTRYPOINT ["java", "-jar","/app.jar"]