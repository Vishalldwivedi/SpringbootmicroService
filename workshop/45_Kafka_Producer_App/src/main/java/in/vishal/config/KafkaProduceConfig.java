package in.vishal.config;

import java.util.HashMap;
import java.util.Map;

import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;
import org.springframework.kafka.support.serializer.JsonSerializer;

import in.vishal.constants.AppConstants;
import in.vishal.model.Order;


@Configuration
public class KafkaProduceConfig {//how to connect with kafka topic and what msg to store in
	//kafka topic

	//this method is called by ioc container there we call it as bean
	//in this method i want to create a producer factory object
	@Bean//key value pair ->string rep in which topic u want to store
	// and value is data ie order data
	public ProducerFactory<String, Order> producerFactory() {

		Map<String, Object> configProps = new HashMap<>();
        //we need to provide what is our key , value and where is our kafka server
		configProps.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, AppConstants.HOST);
		//where to the kafka server
		configProps.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
		//my key is a string (object to byte stream )
		configProps.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, JsonSerializer.class);
        // value is a order obj i want to store that in json format

		return new DefaultKafkaProducerFactory<>(configProps);
		//passing configProps map in constructor and returning its object
		//I want to return the producer factory object
	}


	@Bean// this above producerFactory i will inject into kafkaTemplate
	//this kafkaTemplate is provide by kafka to store the msg in kafka topic
	public KafkaTemplate<String, Order> kafkaTemplate() {
		return new KafkaTemplate<>(producerFactory()); //through constructor returning
		// kafkaTemplateObject
	}


}
