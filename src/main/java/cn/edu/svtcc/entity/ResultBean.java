package cn.edu.svtcc.entity;

import lombok.Getter;
import lombok.Setter;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Component;

import java.io.Serializable;

/**
 * @author demo
 * @title ResultBean
 * @description
 * @date 2020/05/25/21:49
 */
@Getter
@Setter
@Component
public class ResultBean implements Serializable {
    private Object data;
    private static int SUCCESS = 1;
    private static int FAIL = 0;
    private String message = "success";
    private int code;

    public ResultBean(Object data) {
        this.code = SUCCESS;
        this.data = data;
    }

    public ResultBean() {
        this.code = SUCCESS;
    }

    @NonNull
    public static ResultBean success() {
        ResultBean rb = new ResultBean();
        rb.setMessage("success");
        rb.setCode(SUCCESS);
        return rb;
    }

    @NonNull
    public static ResultBean fail() {
        ResultBean rb = new ResultBean();
        rb.setMessage("fail");
        rb.setCode(FAIL);
        return rb;
    }
}

