package org.macbeth.netcrawler;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.io.IOException;


@SpringBootApplication
@EnableAutoConfiguration
public class Application{

    public static void main(String[] args) throws IOException {

        ConfigurableApplicationContext context = SpringApplication.run(Application.class);
        SiteChecker siteChecker = context.getBean(SiteChecker.class);
        siteChecker.CheckAllSites(args);
    }

}
