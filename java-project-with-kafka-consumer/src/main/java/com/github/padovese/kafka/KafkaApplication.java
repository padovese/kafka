package com.github.padovese.kafka;

import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.apache.kafka.common.serialization.StringSerializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.Duration;
import java.util.Arrays;
import java.util.Properties;

//@SpringBootApplication
public class KafkaApplication {

	public static void main(String[] args) {
		//SpringApplication.run(KafkaApplication.class, args);

		final Logger logger = LoggerFactory.getLogger(KafkaApplication.class);

		Properties properties = new Properties();
		properties.setProperty(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:29092");
		properties.setProperty(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class.getName());
		properties.setProperty(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class.getName());
		properties.setProperty(ConsumerConfig.GROUP_ID_CONFIG, "java-app");
		properties.setProperty(ConsumerConfig.AUTO_OFFSET_RESET_CONFIG, "earliest"); // can be latest and none as well, indicates if you get only the one msgs, or all msgs, etc


		KafkaConsumer<String, String> consumer = new KafkaConsumer<>(properties);
		consumer.subscribe(Arrays.asList("first_topic"));

		while(true){
			ConsumerRecords<String, String> records = consumer.poll(Duration.ofSeconds(10));

			for(ConsumerRecord<String, String> record : records){
				logger.info("Topic: " + record.topic() + " - Partition: " + record.partition() + " - Offset: " + record.offset());
				logger.info("Key: " + record.key() + " - Value: " + record.value());
			}
		}
	}

}
