package org.macbeth.netcrawler;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;


@SpringBootApplication
@EnableAutoConfiguration
public class Application{

    public static void main(String[] args) {

        ConfigurableApplicationContext context = SpringApplication.run(Application.class);
        SiteChecker siteChecker = context.getBean(SiteChecker.class);
        siteChecker.checkAllSites(args);
    }

}
