FROM java:8

ADD target/imap.zip /tmp/

RUN unzip -q /tmp/imap.zip -d /usr/local/

WORKDIR /usr/local/imap