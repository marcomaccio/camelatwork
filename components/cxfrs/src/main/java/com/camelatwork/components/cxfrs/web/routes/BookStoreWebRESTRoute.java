/**
 * 
 */
package com.camelatwork.components.cxfrs.web.routes;

import org.apache.camel.LoggingLevel;
import org.apache.camel.builder.NoErrorHandlerBuilder;
import org.apache.camel.builder.RouteBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.camelatwork.components.cxfrs.web.properties.WebRestRouteProperties;

/**
 * @author marcomaccio
 *
 */
public class BookStoreWebRESTRoute extends RouteBuilder 
{
	private  static final transient Logger LOG = LoggerFactory.getLogger(BookStoreWebRESTRoute.class);

	private WebRestRouteProperties webRESTRouteProperties;

    public WebRestRouteProperties getWebRestRouteProperties()
    {
        return webRESTRouteProperties;
    }

    public void setWebRestRouteProperties(WebRestRouteProperties webRESTRouteProperties)
    {
        this.webRESTRouteProperties = webRESTRouteProperties;
    }
    
    public void listProperties()
    {
        LOG.debug("BookStoreWebRESTRoute::listProperties() exceptionQueueProperties: " + webRESTRouteProperties);
    }
    
	/* (non-Javadoc)
	 * @see org.apache.camel.builder.RouteBuilder#configure()
	 */
	@Override
	public void configure() throws Exception 
	{
		LOG.info(" Router BookStoreRESTRoute started ");
        errorHandler(new NoErrorHandlerBuilder());

        from("cxfrs://bean://BookStoreRESTEndpoint")
            .routeId("BookStoreRESTRoute")
            .log(LoggingLevel.INFO, "BookStoreWebRESTRoute:: from(cxfrs) received request from REST interface start processing: ${body}")
            .processRef("requestMappingProcessor");

            /**
            .log(LoggingLevel.INFO,"Body:  ${body}")
            .log(LoggingLevel.INFO, "Property: " + property("operationName").toString())

            .choice()  //getBook has been called by the requester
                .when(property("operationName").isEqualTo("getBook"))
                .log(LoggingLevel.INFO, "Operation Choosen is GetBook details")
                .beanRef("bookStoreDAO","findBookById")
                .log(LoggingLevel.INFO, "Body after bookDAO ${body}")

            .choice()   //createBook has been called by the requester
                .when(property("operationName").isEqualTo("createBook"))
                //the object passed by the body exchange has to be transformed by BookTO to a BookDO
                .beanRef("bookStoreDAO","createBook")

            .choice()  //updateBook has been called by the requester
                .when(property("operationName").isEqualTo("updateBook"))
                .log(LoggingLevel.INFO, "Operation Choosen is GetBook details")


            .end()
            .transform(constant("OK"));
            */
	}

}
