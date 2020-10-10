package com.rest.dataservice.util;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;

public abstract class AbstractMapper {

	private static final Logger logger = LoggerFactory.getLogger(AbstractMapper.class);

	public Object getParsedObject(Object inputObject, Class<?> classOnWhichArrayIsDefined) {
		Object object = null;
		String json = null;
		try {
			ObjectMapper mapper = new ObjectMapper();
			json = mapper.writeValueAsString(inputObject);
			Class<?> arrayClass = (Class<?>) Class.forName(classOnWhichArrayIsDefined.getName());
			object = mapper.readValue(json, arrayClass);
		} catch (Exception e) {
			logger.info("JsonProcessingException in convertObjectToJsonString --->", e);
		}
		return object;
	}

	public Object getParsedListObject(Object inputObject, Class<?> classOnWhichArrayIsDefined) {
		Object object = null;
		String json = null;
		try {
			ObjectMapper mapper = new ObjectMapper();
			json = mapper.writeValueAsString(inputObject);
			Class<?> arrayClass = (Class<?>) Class.forName(classOnWhichArrayIsDefined.getName());
			JavaType type = mapper.getTypeFactory().constructCollectionType(List.class, arrayClass);
			object = mapper.readValue(json, type);
		} catch (Exception e) {
			logger.info("JsonProcessingException in convertObjectToJsonString --->", e);
		}
		return object;
	}
}
