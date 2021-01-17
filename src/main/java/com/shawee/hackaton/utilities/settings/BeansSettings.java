package com.shawee.hackaton.utilities.settings;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.databind.Module;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateSerializer;
import com.shawee.hackaton.security.JwtUtil;

@Configuration
public class BeansSettings {

	public static final String DATE_FORMAT = "dd/MM/yyyy";
	
	@Bean
	public JwtUtil getJwtUtil() {
		return new JwtUtil();
	}

	@Bean
	public ObjectMapper getObjectMapper() {
		return new ObjectMapper()
				.setSerializationInclusion(Include.NON_NULL)
				.registerModule(newJavaTimeModule())
				.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
	}

	private Module newJavaTimeModule() {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern(DATE_FORMAT); 
		return new JavaTimeModule()
				.addSerializer(LocalDate.class, new LocalDateSerializer(formatter))
	    		.addDeserializer(LocalDate.class, new LocalDateDeserializer(formatter));
	}
	
}
