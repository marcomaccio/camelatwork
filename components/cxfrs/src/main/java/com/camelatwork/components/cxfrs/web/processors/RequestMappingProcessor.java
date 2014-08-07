/**
 * 
 */
package com.camelatwork.components.cxfrs.web.processors;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import com.camelatwork.components.model.to.BooksTOType;
import org.apache.camel.Exchange;
import org.apache.camel.Message;
import org.apache.camel.Processor;
import org.apache.camel.component.cxf.common.message.CxfConstants;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author marcomaccio
 *
 */
public class RequestMappingProcessor implements Processor 
{
private static final transient Logger LOG = LoggerFactory.getLogger(RequestMappingProcessor.class);
	
	private Class<?> 	beanClass;
	private Object 		instance;


    /**
     *
     * @param object
     */
	public RequestMappingProcessor(Object object) 
	{
		//we extract the bean from the object
		beanClass 	= object.getClass();
		//we keep an instance of the object
		instance	= object;
	}

	/**
     * (non-Javadoc)
	 * @see org.apache.camel.Processor#process(org.apache.camel.Exchange)
	 */
	@Override
	public void process(Exchange exchange) throws Exception 
	{
		if (LOG.isDebugEnabled()) {
			LOG.debug("-------RequestMappingProcessor------START-------");
		}
		Message inMessage 	= exchange.getIn();
		Message outMessage	= exchange.getOut();
		
		//retrieve the Operation Name that the client has called via the Service Header.
		String httpMethod 		= inMessage.getHeader(Exchange.HTTP_METHOD, String.class);
		String httpPath 		= inMessage.getHeader(Exchange.HTTP_PATH, String.class);
		String operationName 	= inMessage.getHeader(CxfConstants.OPERATION_NAME, String.class);


		if (LOG.isDebugEnabled()) {
			LOG.debug("RequestMappingProcessor:: Request info: " + 
                    " httpMethod= " + httpMethod +
                    " httpPath= " + httpPath   +
                    " operationName= " + operationName );
        }
        exchange.setProperty("operationName",operationName);

        Method method = findMethod(operationName,
        				exchange.getIn().getBody(Object[].class));

        LOG.debug("RequestMappingProcessor:: Method Name to invoke  : " +
        					method.getName());
		//try to invoke the method and set the response in the exchange out message.
		
		try 
		{
            LOG.debug("Method invoked: " + method);
			Object response = method.invoke(instance,
					exchange.getIn().getBody(Object[].class));
			exchange.getOut().setBody(response);
			LOG.debug("Response from method invocation :" + response);
		} 
		catch (InvocationTargetException ite) 
		{
			LOG.error(ite.getMessage());
			//Printing the stacktrace of the exception as soon as it happens
			ite.printStackTrace();
			//TODO: Throw the exception with an appropriate Application Exception.
			throw new Exception(ite); 
		}
		
		if (LOG.isDebugEnabled()) {
			LOG.debug("-------RequestMappingProcessor------END-------");
		}

	}
	
	private Method findMethod(String operationName, Object[] parameters) throws SecurityException, NoSuchMethodException
	{
		if (LOG.isDebugEnabled()) {
			LOG.debug("findMethod::  " + getParameterTypes(parameters));
		}
		return beanClass.getMethod(operationName, getParameterTypes(parameters));
	}
	
	private Class<?>[] getParameterTypes(Object[] parameters)
	{
		if (LOG.isDebugEnabled()) {
			LOG.debug("getParameterTypes:: parameters length: " + parameters.length);
		}
		if (parameters == null)
		{
			return new Class[0];
		}
		Class<?>[] parameterTypes = new Class[parameters.length];
		int i=0;
		for (Object obj: parameters)
		{
			//get the class by each single parameter
			parameterTypes[i] = obj.getClass();

			if (LOG.isDebugEnabled()) {
				LOG.debug("getParameterTypes  " + parameterTypes[i].toString() +
                        " object =" + obj.toString());
			}
            i++;
		}
		return parameterTypes;
	}

}
