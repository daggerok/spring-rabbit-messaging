spring-rabbit-messaging [![build](https://travis-ci.org/daggerok/spring-rabbit-messaging.svg?branch=master)](https://travis-ci.org/daggerok/spring-rabbit-messaging)
=======================

messaging with redis and spring boot

**tags**

- rabbit
- spring boot
- messaging
- gradle

run rabbit

```shell
$ wget -qO-  http://www.rabbitmq.com/releases/rabbitmq-server/v3.6.0/rabbitmq-server-generic-unix-3.6.0.tar.xz | tar -xvf-
$ rabbitmq_server-3.6.0/sbin/rabbitmq-server
$ git clone https://github.com/daggerok/spring-rabbit-messaging
```

checkout sources and run tests

```shell
$ git clone https://github.com/daggerok/spring-rabbit-messaging && cd $_
```

- import in idea
- rigth click -> Run -> All Tests
- wait and check logs (read comments in ```daggerok.messaging.redis.MessagingRabbitApplicationTests```)
