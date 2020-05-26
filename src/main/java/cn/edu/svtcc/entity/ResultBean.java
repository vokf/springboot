package cn.edu.svtcc.entity;

import org.springframework.lang.NonNull;
import org.springframework.stereotype.Component;

import java.io.Serializable;

/**
 * @author demo
 * @title ResultBean
 * @description
 * @date 2020/05/25/21:49
 */

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
    public Object getData() {
        return data;
    }

    public static int getSUCCESS() {
        return SUCCESS;
    }

    public static int getFAIL() {
        return FAIL;
    }

    public String getMessage() {
        return message;
    }

    public int getCode() {
        return code;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public static void setSUCCESS(int SUCCESS) {
        ResultBean.SUCCESS = SUCCESS;
    }

    public static void setFAIL(int FAIL) {
        ResultBean.FAIL = FAIL;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public ResultBean() {
        this.code = SUCCESS;
    }
    public static ResultBean success(@NonNull Object data) {
        ResultBean rb = new ResultBean(data);
        rb.setMessage("success");
        rb.setCode(SUCCESS);
        return rb;
    }


    public static ResultBean success() {
        ResultBean rb = new ResultBean();
        rb.setMessage("success");
        rb.setCode(SUCCESS);
        return rb;
    }

    public static ResultBean fail() {
        ResultBean rb = new ResultBean();
        rb.setMessage("fail");
        rb.setCode(FAIL);
        return rb;
    }
}

