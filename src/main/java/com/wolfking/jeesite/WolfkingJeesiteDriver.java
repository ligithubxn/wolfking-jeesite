package com.wolfking.jeesite;

import com.wolfking.jeesite.modules.sys.service.SystemService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.ComponentScan;

/**
 * wolfking-jeesite
 * springboot的启动类
 * Created by wolfking(赵伟伟)
 * Created on 2017/1/8 16:20
 * Mail zww199009@163.com
 */
@EnableCaching
@SpringBootApplication
@ServletComponentScan("com.wolfking.jeesite")
@ComponentScan(value = "com.wolfking.jeesite",lazyInit = true)
public class WolfkingJeesiteDriver {
    private static Logger logger = LoggerFactory.getLogger(WolfkingJeesiteDriver.class);

    public static void main(String[] args) {
        String applicationPath = System.getProperty("spring.config.location") == null ? "application.yml" : System.getProperty("spring.config.location");
        logger.info("默认文件为 application.yml , application Path : " + applicationPath);
        new SpringApplicationBuilder(WolfkingJeesiteDriver.class).web(true).run(args);
        SystemService.printKeyLoadMessage();
    }
}
