package com.camelatwork.common.bookstore.dao;

import com.camelatwork.common.bookstore.model.bo.BookBO;

/**
 * Created with IntelliJ IDEA.
 * User: marcomaccio
 * Date: 01/11/2012
 * Time: 15:46
 * To change this template use File | Settings | File Templates.
 */
public interface BookStoreDAO
{
    public boolean createBook(BookBO bookBO);

    public boolean  updateBook(BookBO bookBO);

    public boolean deleteBook(Long id);

    public BookBO findBookById(Long id);
}
