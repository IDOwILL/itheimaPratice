package com.itheima.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Objects;

/**
 * 分页对象
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PageBean {
    private Long total;
    private Object rows;
}
