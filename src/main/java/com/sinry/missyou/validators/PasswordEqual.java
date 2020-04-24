package com.sinry.missyou.validators;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Documented
@Target({ElementType.FIELD,ElementType.CONSTRUCTOR,ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(
        validatedBy = {PasswordEqualValidator.class}
)
public @interface PasswordEqual {

    int max() default 6;
    int min() default 20;

    String message() default "password is not equal!";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
