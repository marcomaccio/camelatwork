package com.camelatwork.components.cxfrs.services.impl;

import com.camelatwork.components.cxfrs.services.BookStoreRESTService;
import com.camelatwork.components.model.to.BookTOType;
import com.camelatwork.components.model.to.BooksTOType;
import com.camelatwork.components.model.to.ChapterTOType;
import com.camelatwork.components.model.to.ObjectFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.ws.rs.*;
import javax.ws.rs.core.Response;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.Marshaller;
import java.io.StringWriter;
import java.net.URI;

public class BookStoreRESTServiceImpl implements BookStoreRESTService
{
    private static final transient Logger LOG = LoggerFactory.getLogger(BookStoreRESTServiceImpl.class);

    @Override
	@WebMethod
	@POST
	@Path("/book")
	public Response createBook(@WebParam(name = "BookTO") JAXBElement<BooksTOType> booksTOTypeJAXBElement)
    {
        BooksTOType booksTOType = booksTOTypeJAXBElement.getValue();

        if (LOG.isDebugEnabled())
        {
            LOG.debug("BookStoreRESTServiceImpl:: createBook ------START-------");
            LOG.debug("Books List size" + booksTOType.getBookTO().size());
        }
        if (booksTOType.getBookTO().size() > 0)
        {
            BookTOType bookTOType = booksTOType.getBookTO().get(0);
            //TODO: Insert the transformation from TO to BO and the call to the BookDAO

            LOG.debug("BookId: " + bookTOType.getId() );
            return Response.created(URI.create("/bookstore/book/" + bookTOType.getId())).build();
        }
        return Response.created(URI.create("/")).build();
	}

	@Override
	@WebMethod
	@GET
	@Path("/book/{bookId}")
	public JAXBElement<BookTOType> getBook(@PathParam("bookId") Long bookId)
    {
        ObjectFactory objectFactory = new ObjectFactory();
        BookTOType bookTOType = objectFactory.createBookTOType();
        bookTOType.setId("1");
        bookTOType.setTitle("Book Title 1");
        ChapterTOType chapterTOType1 = objectFactory.createChapterTOType();
        chapterTOType1.setTitle("Chapter 1");
        chapterTOType1.setChapterId("1");
        bookTOType.getChapter().add(chapterTOType1);

        ChapterTOType chapterTOType2 = objectFactory.createChapterTOType();
        chapterTOType2.setTitle("Chapter 2");
        chapterTOType2.setChapterId("2");
        bookTOType.getChapter().add(chapterTOType2);

        JAXBElement<BookTOType> bookTOTypeJAXBElement = objectFactory.createBookTO(bookTOType);

        if (LOG.isDebugEnabled())
        {
            LOG.debug("BookStoreRESTServiceImpl:: getBook ------START-------");
            LOG.debug(bookId.toString());
            LOG.debug("BookStoreRESTServiceImpl:: getBook Request value "+bookId);
        }

		return bookTOTypeJAXBElement;
	}

	@Override
	@WebMethod
	@PUT
	@Path("/book")
	public Response updateBook(@WebParam(name = "bookTO") JAXBElement<BooksTOType> booksTOTypeJAXBElement)
	{
        BooksTOType booksTOType = booksTOTypeJAXBElement.getValue();

        if (LOG.isDebugEnabled())
        {
            LOG.debug("BookStoreRESTServiceImpl:: update ------START-------");
            LOG.debug("Books List size" + booksTOType.getBookTO().size());
        }
        if (booksTOType.getBookTO().size() > 0)
        {
            BookTOType bookTOType = booksTOType.getBookTO().get(0);
            //TODO: Insert the transformation from TO to BO and the call to the BookDAO

            LOG.debug("BookId: " + bookTOType.getId() );
            return Response.created(URI.create("/bookstore/book/" + bookTOType.getId())).build();
        }
        return Response.created(URI.create("/")).build();
	}

	@Override
	@WebMethod
	@DELETE
	@Path("/book/{bookId}")
	public Response deleteBook(@PathParam("bookId") Long bookId)
    {
        if (LOG.isDebugEnabled())
        {
            LOG.debug("BookStoreRESTServiceImpl:: delete ------START-------");
            LOG.debug(bookId.toString());
            LOG.debug("BookStoreRESTServiceImpl:: delete Request value "+bookId);
        }
        return Response.created(URI.create("/")).build();
	}

    @Override
    @WebMethod
    @GET
    @Path("/books")
    public JAXBElement<BooksTOType> getBooks()
    {
        JAXBElement<BooksTOType> booksTOTypeJAXBElement = null;

        LOG.debug(":: getBooks --START--");

        ObjectFactory objectFactory = new ObjectFactory();
        BooksTOType booksTOType = objectFactory.createBooksTOType();

        //BOOK N.1 - example
        BookTOType bookTOType1 = objectFactory.createBookTOType();
        bookTOType1.setId("1");
        bookTOType1.setTitle("Book Title 1");
        ChapterTOType chapterTOType1 = objectFactory.createChapterTOType();
        chapterTOType1.setTitle("Chapter 1");
        chapterTOType1.setChapterId("1");
        //add chapter 1 to the book 1
        bookTOType1.getChapter().add(chapterTOType1);

        ChapterTOType chapterTOType2 = objectFactory.createChapterTOType();
        chapterTOType2.setTitle("Chapter 2");
        chapterTOType2.setChapterId("2");
        //add chapter 2 to the book 1
        bookTOType1.getChapter().add(chapterTOType2);

        //add the book to the Books List
        booksTOType.getBookTO().add(bookTOType1);

        //BOOK N.1 - example
        BookTOType bookTOType2 = objectFactory.createBookTOType();
        bookTOType2.setId("2");
        bookTOType2.setTitle("Book Title B");
        ChapterTOType chapterTOType21 = objectFactory.createChapterTOType();
        chapterTOType21.setTitle("Chapter A");
        chapterTOType21.setChapterId("1");
        bookTOType2.getChapter().add(chapterTOType21);

        ChapterTOType chapterTOType22 = objectFactory.createChapterTOType();
        chapterTOType22.setTitle("Chapter B");
        chapterTOType22.setChapterId("2");
        bookTOType2.getChapter().add(chapterTOType22);
        //add the book to the Books List
        booksTOType.getBookTO().add(bookTOType2);

        booksTOTypeJAXBElement = objectFactory.createBooksTO(booksTOType);
        return booksTOTypeJAXBElement;
    }

    private String marshallBookingFeedbackRequest(JAXBElement<BooksTOType> booksTOTypeJAXBElement) throws Exception
    {
        StringWriter sw = new StringWriter();
        if (booksTOTypeJAXBElement != null && !"".equals(booksTOTypeJAXBElement))
        {
            JAXBContext jaxbContext = JAXBContext.newInstance("com.camelatwork.components.model.to");
            Marshaller marshaller = jaxbContext.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
            marshaller.marshal(booksTOTypeJAXBElement, sw);
            LOG.debug(sw.toString());
        }
        return sw.toString();
    }
}
