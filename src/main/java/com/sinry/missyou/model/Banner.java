package com.sinry.missyou.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "banner")
public class Banner {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(length = 16)
    private String name;

    @Transient
    private String description;
    private String img;
    private String title;

    @OneToMany(mappedBy = "banner", fetch = FetchType.EAGER)
    private List<BannerItem> items;

}
