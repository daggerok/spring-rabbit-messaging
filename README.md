spring-rabbit-messaging [![build](https://travis-ci.org/daggerok/spring-rabbit-messaging.svg?branch=master)](https://travis-ci.org/daggerok/spring-rabbit-messaging)
=======================

messaging with rabbit and spring boot

**tags**

- rabbit
- spring boot
- messaging
- gradle

1. checkout sources, start rabbitmq-server

```shell
$ git clone https://github.com/daggerok/spring-rabbit-messaging
$ wget -qO-  http://www.rabbitmq.com/releases/rabbitmq-server/v3.6.0/rabbitmq-server-generic-unix-3.6.0.tar.xz | tar -xvf-
$ rabbitmq_server-3.6.0/sbin/rabbitmq-server
```

2. import in idea
3. rigth click -> Run -> All Tests
4. wait and check logs (read comments in ```daggerok.messaging.rabbit.MessagingRabbitApplicationTests```)
