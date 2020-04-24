package com.sinry.missyou.api.v1;

import com.sinry.missyou.model.Banner;
import com.sinry.missyou.service.BannerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotBlank;

@Validated
@RestController
@RequestMapping("/banner")
public class BannerController {

    @Autowired
    private BannerService bannerService;

    @GetMapping("/name/{name}")
    public Banner getByName (@PathVariable @NotBlank String name) {
        Banner banner = bannerService.getByName(name);
        return banner;
    }

    @PostMapping("/name")
    public boolean save (@RequestBody Banner banner) {
        return bannerService.save(banner);
    }


}
