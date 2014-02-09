package com.cisco.vss.foundation.logging.structured.test;

import com.cisco.vss.foundation.logging.structured.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@DefaultFormat(TransactionMarker.DEFAULT_FORMAT)

@ConditionalFormats({
	
	@ConditionalFormat(	format=TransactionMarker.COND_FORMAT_1,
						criteria={
								@FieldCriterion(name="sourceId", value="sourceId1"),
								@FieldCriterion(name="sourceType", value="sourceType1")}),
	@ConditionalFormat(	format=TransactionMarker.COND_FORMAT_2, 
						criteria={
								@FieldCriterion(name="sourceId", value="sourceId2"), 
								@FieldCriterion(name="sourceType", value="sourceType2")
								}
						),
	@ConditionalFormat(	format=TransactionMarker.COND_FORMAT_3, 
						criteria={
								@FieldCriterion(name="sourceId", value="sourceId3"), 
								@FieldCriterion(name="sourceType", value="sourceType3")
								}
						)
})

public class TransactionMarker extends BaseTransactionLoggingMarker {
	
	Logger LOGGER = LoggerFactory.getLogger(TransactionMarker.class);

	private static final long serialVersionUID = 9161271890930513129L;
	
	public static final String DEFAULT_FORMAT = "my default uncoditioned format!!!";
	public static final String COND_FORMAT_1 = "my human readbale format 1";
	public static final String COND_FORMAT_2 = "my human readbale format 2";
	public static final String COND_FORMAT_3 = "my human readbale format 3";
	

	public TransactionMarker(String sessionId) {		
		this.sessionId = sessionId;
	}

	@UserField(suppressNull = true)
	private FoundationLoggingEventType eventType;
	@UserField
	private FoundationLoggingTransMsgType transMsgType;
	@UserField
	private  String sessionId;
	@UserField
	private  String sourceId;
	@UserField
	private  String sourceType;
	@UserField
	private  String destinationId;
	@UserField
	private  String destinationType;
	@UserField
	private  String messagePayload;


	public TransactionMarker setEventType(FoundationLoggingEventType eventType) {
		this.eventType = eventType;
		return this;
	}
	public TransactionMarker setTransMsgType(FoundationLoggingTransMsgType transMsgType) {
		this.transMsgType = transMsgType;
		return this;
	}
	public TransactionMarker setSessionId(String sessionId) {
		this.sessionId = sessionId;
		return this;
	}
	public TransactionMarker setSourceId(String sourceId) {
		this.sourceId = sourceId;
		return this;
	}
	public TransactionMarker setSourceType(String sourceType) {
		this.sourceType = sourceType;
		return this;
	}
	public TransactionMarker setDestinationId(String destinationId) {
		this.destinationId = destinationId;
		return this;
	}
	public TransactionMarker setDestinationType(String destinationType) {
		this.destinationType = destinationType;
		return this;
	}
	public TransactionMarker setMessagePayload(String messagePayload) {
		this.messagePayload = messagePayload;
		return this;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public static String getDefaultFormat() {
		return DEFAULT_FORMAT;
	}
	public static String getCondFormat1() {
		return COND_FORMAT_1;
	}
	public static String getCondFormat2() {
		return COND_FORMAT_2;
	}
	public static String getCondFormat3() {
		return COND_FORMAT_3;
	}
	public FoundationLoggingEventType getEventType() {
		return eventType;
	}
	public FoundationLoggingTransMsgType getTransMsgType() {
		return transMsgType;
	}
	public String getSessionId() {
		return sessionId;
	}
	public String getSourceId() {
		return sourceId;
	}
	public String getSourceType() {
		return sourceType;
	}
	public String getDestinationId() {
		return destinationId;
	}
	public String getDestinationType() {
		return destinationType;
	}
	public String getMessagePayload() {
		return messagePayload;
	}

}
