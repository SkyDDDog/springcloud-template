FROM openjdk:17-jdk-alpine as builder

LABEL author="lear" \
	email="362664609@qq.com"

ADD ./springcloud-template-gateway/target/springcloud-template-gateway-*.jar /app.jar

RUN sh -c 'touch /app.jar'

EXPOSE 10001

CMD ["--server.port=10001"]

ENTRYPOINT ["java", "-jar","/app.jar"]