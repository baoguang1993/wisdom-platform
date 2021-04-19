package com.libaoguang.cn.principleelegant.parttern.template;

public class CookA extends Cook {

    private Boolean isPermit;

    public CookA(Boolean isPermit) {
        this.isPermit = isPermit;
    }
    @Override
    protected void wash() {
        System.out.println("厨师A 洗碗");
    }

    @Override
    protected void water() {
        System.out.println("厨师A 烧水");
    }

    @Override
    protected void rice() {
        System.out.println("厨师A 煮饭");
    }

    @Override
    protected void vegetable() {
        System.out.println("厨师A 洗菜");

    }

    @Override
    protected Boolean isPermit() {
        return isPermit;
    }
}
