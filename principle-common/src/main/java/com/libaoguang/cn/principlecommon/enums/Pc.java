package com.libaoguang.cn.principlecommon.enums;

public enum Pc {

    UPDATE(0, "更新"),
    QUERY(1, "查询"),
    DELETE(2, "删除");
    private Integer enumValue;
    private String enumDesc;

    private Pc(Integer enumValue, String enumDesc) {
        this.enumValue = enumValue;
        this.enumDesc = enumDesc;
    }

    public int getEnumValue() {
        return this.enumValue;
    }

    public String getEnumDesc() {
        return this.enumDesc;
    }

    public static Pc getPc(Integer key) {
        Pc result = null;
        Pc[] values = Pc.values();
        for (Pc pc : values) {
            if (key.equals(pc.enumValue)) {
                result = pc;
            }
        }
        return result;
    }

}
