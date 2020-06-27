package com.eSmartHire.common;

import java.text.MessageFormat;
import java.util.ResourceBundle;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class MessageManager {
	
	private static Logger logger = LoggerFactory.getLogger(MessageManager.class);

	public static String getMessage(Status.StatusLevel statusLevel, String key, Object... messageParams) {
		ResourceBundle resourceBundle;
		
		try {
			if(statusLevel.equals(Status.StatusLevel.Exception)) {
				resourceBundle = ResourceBundle.getBundle("exception");
			}else {
				resourceBundle = ResourceBundle.getBundle("status");
			}
			return MessageFormat.format(resourceBundle.getString(key), messageParams);
		}catch(Exception e) {
			logger.warn("Error reading key " + key + " from resource bundle. (Exception of type"
					+ e.getClass().getName() + " occurred while trying to get it): " + e.getMessage());
			return key;
		}
	}
	
	public static String getMessage(String key, Object... messageParams) {
		ResourceBundle resourceBundle;
		
		try {
			resourceBundle = ResourceBundle.getBundle("exception");
			String message = MessageFormat.format(resourceBundle.getString(key), messageParams);
			return !"".equals(message) ? message : key;
		}catch(Exception e) {
			logger.warn("Error reading key " + key + " from resource bundle. (Exception of type"
					+ e.getClass().getName() + " occurred while trying to get it): " + e.getMessage());
			return key;
		}
	}
	
	public static String getValidationMessage(String key, Object... messageParams) {
		ResourceBundle resourceBundle = ResourceBundle.getBundle("validation");
		return MessageFormat.format(resourceBundle.getString(key), messageParams);
		
	}
	
	public static String getStatusMessage(String key, Object... messageParams) {
		ResourceBundle resourceBundle = ResourceBundle.getBundle("status");
		return MessageFormat.format(resourceBundle.getString(key), messageParams);
		
	}
}
