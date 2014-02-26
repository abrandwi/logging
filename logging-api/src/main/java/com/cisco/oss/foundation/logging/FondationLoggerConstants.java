/**
 * 
 */
package com.cisco.oss.foundation.logging;

/**
 * 
 * @author Yair Ogen
 */
public enum FondationLoggerConstants {

	/**
	 * the category term MDC key
	 */
	CAT_TERM("catTerm"),
	/**
	 * 
	 */
	APPSTATE_ENABLED("FoundationLogger.applicationstateEnabled"),

	/**
	 * 
	 */
	GZIP("gz"),

	/**
	 * 
	 */
	ZIP("zip"),

	/**
	 * 100MB = 100 *1024 * 1024
	 */
	Foundation_MAX_FILE_SIZE("104857600"),

	/**
	 * the default date pattern for the date that will be put in the file name when rolling occurs.
	 */
	DEFAULT_DATE_PATTERN(".yyyy-MM-dd"),

	/**
	 * the default pattern if user did not override it in the log4j configuration file.
	 */
	DEFAULT_CONV_PATTERN("%d{yyyy/MM/dd HH:mm:ss.SSS}{UTC} [%c{1}] [%t]:  %audit %p: %X{flowCtxt} %sl %errorcode %throwable{full} %n"),
	
	/**
	 * 
	 */
	DEFAULT_AUDIT_PATTERN("%d{yyyy/MM/dd HH:mm:ss.SSS}{UTC} %-5p: %X{flowCtxt} %sl{pretty}%n"),
	
	/**
	 * The log4j appender default max file size before rolling occurs. 10MB = 10 *1024 *1024
	 */
	DEFAULT_LOG4J_SIZE("10485760"),

	Foundation_FILE_ARCHIVE("FoundationLogger.archiveFiles"),

	Foundation_ASYNC_REF("FoundationLogger.asyncAppenderReferences"),

	Foundation_ASYNC_BUFFER_SIZE("FoundationLogger.asyncAppenderBufferSize"),

	TRANSACTION_NAME("transactionName"),

	ALL_VALUES("allValues"),

	Foundation_ROLL_ON_STARTUP("FoundationLogger.rollOnStartup");

	private String constant;

	private FondationLoggerConstants(final String constant) {
		this.constant = constant;
	}

	@Override
	public String toString() {
		return constant;
	}

}
