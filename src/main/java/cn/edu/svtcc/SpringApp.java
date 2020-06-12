package cn.edu.svtcc;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.transaction.annotation.Transactional;

/**
 * 启动类
 * @author demo
 * @title SpringBootApplication
 * @description
 *
 * @date 2020/05/25/21:42
 */
@Transactional(rollbackFor = Exception.class)
@SpringBootApplication
@MapperScan(basePackages = "cn.edu.svtcc.mapper")

@ServletComponentScan
public class SpringApp {
    public static void main(String[] args) {
        SpringApplication.run(SpringApp.class,args);
    }
}
