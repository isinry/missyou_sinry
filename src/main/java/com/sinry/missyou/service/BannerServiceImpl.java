package com.sinry.missyou.service;

import com.sinry.missyou.model.Banner;
import com.sinry.missyou.repository.BannerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BannerServiceImpl implements BannerService{

    @Autowired
    private BannerRepository bannerRepository;

    @Override
    public Banner getByName(String name) {
       return bannerRepository.findOneByName(name);
    }

    @Override
    public boolean save (Banner banner) {
        Banner save = bannerRepository.save(banner);
        return true;
    }
}
