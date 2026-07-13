# avro-schema-registry-service

Kafka producer and consumer using **Apache Avro** with the **Confluent Schema Registry**. Message
schemas are defined in `.avsc`, Java classes are generated at build time, and the registry enforces
**schema evolution** compatibility so producers and consumers can change independently and safely —
essential for long-lived event pipelines.

## Stack
Java 21, Spring Boot 3.3, Spring Kafka, Avro 1.11, Confluent kafka-avro-serializer 7.6.

## Build (generates Java from the schema)
```bash
mvn clean generate-sources package
```

## Notes
Requires a running Kafka broker and Schema Registry (e.g. Confluent's `cp-all-in-one` compose).
Set `KAFKA_BOOTSTRAP` and `SCHEMA_REGISTRY` env vars. The `Payment` class under
`io.surajit.avro.model` is generated from `src/main/resources/avro/payment.avsc`.
