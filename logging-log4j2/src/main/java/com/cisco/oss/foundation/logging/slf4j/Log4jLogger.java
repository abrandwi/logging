/*
 * Copyright 2015 Cisco Systems, Inc.
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *  http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */

package com.cisco.oss.foundation.logging.slf4j;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.message.Message;
import org.apache.logging.log4j.message.ParameterizedMessage;
import org.apache.logging.log4j.message.SimpleMessage;
import org.apache.logging.log4j.spi.ExtendedLogger;
import org.slf4j.Marker;
import org.slf4j.MarkerFactory;
import org.slf4j.spi.LocationAwareLogger;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/**
 * Created by Yair Ogen on 20/07/2014.
 */
public class Log4jLogger implements LocationAwareLogger, Serializable {

    public static final String FQCN = Log4jLogger.class.getName();

    private static final long serialVersionUID = 7869000638091304316L;
    private static final Marker EVENT_MARKER = MarkerFactory.getMarker("EVENT");
    private final boolean eventLogger;
    private final String name;
    private transient ExtendedLogger logger;
    private Level log4jLevel;

    public Log4jLogger(final ExtendedLogger logger, final String name) {
        this.logger = logger;
        this.eventLogger = "EventLogger".equals(name);
        this.name = name;
//        this.converter = createConverter();
    }
//    private transient EventDataConverter converter;

    private static org.apache.logging.log4j.Marker getMarker(final Marker marker) {
        if (marker != null) {
            if (marker instanceof org.apache.logging.log4j.Marker) {
                return (org.apache.logging.log4j.Marker) marker;
            } else {
                return new Log4jMarker(marker);
            }

        } else {
            return null;
        }
    }

    /**
     * Always treat de-serialization as a full-blown constructor, by validating the final state of
     * the de-serialized object.
     */


    public static Level getLevel(final int i) {
        switch (i) {
            case TRACE_INT:
                return Level.TRACE;
            case DEBUG_INT:
                return Level.DEBUG;
            case INFO_INT:
                return Level.INFO;
            case WARN_INT:
                return Level.WARN;
            case ERROR_INT:
                return Level.ERROR;
        }
        return Level.ERROR;
    }

    @Override
    public String getName() {
        return name;
    }

    public Level getLog4jLevel() {
        return log4jLevel;
    }

    @Override
    public void trace(final String format) {
        logger.logIfEnabled(FQCN, Level.TRACE, null, format);
    }

    @Override
    public void trace(final String format, final Object o) {
        logger.logIfEnabled(FQCN, Level.TRACE, null, format, o);
    }

    @Override
    public void trace(final String format, final Object arg1, final Object arg2) {
        logger.logIfEnabled(FQCN, Level.TRACE, null, format, arg1, arg2);
    }

    @Override
    public void trace(final String format, final Object... args) {
        logger.logIfEnabled(FQCN, Level.TRACE, null, format, args);
    }

    @Override
    public void trace(final String format, final Throwable t) {
        logger.logIfEnabled(FQCN, Level.TRACE, null, format, t);
    }

    @Override
    public boolean isTraceEnabled() {
        return logger.isEnabled(Level.TRACE, null, null);
    }

    @Override
    public boolean isTraceEnabled(final Marker marker) {
        return logger.isEnabled(Level.TRACE, getMarker(marker), null);
    }

    @Override
    public void trace(final Marker marker, final String s) {
        logger.logIfEnabled(FQCN, Level.TRACE, getMarker(marker), s);
    }

    @Override
    public void trace(final Marker marker, final String s, final Object o) {
        logger.logIfEnabled(FQCN, Level.TRACE, getMarker(marker), s, o);
    }

    @Override
    public void trace(final Marker marker, final String s, final Object o, final Object o1) {
        logger.logIfEnabled(FQCN, Level.TRACE, getMarker(marker), s, o, o1);
    }

    @Override
    public void trace(final Marker marker, final String s, final Object... objects) {
        logger.logIfEnabled(FQCN, Level.TRACE, getMarker(marker), s, objects);
    }

    @Override
    public void trace(final Marker marker, final String s, final Throwable throwable) {
        logger.logIfEnabled(FQCN, Level.TRACE, getMarker(marker), s, throwable);
    }

    @Override
    public void debug(final String format) {
        logger.logIfEnabled(FQCN, Level.DEBUG, null, format);
    }

    @Override
    public void debug(final String format, final Object o) {
        logger.logIfEnabled(FQCN, Level.DEBUG, null, format, o);
    }

