package com.sinry.missyou.sample.configuration;

import com.sinry.missyou.sample.ISkill;
import com.sinry.missyou.sample.hero.Diana;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class HeroConfiguration {
//    @Bean
//    public ISkill camille () {
//        return new Camille();
//    }

    @Bean
//    @ConditionalOnProperty(name = "hero.conditional", havingValue = "diana")
//    @Conditional(DianaCondition.class)
    public ISkill diana () {
        return new Diana();
    }

//    @Bean
////    @ConditionalOnProperty(name = "hero.conditional", havingValue = "irelia", matchIfMissing = true)
////    @Conditional(IreliaCondition.class)
//    public ISkill irelia () {
//        return new Irelia();
//    }

}
