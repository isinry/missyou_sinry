package com.sinry.missyou;

import com.sinry.missyou.api.v1.BannerController;
import com.sinry.missyou.sample.EnableLOLAutoConfiguration;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;

import java.io.IOException;

//@ComponentScan
//@Import({HeroConfiguration.class, BannerController.class, DatabaseConfiguration.class})
@EnableLOLAutoConfiguration
public class LOLApplication {

    public static void main (String[] args) throws IOException {
        ConfigurableApplicationContext context = new SpringApplicationBuilder(LOLApplication.class).web(WebApplicationType.NONE).run(args);
//        ISkill iSkill = (ISkill) context.getBean("diana");
//        iSkill.e();

        BannerController banner = context.getBean(BannerController.class);
//        banner.getBanner();
    }
}
