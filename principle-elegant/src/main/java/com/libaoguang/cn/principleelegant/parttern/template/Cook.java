package com.libaoguang.cn.principleelegant.parttern.template;

/**
 * 模板模式
 * cook 基本方法
 * 其中基本方法一般会用final修饰，保证其不会被子类修改，
 * water,rice,vegetable 为模板方法
 * 模板方法则使用protected修饰，表明其需要在子类中实现
 */
public abstract class Cook {

    private Boolean isPermit;

    protected abstract void water();

    protected abstract void rice();

    protected abstract void vegetable();

    protected abstract void wash();

    public final void cook() {
        water();

        vegetable();

        rice();
        if(isPermit()){
            wash();
        }
    }
    protected Boolean isPermit(){
        return isPermit;
    }
}