    @Override
    public void debug(final String format, final Object arg1, final Object arg2) {
        logger.logIfEnabled(FQCN, Level.DEBUG, null, format, arg1, arg2);
    }

    @Override
    public void debug(final String format, final Object... args) {
        logger.logIfEnabled(FQCN, Level.DEBUG, null, format, args);
    }

    @Override
    public void debug(final String format, final Throwable t) {
        logger.logIfEnabled(FQCN, Level.DEBUG, null, format, t);
    }

    @Override
    public boolean isDebugEnabled() {
        return logger.isEnabled(Level.DEBUG, null, null);
    }

    @Override
    public boolean isDebugEnabled(final Marker marker) {
        return logger.isEnabled(Level.DEBUG, getMarker(marker), null);
    }

    @Override
    public void debug(final Marker marker, final String s) {
        logger.logIfEnabled(FQCN, Level.DEBUG, getMarker(marker), s);
    }

    @Override
    public void debug(final Marker marker, final String s, final Object o) {
        logger.logIfEnabled(FQCN, Level.DEBUG, getMarker(marker), s, o);
    }

    @Override
    public void debug(final Marker marker, final String s, final Object o, final Object o1) {
        logger.logIfEnabled(FQCN, Level.DEBUG, getMarker(marker), s, o, o1);
    }

    @Override
    public void debug(final Marker marker, final String s, final Object... objects) {
        logger.logIfEnabled(FQCN, Level.DEBUG, getMarker(marker), s, objects);
    }

    @Override
    public void debug(final Marker marker, final String s, final Throwable throwable) {
        logger.logIfEnabled(FQCN, Level.DEBUG, getMarker(marker), s, throwable);
    }

    @Override
    public void info(final String format) {
        logger.logIfEnabled(FQCN, Level.INFO, null, format);
    }

    @Override
    public void info(final String format, final Object o) {
        logger.logIfEnabled(FQCN, Level.INFO, null, format, o);
    }

    @Override
    public void info(final String format, final Object arg1, final Object arg2) {
        logger.logIfEnabled(FQCN, Level.INFO, null, format, arg1, arg2);
    }

    @Override
    public void info(final String format, final Object... args) {
        logger.logIfEnabled(FQCN, Level.INFO, null, format, args);
    }

    @Override
    public void info(final String format, final Throwable t) {
        logger.logIfEnabled(FQCN, Level.INFO, null, format, t);
    }

    @Override
    public boolean isInfoEnabled() {
        return logger.isEnabled(Level.INFO, null, null);
    }

    @Override
    public boolean isInfoEnabled(final Marker marker) {
        return logger.isEnabled(Level.INFO, getMarker(marker), null);
    }

    @Override
    public void info(final Marker marker, final String s) {
        logger.logIfEnabled(FQCN, Level.INFO, getMarker(marker), s);
    }

    @Override
    public void info(final Marker marker, final String s, final Object o) {
        logger.logIfEnabled(FQCN, Level.INFO, getMarker(marker), s, o);
    }

    @Override
    public void info(final Marker marker, final String s, final Object o, final Object o1) {
        logger.logIfEnabled(FQCN, Level.INFO, getMarker(marker), s, o, o1);
    }

    @Override
    public void info(final Marker marker, final String s, final Object... objects) {
        logger.logIfEnabled(FQCN, Level.INFO, getMarker(marker), s, objects);
    }

    @Override
    public void info(final Marker marker, final String s, final Throwable throwable) {
        logger.logIfEnabled(FQCN, Level.INFO, getMarker(marker), s, throwable);
    }

    @Override
    public void warn(final String format) {
        logger.logIfEnabled(FQCN, Level.WARN, null, format);
    }

    @Override
    public void warn(final String format, final Object o) {
        logger.logIfEnabled(FQCN, Level.WARN, null, format, o);
    }

    @Override
    public void warn(final String format, final Object arg1, final Object arg2) {
        logger.logIfEnabled(FQCN, Level.WARN, null, format, arg1, arg2);
    }

    @Override
    public void warn(final String format, final Object... args) {
        logger.logIfEnabled(FQCN, Level.WARN, null, format, args);
    }

    @Override
    public void warn(final String format, final Throwable t) {
        logger.logIfEnabled(FQCN, Level.WARN, null, format, t);
    }

    @Override
    public boolean isWarnEnabled() {
        return logger.isEnabled(Level.WARN, null, null);
    }

    @Override
    public boolean isWarnEnabled(final Marker marker) {
        return logger.isEnabled(Level.WARN, getMarker(marker), null);
    }

