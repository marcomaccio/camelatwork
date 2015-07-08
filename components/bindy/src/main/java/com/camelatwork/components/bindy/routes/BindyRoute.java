package com.camelatwork.components.bindy.routes;

import org.apache.camel.LoggingLevel;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.dataformat.bindy.csv.BindyCsvDataFormat;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by marcomaccio on 11/06/2015.
 */
public class BindyRoute extends RouteBuilder
{
    private static final Logger LOGGER = LoggerFactory.getLogger(BindyRoute.class);

    BindyCsvDataFormat formatBCVExport = new BindyCsvDataFormat(com.camelatwork.components.bindy.model.BCVBankExport.class);

    @Override
    public void configure() throws Exception {

        LOGGER.debug("Configure method called...");

        from("file:src/main/data/csv?noop=true&delay=10")
            .routeId("Bindy :: BCV Import Service ")
                .log(LoggingLevel.DEBUG, "${body}  ")
                .split().tokenize("\n", 5).streaming()
                    .log(LoggingLevel.DEBUG, "${body}  ")
                    .unmarshal(formatBCVExport)

                .end()    ;

    }

}