FROM java:8

ADD target/simple-service.zip /tmp/

RUN unzip -q /tmp/simple-service.zip -d /usr/local/ && rm /tmp/*

WORKDIR /usr/local/simple-service