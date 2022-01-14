package com.borisovskaya.reservation.model;

import java.util.List;

public class HotelLongResp {
    private Integer page;
    private Integer pageSize;
    private Integer totalElements;
    private List<Hotels> items;

    public HotelLongResp(Integer page, Integer pageSize, Integer totalElements, List<Hotels> items) {
        this.page = page;
        this.pageSize = pageSize;
        this.totalElements = totalElements;
        this.items = items;
    }

    public Integer getPage() {
        return page;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public Integer getTotalElements() {
        return totalElements;
    }

    public List<Hotels> getItems() {
        return items;
    }

    @Override
    public String toString() {
        return "HotelLongResp{" +
                "page=" + page +
                ", pageSize=" + pageSize +
                ", totalElements=" + totalElements +
                ", items=" + items +
                '}';
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public void setTotalElements(Integer totalElements) {
        this.totalElements = totalElements;
    }

    public void setItems(List<Hotels> items) {
        this.items = items;
    }
}
