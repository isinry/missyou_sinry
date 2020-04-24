package com.sinry.missyou.sample;

import org.springframework.context.annotation.Import;

import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@Documented
@Import(LOLConfigurationSelector.class)
public @interface EnableLOLAutoConfiguration {
}
