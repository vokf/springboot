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
@EqualsAndHashCode(exclude = {"passWord", "phoneNumber", "userName", "email", "role", "address"})
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Slf4j

public class User implements Serializable {
    /**
     * userId
     */
    private Integer userId;
    /**
     * userName
     */
    private String userName;
    /**
     * passWord
     */
    private String passWord;
    /**
     * phoneNumber
     */
    private String phoneNumber;
    /**
     * age
     */
    private Integer age;
    /**
     * email
     */
    private String email;
    /**
     * address
     */
    private String address;
    /**
     * role
     */
    private String role;

    private static final long serialVersionUID = 1L;

}