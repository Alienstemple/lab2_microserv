package com.borisovskaya.gateway.model;

import java.util.ArrayList;
import java.util.List;

public class ListReservResp {
    private List<ReservationResponseWithHotel> list;

    public ListReservResp() {
        this.list = new ArrayList<>();
    }

    public ListReservResp(List<ReservationResponseWithHotel> list) {
        this.list = list;
    }

    @Override
    public String toString() {
        return "ListReservResp{" +
                "list=" + list +
                '}';
    }

    public void setList(List<ReservationResponseWithHotel> list) {
        this.list = list;
    }

    public List<ReservationResponseWithHotel> getList() {
        return list;
    }
}
