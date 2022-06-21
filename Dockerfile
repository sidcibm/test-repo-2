FROM maven:3-jdk-11
COPY . /usr/src/myapp
WORKDIR /usr/src/myapp
CMD ["mvn", "exec:exec"]