    @Override
    public void warn(final Marker marker, final String s) {
        logger.logIfEnabled(FQCN, Level.WARN, getMarker(marker), s);
    }

    @Override
    public void warn(final Marker marker, final String s, final Object o) {
        logger.logIfEnabled(FQCN, Level.WARN, getMarker(marker), s, o);
    }

    @Override
    public void warn(final Marker marker, final String s, final Object o, final Object o1) {
        logger.logIfEnabled(FQCN, Level.WARN, getMarker(marker), s, o, o1);
    }

    @Override
    public void warn(final Marker marker, final String s, final Object... objects) {
        logger.logIfEnabled(FQCN, Level.WARN, getMarker(marker), s, objects);
    }

    @Override
    public void warn(final Marker marker, final String s, final Throwable throwable) {
        logger.logIfEnabled(FQCN, Level.WARN, getMarker(marker), s, throwable);
    }

    @Override
    public void error(final String format) {
        logger.logIfEnabled(FQCN, Level.ERROR, null, format);
    }

    @Override
    public void error(final String format, final Object o) {
        logger.logIfEnabled(FQCN, Level.ERROR, null, format, o);
    }

    @Override
    public void error(final String format, final Object arg1, final Object arg2) {
        logger.logIfEnabled(FQCN, Level.ERROR, null, format, arg1, arg2);
    }

    @Override
    public void error(final String format, final Object... args) {
        logger.logIfEnabled(FQCN, Level.ERROR, null, format, args);
    }

    @Override
    public void error(final String format, final Throwable t) {
        logger.logIfEnabled(FQCN, Level.ERROR, null, format, t);
    }

    @Override
    public boolean isErrorEnabled() {
        return logger.isEnabled(Level.ERROR, null, null);
    }

    @Override
    public boolean isErrorEnabled(final Marker marker) {
        return logger.isEnabled(Level.ERROR, getMarker(marker), null);
    }

    @Override
    public void error(final Marker marker, final String s) {
        logger.logIfEnabled(FQCN, Level.ERROR, getMarker(marker), s);
    }

    @Override
    public void error(final Marker marker, final String s, final Object o) {
        logger.logIfEnabled(FQCN, Level.ERROR, getMarker(marker), s, o);
    }

    @Override
    public void error(final Marker marker, final String s, final Object o, final Object o1) {
        logger.logIfEnabled(FQCN, Level.ERROR, getMarker(marker), s, o, o1);
    }

    @Override
    public void error(final Marker marker, final String s, final Object... objects) {
        logger.logIfEnabled(FQCN, Level.ERROR, getMarker(marker), s, objects);
    }

    @Override
    public void error(final Marker marker, final String s, final Throwable throwable) {
        logger.logIfEnabled(FQCN, Level.ERROR, getMarker(marker), s, throwable);
    }

    @Override
    public void log(final Marker marker, final String fqcn, final int level, final String message, final Object[] params, Throwable throwable) {
        log4jLevel = getLevel(level);
        final org.apache.logging.log4j.Marker log4jMarker = getMarker(marker);

        if (!logger.isEnabled(log4jLevel, log4jMarker, message, params)) {
            return;
        }
        final Message msg;
//        if (eventLogger && marker != null && marker.contains(EVENT_MARKER) && converter != null) {
        if (eventLogger && marker != null && marker.contains(EVENT_MARKER)) {
//            msg = converter.convertEvent(message, params, throwable);
            msg = new SimpleMessage(message);
        } else if (params == null) {
            msg = new SimpleMessage(message);
        } else {
            msg = new ParameterizedMessage(message, params, throwable);
            if (throwable != null) {
                throwable = msg.getThrowable();
            }
        }
        logger.logMessage(fqcn, log4jLevel, log4jMarker, msg, throwable);
    }

    private void readObject(final ObjectInputStream aInputStream) throws ClassNotFoundException, IOException {
        // always perform the default de-serialization first
        aInputStream.defaultReadObject();
        logger = LogManager.getContext().getLogger(name);
//        converter = createConverter();
    }

//    private static EventDataConverter createConverter() {
//        try {
//            Class.forName("org.slf4j.ext.EventData");
//            return new EventDataConverter();
//        } catch (final ClassNotFoundException cnfe) {
//            return null;
//        }
//    }

    /**
     * This is the default implementation of writeObject. Customise if necessary.
     */
    private void writeObject(final ObjectOutputStream aOutputStream) throws IOException {
        // perform the default serialization for all non-transient, non-static fields
        aOutputStream.defaultWriteObject();
    }
}
