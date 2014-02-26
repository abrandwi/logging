package com.cisco.oss.foundation.logging;

import org.apache.log4j.Category;
import org.apache.log4j.Priority;
import org.apache.log4j.spi.LoggingEvent;
import org.slf4j.Marker;

@SuppressWarnings("serial")
public class FoundationLoggingEvent extends LoggingEvent {
	
	private Marker marker = null;
	private String appenderName;
	
	public FoundationLoggingEvent(String fqnOfCategoryClass, Category logger, Priority level, Object message, Throwable throwable) {
		super(fqnOfCategoryClass, logger, level, message, throwable);
	}
	
	public FoundationLoggingEvent(Marker marker, String fqnOfCategoryClass, Category logger, Priority level, Object message, Throwable throwable) {
		super(fqnOfCategoryClass, logger, level, message, throwable);
		this.marker = marker;
	}
	
	public FoundationLoggingEvent(FoundationLoggingEvent event) {
		
		super(event.fqnOfCategoryClass,event.getLogger(),event.getLevel(),event.getMessage(),event.getThrowableInformation()!=null? event.getThrowableInformation().getThrowable():null);
		this.marker=event.marker;
	}

	public Marker getMarker() {
		return marker;
	}

	public void setAppenderName(String name) {
		this.appenderName = name;
		
	}

	public String getAppenderName() {
		return appenderName;
	}
	

}
