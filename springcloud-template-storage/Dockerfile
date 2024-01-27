FROM openjdk:17-jdk-alpine as builder

LABEL author="lear" \
	email="362664609@qq.com"

ADD ./springcloud-template-storage/target/springcloud-template-storage-*.jar /app.jar

RUN sh -c 'touch /app.jar'

EXPOSE 10005

CMD ["--server.port=10005"]

ENTRYPOINT ["java", "-jar","/app.jar"]