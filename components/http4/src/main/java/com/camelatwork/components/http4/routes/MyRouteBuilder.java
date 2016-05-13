package com.camelatwork.components.http4.routes;

import com.camelatwork.components.http4.properties.MyRouteProperties;
import org.apache.camel.Exchange;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.component.http4.HttpMethods;

/**
 * A Camel Java DSL Router
 */
public class MyRouteBuilder extends RouteBuilder {

    private MyRouteProperties routeProperties;

    public MyRouteProperties getRouteProperties() {
        return routeProperties;
    }

    public void setRouteProperties(MyRouteProperties routeProperties) {
        this.routeProperties = routeProperties;
    }

    /**
     * Let's configure the Camel routing rules using Java code...
     */
    public void configure() {

        // here is a sample which processes the input files
        // (leaving them in place - see the 'noop' flag)
        // then performs content based routing on the message using XPath
        from("file:src/data?noop=true")
            .log("${body}")
            .setHeader("CamelHttpMethod",constant(HttpMethods.GET))
            .setHeader(Exchange.HTTP_QUERY, xpath("/artifact/groupId"))
            .to("http4://"  + getRouteProperties().getRmsHost() +
                    ":"     + getRouteProperties().getRmsPort() +
                    getRouteProperties().getRmsContext()        +
                    getRouteProperties().getRmsServicesPath()   +
                    getRouteProperties().getRmsRepository()     +
                    "/name/marmac/bankanalizer/ba-services-rest-impl-jaxrs/1.0.0.BUILD-SNAPSHOT/ba-services-rest-impl-jaxrs-1.0.0.BUILD-20151023.104028-1.jar")
                .choice()
                    .when(header(Exchange.HTTP_RESPONSE_CODE).isEqualTo(200))
                        .setHeader(Exchange.FILE_NAME, constant("ba-services-rest-impl-jaxrs-1.0.0.BUILD-20151023.104028-1.jar"))
            .to("file:target/downloaded/uk");
    }

}
