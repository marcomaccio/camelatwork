package com.camelatwork.basics.tests.simpletests;

import org.apache.camel.EndpointInject;
import org.apache.camel.Produce;
import org.apache.camel.ProducerTemplate;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.component.mock.MockEndpoint;
import org.apache.camel.test.junit4.CamelTestSupport;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created with IntelliJ IDEA.
 * User: marcomaccio
 * Date: 03/12/2012
 * Time: 16:15
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
    public RouteBuilder createRouteBuilder()
    {
        return new RouteBuilder() {
            @Override
            public void configure() throws Exception
            {
                from("direct:start").filter(header("foo").isEqualTo("bar")).to("mock:result");

            }
        };
    }
}
