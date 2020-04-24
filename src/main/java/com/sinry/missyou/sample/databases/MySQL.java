package com.sinry.missyou.sample.databases;

import com.sinry.missyou.sample.IConnect;

public class MySQL implements IConnect {
    private String ip;
    private Integer port;

    public MySQL(String ip, Integer port) {
        this.ip = ip;
        this.port = port;
    }

    @Override
    public void connect () {
        System.out.println("mysql连接，ip：" + ip + ":" + port);
    }
}
