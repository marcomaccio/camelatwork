package com.camelatwork.common.bookstore.model.bo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: marcomaccio
 * Date: 01/11/2012
 * Time: 15:48
 * To change this template use File | Settings | File Templates.
 */
public class BookBO implements Serializable
{
    private static final long serialVersionUID = 1L;

    private Long    id;
    private String  title;
    private Long    firstPublishingYear;
    private transient List<ChapterBO> chapterBOArrayList = new ArrayList<ChapterBO>();

    /**
     *
     */
    public BookBO() {

    }

    /**
     *
     * @param id
     * @param title
     * @param firstPublishingYear
     */
    public BookBO(Long id, String title, Long firstPublishingYear) {
        this.id = id;
        this.title = title;
        this.firstPublishingYear = firstPublishingYear;
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
    public String getTitle() {
        return title;
    }

    /**
     *
     * @param title
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     *
     * @return
     */
    public Long getFirstPublishingYear() {
        return firstPublishingYear;
    }

    /**
     *
     * @param firstPublishingYear
     */
    public void setFirstPublishingYear(Long firstPublishingYear) {
        this.firstPublishingYear = firstPublishingYear;
    }

    /**
     *
     * @return
     */
    public List<ChapterBO> getChapterBOArrayList() {
        return chapterBOArrayList;
    }

    /**
     *
     * @param chapterBOArrayList
     */
    public void setChapterBOArrayList(List<ChapterBO> chapterBOArrayList) {
        this.chapterBOArrayList = chapterBOArrayList;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o){
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        BookBO bookBO = (BookBO) o;

        if (firstPublishingYear != null ? !firstPublishingYear.equals(bookBO.firstPublishingYear) : bookBO.firstPublishingYear != null){
            return false;
        }
        if (id != null ? !id.equals(bookBO.id) : bookBO.id != null){
            return false;
        }
        if (title != null ? !title.equals(bookBO.title) : bookBO.title != null){
            return false;
        }

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (title != null ? title.hashCode() : 0);
        result = 31 * result + (firstPublishingYear != null ? firstPublishingYear.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "BookBO{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", firstPublishingYear=" + firstPublishingYear +
                '}';
    }
}
