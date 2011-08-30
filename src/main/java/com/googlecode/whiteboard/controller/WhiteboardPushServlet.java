/*
* @author  Oleg Varaksin (ovaraksin@googlemail.com)
* $$Id$$
*/

package com.googlecode.whiteboard.controller;

import org.atmosphere.cpr.AtmosphereServlet;
import org.atmosphere.cpr.Broadcaster;
import org.atmosphere.cpr.BroadcasterFactory;
import org.atmosphere.handler.ReflectorServletProcessor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletConfig;
import java.lang.reflect.InvocationTargetException;

public class WhiteboardPushServlet extends AtmosphereServlet
{
    private static final Logger logger = LoggerFactory.getLogger(AtmosphereServlet.class);

    protected boolean detectSupportedFramework(ServletConfig sc) throws ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {
        ClassLoader cl = Thread.currentThread().getContextClassLoader();
        try {
            cl.loadClass(JERSEY_CONTAINER);
            useStreamForFlushingComments = true;
        } catch (Throwable t) {
            return false;
        }

        logger.warn("Missing META-INF/atmosphere.xml but found the Jersey runtime. Starting Jersey");

        ReflectorServletProcessor rsp = new ReflectorServletProcessor();
        if (!isBroadcasterSpecified) {
            broadcasterClassName = lookupDefaultBroadcasterType();
        }

        rsp.setServletClassName(JERSEY_CONTAINER);
        sessionSupport(false);
        addInitParameter(DISABLE_ONSTATE_EVENT, "true");

        String mapping = sc.getInitParameter(PROPERTY_SERVLET_MAPPING);
        if (mapping == null) {
            mapping = "/*";
        }

        Class<? extends Broadcaster> bc = (Class<? extends Broadcaster>) cl.loadClass(broadcasterClassName);
        Broadcaster b = BroadcasterFactory.getDefault().get(bc, mapping);
        addAtmosphereHandler(mapping, rsp, b);

        return true;
    }
}
