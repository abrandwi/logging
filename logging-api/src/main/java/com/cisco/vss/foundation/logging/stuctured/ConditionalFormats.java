package com.cisco.vss.foundation.logging.stuctured;

import java.lang.annotation.*;

@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface ConditionalFormats {	
	ConditionalFormat[] value();    
}
