FROM openjdk:17-jdk-alpine as builder

LABEL author="lear" \
	email="362664609@qq.com"

ADD ./springcloud-template-order/target/springcloud-template-order-*.jar /app.jar

RUN sh -c 'touch /app.jar'

EXPOSE 10007

CMD ["--server.port=10007"]

ENTRYPOINT ["java", "-jar","/app.jar"]