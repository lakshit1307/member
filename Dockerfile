FROM openjdk:8-jdk-alpine
#FROM gradle:4.10.2-jdk8-alpine
#FROM postgres:11.1-alpine
#RUN postgres --version
#RUN postgres -D /usr/local/pgsql/data >logfile 2>&1 &
#RUN su postgres -c 'psql -h postgres -U postgres'
RUN mkdir /var/app
COPY ./build/libs/member*.jar /var/app/member.jar
WORKDIR /var/app

ENTRYPOINT ["java","-jar","-Dspring.profiles.active=container","member.jar"]

EXPOSE 5432