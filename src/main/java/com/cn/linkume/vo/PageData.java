package com.cn.linkume.vo;

import java.util.List;

public class PageData<T> implements java.io.Serializable {
    private static final long serialVersionUID = -3494784567913059002L;
    private Integer pageSize = 1; // 每页大小
    private Integer totalCount = 0; // 总记录数
    private Integer pageNo = 1; // 当前页码
    private Boolean hasNext = false;
    private Integer totalPage = 1;// 总页数
    private List<T> pageList;

    public PageData() {

    }

    public PageData(Integer pageNo, Integer pageSize) {
        this.pageNo = pageNo;
        this.pageSize = pageSize;
    }

    /**
     * Creates a new instance of PageData.
     * 
     * @param pageSize
     * @param totalCount
     * @param pageNo 从1开始；如果pageNo从0开始，入参请自行调整
     * @param pageList
     */
    public PageData(Integer pageNo, Integer pageSize, Integer totalCount, List<T> pageList) {
        this.pageSize = pageSize;
        this.totalCount = totalCount;
        this.pageNo = pageNo;
        this.pageList = pageList;
        this.totalPage = (totalCount % pageSize) == 0 ? (totalCount / pageSize) : ((totalCount / pageSize) + 1);
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public Integer getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(Integer totalCount) {
        this.totalCount = totalCount;
    }

    public Integer getPageNo() {
        return pageNo;
    }

    public void setPageNo(Integer pageNo) {
        this.pageNo = pageNo;
    }

    public Boolean getHasNext() {
        this.hasNext = this.pageNo.compareTo(this.totalPage) < 0 ? true : false;
        return hasNext;
    }

    public void setHasNext(Boolean hasNext) {
        this.hasNext = hasNext;
    }

    public Integer getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(Integer totalPageCount) {
        this.totalPage = totalPageCount;
    }

    public List<T> getPageList() {
        return pageList;
    }

    public void setPageList(List<T> pageList) {
        this.pageList = pageList;
    }

}
