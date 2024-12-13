package com.nk.config;

import org.springframework.boot.autoconfigure.web.servlet.WebMvcAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
public class MyMvcConfig extends WebMvcAutoConfiguration {
    @Bean
    public WebMvcConfigurerAdapter webMvcConfigurerAdapter() {
        WebMvcConfigurerAdapter adapter = new WebMvcConfigurerAdapter() {
            @Override
            public void addViewControllers(ViewControllerRegistry registry) {
            super.addViewControllers(registry);

            registry.addViewController("/dashboard").setViewName("/dashboard");
            registry.addViewController("/index").setViewName("/asserts/index.html");
            registry.addViewController("/login").setViewName("/asserts/login.html");//cant work
            registry.addViewController("/register").setViewName("/asserts/register.html");//cant work

            registry.addViewController("/wyh_WorkProvinceCNCountShow").setViewName("wyh_WorkProvinceCNCountShow");
            registry.addViewController("/wyh_WorkProvinceCNCountShow2").setViewName("wyh_WorkProvinceCNCountShow2");
            registry.addViewController("/wyh_FfpTierCountShow").setViewName("wyh_FfpTierCountShow");
            registry.addViewController("/wyh_FfpDateYearCountShow").setViewName("wyh_FfpDateYearCountShow");
            registry.addViewController("/wyh_FiveCountShow").setViewName("wyh_FiveCountShow");

            registry.addViewController("/ycw_sex").setViewName("ycw_sex");
            registry.addViewController("/ycw_datanum").setViewName("ycw_datanum");
            registry.addViewController("/ycw_yearrelation").setViewName("ycw_yearrelation");
            registry.addViewController("/ycw_points").setViewName("ycw_points");
            registry.addViewController("/ycw_allavg").setViewName("ycw_allavg");

            registry.addViewController("/lz_age").setViewName("lz_age");
            registry.addViewController("/lz_avg_discount").setViewName("lz_avg_discount");
            registry.addViewController("/lz_region").setViewName("lz_region");
            registry.addViewController("/lz_work_province").setViewName("lz_work_province");
            registry.addViewController("/lz_year_change").setViewName("lz_year_change");

            registry.addViewController("/wyj_agecount").setViewName("wyj_agecount");
            registry.addViewController("/wyj_citymax10").setViewName("wyj_citymax10");
            registry.addViewController("/wyj_data1").setViewName("wyj_data1");
            registry.addViewController("/wyj_gender").setViewName("wyj_gender");
            registry.addViewController("/wyj_genderleida").setViewName("wyj_genderleida");

            registry.addViewController("/test").setViewName("test");
            }
        };
        return adapter;
    }
}
