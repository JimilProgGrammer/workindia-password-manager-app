package com.password.manager.util;

/**
 * Utility class that holds constants for table names
 * and column names in the database.
 * 
 * @author jimil
 *
 */
public class DatabaseConstants {
	
	public static final String USERS_TABLE = "users";
	public static final String USERS_USERNAME_COLUMN = "username";
	public static final String USERS_PASSWORD_COLUMN = "pwd";
	
	public static final String WEBSITE_PASSWORD_TABLE = "website_passwords";
	public static final String WEBSITE_WEBSITE_COLUMN = "website";
	public static final String WEBSITE_USERNAME_COLUMN = "web_username";
	public static final String WEBSITE_PASSWORD_COLUMN = "web_pwd";
	public static final String WEBSITE_USER_ID_COLUMN = "user_id";
	
}
