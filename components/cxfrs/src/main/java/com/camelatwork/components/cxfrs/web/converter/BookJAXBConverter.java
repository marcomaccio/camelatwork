package com.camelatwork.components.cxfrs.web.converter;

import com.camelatwork.common.bookstore.model.bo.BookBO;
import com.camelatwork.components.model.to.BookTOType;
import org.apache.camel.Converter;
import org.apache.camel.Exchange;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created with IntelliJ IDEA.
 * User: marcomaccio
 * Date: 03/11/2012
 * Time: 12:05
 * To change this template use File | Settings | File Templates.
 */
@Converter
public class BookJAXBConverter
{
    /**
     *
     */
    private BookJAXBConverter() {}

    private static final Logger LOG = LoggerFactory.getLogger(BookJAXBConverter.class);

    /**
     *
     * @param bookTOType
     * @param exchange
     * @return
     * @throws Exception
     */
    public static BookBO toBookBO(BookTOType bookTOType, Exchange exchange) throws Exception
    {
        LOG.info("-------TYPE CONVERSION toBookBO Method------START-------");
        BookBO bookBO = new BookBO();
        LOG.debug("exchange" + exchange.getIn().getBody().toString());

        return  bookBO;
    }

}
