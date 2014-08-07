package com.camelatwork.model.bo;

import java.io.Serializable;

/**
 * Created with IntelliJ IDEA.
 * User: marcomaccio
 * Date: 21/11/2012
 * Time: 22:37
 * To change this template use File | Settings | File Templates.
 */
public class Book   implements Serializable
{

    private Long    id;
    private String  title;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
