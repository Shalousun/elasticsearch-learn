package com.sunyu.elastic;

import org.apache.log4j.Logger;
/**
 * Hello world!
 */
public class App {
    private static final Logger LOGGER = Logger.getLogger(App.class);
    public static void main(String[] args) throws Exception{
        for (int i = 0; i < 10; i++) {
            LOGGER.error("Info log [" + i + "].");
            Thread.sleep(500);
        }
    }
}
