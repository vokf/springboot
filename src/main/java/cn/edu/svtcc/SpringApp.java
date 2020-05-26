package cn.edu.svtcc;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.CrossOrigin;

/**
 * @author demo
 * @title SpringBootApplication
 * @description
 * @date 2020/05/25/21:42
 */
@Transactional(rollbackFor = Exception.class)
@SpringBootApplication
@MapperScan("cn.edu.svtcc.mapper")
@CrossOrigin
public class SpringApp {
    public static void main(String[] args) {
        SpringApplication.run(SpringApp.class,args);
    }
}
