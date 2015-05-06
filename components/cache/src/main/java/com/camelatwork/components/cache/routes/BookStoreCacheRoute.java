package com.camelatwork.components.cache.routes;

import org.apache.camel.LoggingLevel;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.component.cache.CacheConstants;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created with IntelliJ IDEA.
 * User: marcomaccio
 * Date: 20/11/2012
 * Time: 17:14
 * To change this template use File | Settings | File Templates.
 */
public class BookStoreCacheRoute extends RouteBuilder
{
    private static final transient Logger LOGGER = LoggerFactory.getLogger(BookStoreCacheRoute.class);


    @Override
    public void configure() throws Exception
    {
        from("seda:provisioning")
                .routeId("BookStore :: Provisioning")
                .log(LoggingLevel.DEBUG, "${body}  ")
                // Prepare headers
                .setHeader(CacheConstants.CACHE_OPERATION, constant(CacheConstants.CACHE_OPERATION_CHECK))
                .setHeader(CacheConstants.CACHE_KEY, header("bookId"))
                .to("cache://MyApplicationCache") // Check if entry was not found
                .choice().when(header(CacheConstants.CACHE_ELEMENT_WAS_FOUND).isNull())
                        // If not found, get the payload and put it to cache
                        //.to("cxf:bean:someHeavyweightOperation")
                    .log(LoggingLevel.DEBUG, "${body}  has not been found in the cache")
                    .setHeader(CacheConstants.CACHE_OPERATION, constant(CacheConstants.CACHE_OPERATION_ADD))
                    .setHeader(CacheConstants.CACHE_KEY, header("bookId"))
                    .to("cache://MyApplicationCache")
                    .log(LoggingLevel.DEBUG, "${body} has been added ")
                    .to("seda:firstRegistration")
                .otherwise()
                    .to("seda:alreadyRegistered")
                .end();


        from("seda:bookstore")
            // Prepare headers
            .setHeader(CacheConstants.CACHE_OPERATION, constant(CacheConstants.CACHE_OPERATION_GET))
            .setHeader(CacheConstants.CACHE_KEY, header("bookId"))
            .to("cache://MyApplicationCache")
            .choice().when(header(CacheConstants.CACHE_ELEMENT_WAS_FOUND).isNull())
                    // If not found, get the payload and put it to cache
                    .to("seda:invalid")
            .end()
            .to("seda:nextPhase");
    }


}
