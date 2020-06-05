package cn.edu.svtcc.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;

import java.io.Serializable;

/**
 * @author demo
 * @title Good
 * @description
 * @date 2020/05/25/21:49
 */
@Getter
@Setter
@ToString
@NoArgsConstructor
@Slf4j
public class Good implements Serializable {
    /**
     * id
     */
    private Integer id;
    /**
     * goodName
     */
    private String goodName;
    /**
     * goodPrice
     */
    private Integer goodPrice;
    /**
     * goodImage
     */
    private String goodImage;
    /**
     * brand
     */
    private String brand;
    /**
     * hotGood
     */
    private String hotGood;

    private static final long serialVersionUID = 1L;
}
