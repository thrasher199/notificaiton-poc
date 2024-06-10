create table bidding
(
    id                  INT,
    version             INT,
    company_name        STRING,
    bid_amount          DECIMAL,
    PRIMARY KEY (id) NOT ENFORCED
) WITH (
      'connector' = 'postgres-cdc',
      'hostname' = 'localhost',
      'port' = '5432',
      'username' = 'postgres',
      'password' = 'postgres',
      'database-name' = 'postgres',
      'schema-name' = 'public',
      'table-name' = 'bidding',
      'slot.name' = 'flink'
      );


create table kafka_bidding
(
    id                  INT,
    version             INT,
    company_name        STRING,
    bid_amount          DECIMAL,
    PRIMARY KEY (id) NOT ENFORCED
) WITH (
      'connector' = 'upsert-kafka',
      'properties.bootstrap.servers' = 'localhost:9092',
      'topic' = 'notification_topic',
      'properties.allow.auto.create.topics' = 'true',
      'key.format' = 'json',
      'value.format' = 'json'
      );

INSERT INTO kafka_bidding
SELECT bid.id, bid.version, bid.company_name, bid.bid_amount
FROM bidding as bid;