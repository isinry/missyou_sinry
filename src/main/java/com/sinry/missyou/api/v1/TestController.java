package com.sinry.missyou.api.v1;

import com.sinry.missyou.dto.PersonDTO;
import org.hibernate.validator.constraints.Range;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@RestController
@RequestMapping("/test")
@Validated
public class TestController {

    @PostMapping("/login/validator/{id}/{eid}")
    public void loginValidator(@RequestBody PersonDTO dto,
                               @NotNull @Range(max = 10, min = 1, message = "id必须在{min}到{max}之间") @PathVariable Long id,
                               @NotNull @Range(max = 10, min = 1, message = "eid必须在{min}到{max}之间") @PathVariable Long eid) {

    }

    @GetMapping("/login/validator/{id}")
    public void loginValidator(@Valid @Min(value = 0, message = "{id}不是数字") @PathVariable Long id) {

    }
}
