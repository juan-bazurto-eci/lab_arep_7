FROM openjdk:8
WORKDIR /usrapp/bin
ENV PORT 5000
ENV DNS "https://localhost:5000/hello"
ENV PASSWORD "123456"
COPY /target/classes /usrapp/bin/classes
COPY /target/dependency /usrapp/bin/dependency
COPY /keystore /usrapp/bin/keystore/
CMD ["java","-cp","./classes:./dependency/*", "co.edu.escuelaing.arep.HelloWorldBack"]