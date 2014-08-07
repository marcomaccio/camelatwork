package com.camelatwork.common.bookstore.model.bo;

import java.io.Serializable;

/**
 * Created with IntelliJ IDEA.
 * User: marcomaccio
 * Date: 01/11/2012
 * Time: 15:52
 * To change this template use File | Settings | File Templates.
 */
public class ChapterBO implements Serializable
{
    private Long    id;
    private String  name;

    /**
     *
     */
    public ChapterBO() {}

    /**
     *
     * @param id
     * @param name
     */
    public ChapterBO(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    /**
     *
     * @return
     */
    public Long getId() {
        return id;
    }

    /**
     *
     * @param id
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     *
     * @return
     */
    public String getName() {
        return name;
    }

    /**
     *
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ChapterBO chapterBO = (ChapterBO) o;

        if (id != null ? !id.equals(chapterBO.id) : chapterBO.id != null) return false;
        if (name != null ? !name.equals(chapterBO.name) : chapterBO.name != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "ChapterBO{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
