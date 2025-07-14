package com.neaterp.server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SuppressWarnings("SpringComponentScan") // 忽略 IDEA 无法识别 ${neaterp.info.base-package}
@SpringBootApplication(scanBasePackages = {"${neaterp.info.base-package}.server", "${neaterp.info.base-package}.module"})
public class NeaterpServerApplication {

    public static void main(String[] args) {

        SpringApplication.run(NeaterpServerApplication.class, args);
    }


}
