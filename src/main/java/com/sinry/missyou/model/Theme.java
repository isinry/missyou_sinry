package com.sinry.missyou.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Theme {
    @Id
    private long id;
    private String title;
}
