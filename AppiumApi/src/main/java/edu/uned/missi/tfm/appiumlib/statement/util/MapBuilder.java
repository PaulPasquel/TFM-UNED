package edu.uned.missi.tfm.appiumlib.statement.util;

import java.util.HashMap;

/**
 * Use Builder Pattern
 * @author Paul Pasquel
 *
 */
public class MapBuilder {
	
	private HashMap<String, Object> attributes = new HashMap<String, Object>();

	public MapBuilder add(String key, Object value) {
		attributes.put(key, value);
		return this;
	}
	
	public HashMap<String, Object> create(){
		return attributes;
	}
}
