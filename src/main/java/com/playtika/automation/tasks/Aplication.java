package com.playtika.automation.tasks;

import javafx.application.Application;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Aplication {
    private static final Logger LOG
            = LoggerFactory.getLogger(Application.class);

    public static void main(String[] args) {
        LOG.error("Error log");
        LOG.warn("WARN log");
        LOG.info("INFO log");
        LOG.debug("DEBUG log");
        LOG.trace("TRACE log");
    }
}
