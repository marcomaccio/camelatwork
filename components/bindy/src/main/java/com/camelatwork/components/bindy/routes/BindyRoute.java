package com.camelatwork.components.bindy.routes;

import com.camelatwork.components.bindy.beans.BCVTransactionHandler;
import com.camelatwork.components.bindy.model.bo.Transaction;
import com.camelatwork.components.bindy.model.to.BCVAccountStatement;
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

    BindyCsvDataFormat formatBCVExport = new BindyCsvDataFormat("com.camelatwork.components.bindy.model");

    @Override
    public void configure() throws Exception {

        LOGGER.debug("Configure method called...");

        from("file:src/main/data/csv?noop=true&delay=10")
            .routeId("Bindy :: BCV Import Service ")
            .log(LoggingLevel.DEBUG, "Printing all file: \n ${body}  \n")

            .unmarshal(formatBCVExport)

            .split(body())
                .log(LoggingLevel.DEBUG, "This is the POJO: ${body}")
                .convertBodyTo(BCVAccountStatement.class)
                .convertBodyTo(Transaction.class)

                //.process(new SimpleProcessor())
                .bean(BCVTransactionHandler.class, "handleTransaction(com.camelatwork.components.bindy.model.bo.Transaction)")

            .end();

    }

}