package log4j.example;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class LoggerExample {
    private static final Logger LOGGER = LogManager.getLogger(LoggerExample.class);

    public static void main(String[] args) {
        LOGGER.trace("Trace");
        LOGGER.trace("Trace");
        LOGGER.trace("Trace");
        LOGGER.debug("Debug");
        LOGGER.info("Info");
        LOGGER.warn("Warn");
        LOGGER.error("Error");
        LOGGER.fatal("Fatal");
    }
}