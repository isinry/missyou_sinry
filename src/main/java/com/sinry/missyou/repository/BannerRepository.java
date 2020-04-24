package com.sinry.missyou.repository;

import com.sinry.missyou.model.Banner;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public interface BannerRepository extends JpaRepository<Banner, Long> {

    Banner findOneById(Long id);
    Banner findOneByName(String name);
}
