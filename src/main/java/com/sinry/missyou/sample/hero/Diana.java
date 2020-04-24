package com.sinry.missyou.sample.hero;

import com.sinry.missyou.sample.ISkill;

//@Component
public class Diana implements ISkill {
    @Override
    public void q() {
        System.out.println("Diana q");
    }

    @Override
    public void w() {
        System.out.println("Diana w");
    }

    @Override
    public void e() {
        System.out.println("Diana e");
    }

    @Override
    public void r() {
        System.out.println("Diana r");
    }
}
