package com.etc.ticket.dto;

import com.etc.ticket.entity.Price;
import com.etc.ticket.entity.Type;

import java.util.List;

public class MySessionDto {
    private Integer session_id;
    private Type session_type;
    private String session_logo;
    private String session_name;
    private String session_content;
    private String session_time;
    private String session_address;
    private Integer session_nums;
    private String session_status;
    private List<Price> session_prices;
    private Double maxprice=0D;
    private Double minprice=0D;

    public Integer getSession_id() {
        return session_id;
    }

    public void setSession_id(Integer session_id) {
        this.session_id = session_id;
    }

    public Type getSession_type() {
        return session_type;
    }

    public void setSession_type(Type session_type) {
        this.session_type = session_type;
    }

    public String getSession_logo() {
        return session_logo;
    }

    public void setSession_logo(String session_logo) {
        this.session_logo = session_logo;
    }

    public String getSession_name() {
        return session_name;
    }

    public void setSession_name(String session_name) {
        this.session_name = session_name;
    }

    public String getSession_content() {
        return session_content;
    }

    public void setSession_content(String session_content) {
        this.session_content = session_content;
    }

    public String getSession_time() {
        return session_time;
    }

    public void setSession_time(String session_time) {
        this.session_time = session_time;
    }

    public String getSession_address() {
        return session_address;
    }

    public void setSession_address(String session_address) {
        this.session_address = session_address;
    }

    public Integer getSession_nums() {
        return session_nums;
    }

    public void setSession_nums(Integer session_nums) {
        this.session_nums = session_nums;
    }

    public String getSession_status() {
        return session_status;
    }

    public void setSession_status(String session_status) {
        this.session_status = session_status;
    }

    public List<Price> getSession_prices() {
        return session_prices;
    }

    public void setSession_prices(List<Price> session_prices) {
        this.session_prices = session_prices;
    }

    public Double getMaxprice() {
        return maxprice;
    }

    public void setMaxprice(Double maxprice) {
        this.maxprice = maxprice;
    }

    public Double getMinprice() {
        return minprice;
    }

    public void setMinprice(Double minprice) {
        this.minprice = minprice;
    }
}
