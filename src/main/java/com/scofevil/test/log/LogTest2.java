package com.scofevil.test.log;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * @param
 * @author haifeng.lu
 * @see
 * @since 1.0
 */
public class LogTest2 {
    public static void test2() {
        Logger logger = LogManager.getLogger(LogManager.ROOT_LOGGER_NAME);
        logger.trace("2trace level");
        logger.debug("2debug level");
        logger.info("2info level");
        logger.warn("2warn level");
        logger.error("2jerror level");
        logger.fatal("2fatal level");
    }
}
