package com.camelatwork.services;

import com.camelatwork.model.bo.Book;

/**
 * Created with IntelliJ IDEA.
 * User: marcomaccio
 * Date: 21/11/2012
 * Time: 22:35
 * To change this template use File | Settings | File Templates.
 */
public interface BookStoreService
{
    public void add(Book book);

    public Book getBook(Long id);
}
