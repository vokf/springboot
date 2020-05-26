package cn.edu.svtcc.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

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
public class Good implements Serializable {
    private static final long serialVersionUID = 1L;
    private Integer id;
    private String goodName;
    private Integer goodPrice;
    private String goodImage;
    private String hotGood;


}
