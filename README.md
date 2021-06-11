# Demo of Sprint Boot with H2 and Kafka
- version of kafka used: 2.8.0
  
- command to create the topic:
  /opt/bitnami/kafka/bin/kafka-topics.sh --create --zookeeper 192.168.1.106:2181 --replication-factor 1 --partitions 1 --topic novice-players
  
- command to read messages from the topic
  /opt/bitnami/kafka/bin/kafka-console-consumer.sh --topic novice-players --from-beginning --bootstrap-server localhost:9092
  
- command to run the application:
  mvn spring-boot:run