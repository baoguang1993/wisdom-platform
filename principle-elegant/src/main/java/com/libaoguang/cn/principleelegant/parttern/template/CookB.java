package com.libaoguang.cn.principleelegant.parttern.template;

import lombok.Data;

@Data
public class CookB extends Cook {

    private Boolean isPermit;

    public CookB(Boolean isPermit) {
        this.isPermit = isPermit;
    }

    @Override
    protected Boolean isPermit() {
        return isPermit;
    }

    @Override
    protected void water() {

        System.out.println("厨师B 烧水");
    }

    @Override
    protected void rice() {

        System.out.println("厨师B 煮饭");
    }

    @Override
    protected void vegetable() {
        System.out.println("厨师B 洗菜");
    }

    @Override
    protected void wash() {
        System.out.println("厨师B 洗碗");
    }


}
