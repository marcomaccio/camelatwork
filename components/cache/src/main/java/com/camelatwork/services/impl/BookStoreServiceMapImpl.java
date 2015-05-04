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

    public BookStoreServiceMapImpl()
    {
        bookMap = new HashMap<Long, Book>();
    }

    @Override
    public void add(Book book)
    {
        bookMap.put(book.getId(), book);
    }

    @Override
    public Book getBook(Long id)
    {
        Book book = null;
        book = bookMap.get(id);
        return book;  //To change body of implemented methods use File | Settings | File Templates.
    }
}
