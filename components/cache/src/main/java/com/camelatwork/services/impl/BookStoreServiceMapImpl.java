package com.camelatwork.services.impl;

import com.camelatwork.model.bo.Book;
import com.camelatwork.services.BookStoreService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: marcomaccio
 * Date: 21/11/2012
 * Time: 23:00
 * To change this template use File | Settings | File Templates.
 */
public class BookStoreServiceMapImpl implements BookStoreService
{
    private static final transient Logger LOGGER = LoggerFactory.getLogger(BookStoreServiceMapImpl.class);

    private Map<Long,Book> bookMap = null;

    /**
     *
     */
    public BookStoreServiceMapImpl()
    {
        bookMap = new HashMap<Long, Book>();
    }

    @Override
    public void add(Book book)
    {
        LOGGER.info("Number of Books in BookMap: " + bookMap.size() +" previous the add new Item");
        LOGGER.info("Book to be inserted in the BookMap: " + book.toString());
        bookMap.put(book.getId(), book);
        LOGGER.info("Number of Books in BookMap: " + bookMap.size() + " after the add new Item");
    }

    @Override
    public Book getBook(Long id)
    {
        LOGGER.info("Book id to be retrived by the BookMap: " + id);
        Book book = null;
        book = bookMap.get(id);
        LOGGER.info("Book to retrieved by the BookMap: " + book.toString());
        return book;  //To change body of implemented methods use File | Settings | File Templates.
    }
}
