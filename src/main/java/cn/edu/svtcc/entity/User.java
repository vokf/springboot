package cn.edu.svtcc.entity;


import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.io.Serializable;

/**
 * @author demo
 * @title User
 * @description
 * @date 2020/05/25/21:37
 */
@Component
@EqualsAndHashCode(exclude = {"passWord", "phoneNumber", "userName"})
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Slf4j
public class User implements Serializable {
    private Integer userId;
    private String userName;
    private String passWord;
    private String phoneNumber;

    private static final long serialVersionUID = 1L;

}