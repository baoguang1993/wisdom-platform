package com.libaoguang.cn.principleelegant.parttern.template;

public class Cooktest {
    public static void main(String[] args) {
        CookA cookA=new CookA(false);
        cookA.cook();

        CookB cookB=new CookB(true);
        cookB.cook();
    }
}
