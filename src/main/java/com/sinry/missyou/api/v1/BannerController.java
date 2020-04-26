package com.sinry.missyou.api.v1;

import com.sinry.exception.BusinessException;
import com.sinry.missyou.dto.PersonDTO;
import com.sinry.missyou.model.Banner;
import com.sinry.missyou.service.BannerService;
import com.sinry.utils.BeansUtils;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.MDC;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotBlank;

@Validated
@RestController
@RequestMapping("/banner")
@Slf4j
public class BannerController {

    @Autowired
    private BannerService bannerService;

    @GetMapping("/name/{name}")
    public Banner getByName (@PathVariable @NotBlank String name) throws BusinessException {
        log.info("进入 == 》");
        PersonDTO dto = new PersonDTO();
        dto.setAge(20);
        dto.setName("sinry");
        log.info("test bean {}", BeansUtils.obj2map(dto));
        log.info("traceId {}", MDC.get("traceId"));
        Banner banner = bannerService.getByName(name);
        return banner;
    }

    @PostMapping("/name")
    public boolean save (@RequestBody Banner banner) {
        return bannerService.save(banner);
    }


}
