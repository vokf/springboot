package cn.edu.svtcc.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

/**
 * @author demo
 * @title PageDTD
 * @description
 * @date 2020/05/25/21:48
 */


@Getter
@Setter
@ToString
@NoArgsConstructor
public class PageDTD<T> implements Serializable {
    /**
     * 页面
     */
    private Integer page;
    /**
     * limit
     */
    private Integer limit;
    /**
     * condition 条件
     */
    private T condition;


}