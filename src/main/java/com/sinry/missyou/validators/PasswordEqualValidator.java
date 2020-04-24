package com.sinry.missyou.validators;

import com.sinry.missyou.dto.PersonDTO;
import com.sinry.missyou.validators.utils.MyValidatorUtil;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class PasswordEqualValidator implements ConstraintValidator<PasswordEqual, PersonDTO> {

    private int max;
    private int min;

    @Override
    public void initialize(PasswordEqual constraintAnnotation) {
        // init...
        this.max = constraintAnnotation.max();
        this.min = constraintAnnotation.min();
    }

    @Override
    public boolean isValid(PersonDTO personDTO, ConstraintValidatorContext context) {
        String password1 = personDTO.getPassword1();
        String password2 = personDTO.getPassword2();
        if (!MyValidatorUtil.isNotEmpty(password1) || !MyValidatorUtil.isNotEmpty(password2)) {
            return false;
        }
        if (!password1.equals(password2)) {
            return false;
        }
        return true;
    }

}
