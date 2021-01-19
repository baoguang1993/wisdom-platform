package com.libaoguang.cn.principlequery;

import java.util.HashMap;
import java.util.Map;

public class Constans {
    public static final Integer URGENT_PURCHASE_CONVENTIONAL=1;
    public static final Integer URGENT_PURCHASE_URGENT=2;
    public static final Integer URGENT_PURCHASE_EXPRESS=3;
    public static final Map<String, Integer> URGENT_PURCHASE_MAP = new HashMap();
    static {
        URGENT_PURCHASE_MAP.put("常规",URGENT_PURCHASE_CONVENTIONAL);
        URGENT_PURCHASE_MAP.put("紧急",URGENT_PURCHASE_URGENT);
        URGENT_PURCHASE_MAP.put("特急",URGENT_PURCHASE_EXPRESS);
    }
}
