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
    /**
     * 定义成功
     */
    private static int SUCCESS = 1;
    /**
     * 定义失败
     */
    private static int FAIL = 0;
    /**
     * 成功返回的 success
     */
    private String message = "success";
    /**
     * 返回的code
     */
    private int code;

    public ResultBean(Object data) {
        this.code = SUCCESS;
        this.data = data;
    }

    public ResultBean() {
        this.code = SUCCESS;
    }

    /**
     * 向前台返回成功
     * @return success
     */
    @NonNull
    public static ResultBean success() {
        ResultBean rb = new ResultBean();
        rb.setMessage("success");
        rb.setCode(SUCCESS);
        return rb;
    }

    /**
     * 向前台返回失败
     * @return fail
     */
    @NonNull
    public static ResultBean fail() {
        ResultBean rb = new ResultBean();
        rb.setMessage("fail");
        rb.setCode(FAIL);

        return rb;
    }
}

