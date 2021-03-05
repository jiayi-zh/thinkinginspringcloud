package com.bat.jyzh.common.entity.resp;

import lombok.Data;

import java.util.List;

/**
 * 分页数据
 *
 * @author ZhengYu
 * @version 1.0 2021/3/5 9:23
 **/
@Data
public class PageInfo<T> {

    private Long total;

    private List<T> list;

    public PageInfo() {
    }

    public PageInfo(Long total, List<T> list) {
        this.total = total;
        this.list = list;
    }
}