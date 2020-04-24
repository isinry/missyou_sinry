package com.sinry.missyou.dto;

import com.sinry.missyou.validators.PasswordEqual;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;

@Getter
@Setter
@PasswordEqual
public class PersonDTO {
    @NotNull
    private String name;
    private Integer age;

//    @Delegate
//    private List<String> address = new ArrayList<>();

    private String password1;
    private String password2;
}
