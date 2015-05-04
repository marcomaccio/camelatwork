package com.camelatwork.components.cache.tests;

import com.camelatwork.components.cache.routes.BookStoreCacheRoute;
import org.apache.camel.builder.NotifyBuilder;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.component.seda.SedaEndpoint;
import org.apache.camel.test.junit4.CamelTestSupport;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.TimeUnit;

/**
 * Created with IntelliJ IDEA.
 * User: marcomaccio
 * Date: 21/11/2012
 * Time: 15:52
 * To change this template use File | Settings | File Templates.
 */
public class MySecondTest extends CamelTestSupport
{
    private static final transient Logger LOGGER = LoggerFactory.getLogger(MySecondTest.class);

    @Override
    public RouteBuilder createRouteBuilder()
    {
        return new BookStoreCacheRoute();
    }

    @Test
    public void testNotifyFrom() throws Exception
    {
        LOGGER.debug("TEST NOTIFY FROM -- Started");
        NotifyBuilder notifyProvisioning = new NotifyBuilder(context)
                .from("seda:provisioning").whenDone(1).create();

        LOGGER.debug("Sending Body and Header to seda:provisioning");
        template.sendBodyAndHeader("seda:provisioning", "Camel at work by Marco Maccio","bookId", "Camel_at_work");
        //LOGGER.debug("Sending Body and Header to seda:bookstore");
        //template.sendBodyAndHeader("seda:bookstore","Camel at work by Marco Maccio", "bookId", "Camel_at_work");

        LOGGER.debug("Set the matching on seda:provisioning");
        boolean matches = notifyProvisioning.matches(1, TimeUnit.SECONDS);
        LOGGER.debug("Matches value: " + matches);

        assertTrue(matches);

        LOGGER.debug("get the endpoint instance for: seda:provisioning ");
        SedaEndpoint sedaFirstRegistration = context.getEndpoint("seda:firstRegistration", SedaEndpoint.class);
        SedaEndpoint sedaAlreadyRegistered = context.getEndpoint("seda:alreadyRegistered", SedaEndpoint.class);

        SedaEndpoint sedaInvalid = context.getEndpoint("seda:alreadyRegistered", SedaEndpoint.class);
        SedaEndpoint sedaNextPhase = context.getEndpoint("seda:nextPhase", SedaEndpoint.class);

        int size1 = sedaFirstRegistration.getExchanges().size();
        LOGGER.debug("Size of Exchanges List " + size1 );
        assertEquals(1, size1);

    }
}
