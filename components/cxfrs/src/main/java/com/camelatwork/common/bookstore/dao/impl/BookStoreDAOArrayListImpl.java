package com.camelatwork.common.bookstore.dao.impl;

import com.camelatwork.common.bookstore.dao.BookStoreDAO;
import com.camelatwork.common.bookstore.model.bo.BookBO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: marcomaccio
 * Date: 01/11/2012
 * Time: 16:02
 * To change this template use File | Settings | File Templates.
 */
public class BookStoreDAOArrayListImpl implements BookStoreDAO {

    private static final Logger LOG = LoggerFactory.getLogger(BookStoreDAOArrayListImpl.class);
    private List<BookBO> bookBOArrayList = new ArrayList<BookBO>();

    /**
     *
     * @param bookBO
     * @return
     */
    @Override
    public boolean createBook(BookBO bookBO)
    {
        if(LOG.isDebugEnabled()){LOG.debug("createBook :: " + bookBO.toString() );}
        //This Method Simulate the creation of the Book in the BookStore.
        //it checks that the book is not present in the BookStore
        //here to keep it simple check only if the title is not present.
        if(!bookBOArrayList.contains(bookBO))
        {
            bookBOArrayList.add(bookBO);
        }

        if(LOG.isDebugEnabled()){LOG.debug("createBook :: bookList lenght " + bookBOArrayList.size());}

        return true;
    }

    /**
     *
     * @param bookBO
     * @return
     */
    @Override
    public boolean updateBook(BookBO bookBO)
    {
        if(LOG.isDebugEnabled()){
            LOG.debug("updateBook :: " + bookBO.toString() );
        }

        if(!bookBOArrayList.contains(bookBO))
        {

            int index = bookBOArrayList.indexOf(bookBO);
            bookBOArrayList.set(index, bookBO);
        }

        if(LOG.isDebugEnabled()){
            LOG.debug("updateBook :: bookList lenght " + bookBOArrayList.size());
        }
        return true;
    }

    /**
     *
     * @param id
     * @return
     */
    @Override
    public boolean deleteBook(Long id)
    {
        return false;
    }

    /**
     *
     * @param id
     * @return
     */
    @Override
    public BookBO findBookById(Long id)
    {
        if(LOG.isDebugEnabled()){
            LOG.debug("findBookById :: " + id );
        }
        BookBO bookBO = new BookBO(1L,"If this is a man",1980L);

        if(LOG.isDebugEnabled()){
            LOG.debug("findBookById :: bookBO " + bookBO.toString());
        }
        return bookBO;
    }
}
