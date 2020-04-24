package com.sinry.missyou.model;

import javax.persistence.*;

@Entity
@Table(name = "banner_item")
public class BannerItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String img;
    private String keyword;
    private Short type;
    private String name;

    private long bannerId;

    @ManyToOne
    @JoinColumn(name = "bannerId", insertable = false, updatable = false)
    private Banner banner;
}
