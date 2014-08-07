/**
 * 
 */
package com.camelatwork.components.cxfrs.services;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import javax.ws.rs.*;
import javax.ws.rs.core.Response;
import javax.xml.bind.JAXBElement;
import com.camelatwork.components.model.to.BookTOType;
import com.camelatwork.components.model.to.BooksTOType;

/**
 * @author marcomaccio
 *
 */
@WebService
@Path("/bookstore")
public interface BookStoreRESTService
{

    @WebMethod
    @POST
    @Path("/book")
    @Consumes({"application/xml","application/json"})
    public Response createBook(@WebParam(name = "BooksTO") JAXBElement<BooksTOType> booksTOTypeJAXBElement);


    @WebMethod
    @GET
    @Path("/book/{bookId}")
    @Produces({"application/xml","application/json"})
    public JAXBElement<BookTOType> getBook(@PathParam("bookId") Long bookId);

    @WebMethod
    @PUT
    @Path("/book")
    public Response updateBook(@WebParam(name = "BookTO") JAXBElement<BooksTOType> booksTOTypeJAXBElement);

    @WebMethod
    @DELETE
    @Path("/book/{bookId}")
    public Response deleteBook(@PathParam("bookId") Long bookId);

    @WebMethod
    @GET
    @Path("/books")
    public JAXBElement<BooksTOType> getBooks();

}
