package com.camelatwork.components.cache.tests;

import org.apache.camel.EndpointInject;
import org.apache.camel.Produce;
import org.apache.camel.ProducerTemplate;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.component.mock.MockEndpoint;
import org.apache.camel.test.junit4.CamelTestSupport;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created with IntelliJ IDEA.
 * User: marcomaccio
 * Date: 20/11/2012
 * Time: 18:09
 * To change this template use File | Settings | File Templates.
 */
public class MyFirstTest extends CamelTestSupport
{
    private static final transient Logger LOGGER = LoggerFactory.getLogger(MyFirstTest.class);

    @EndpointInject(uri = "mock:result")
    protected MockEndpoint resultEndpoint;

    @Produce(uri = "direct:start")
    protected ProducerTemplate template;

    @Override
    protected RouteBuilder createRouteBuilder()
    {
        LOGGER.info("Create Route -- Start ");

        return new RouteBuilder() {
            @Override
            public void configure() throws Exception
            {
                //LOGGER.info("Route builder " + this.getRouteCollection().getRoutes().get(0).getShortName());
                from("direct:start")
                        .routeId("MyFirstRouteUnderTest")
                        .filter(header("foo").isEqualTo("bar"))
                        .to("mock:result");

                LOGGER.info("Route builder -- Defined Route");
            }
        };
    }


    @Test
    public void testSendMatchingMessage() throws Exception
    {
        String expectedBody = "<matched/>";

        resultEndpoint.expectedBodiesReceived(expectedBody);

        template.sendBodyAndHeader(expectedBody, "foo", "bar");

        resultEndpoint.assertIsSatisfied();
    }
}
