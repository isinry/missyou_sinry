package com.sinry.missyou.service;

import com.sinry.missyou.model.Banner;

public interface BannerService {

    Banner getByName (String name);

    boolean save (Banner banner);
}
