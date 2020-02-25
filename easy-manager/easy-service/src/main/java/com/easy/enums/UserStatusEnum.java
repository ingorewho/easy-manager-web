package com.easy.enums;

/**
 * @Author rzq
 * @Desc 用户状态枚举
 * @Date 2020-02-20
 **/
public enum UserStatusEnum {
    NORMAL(0, "正常"),
    FROZEN(1, "冻结");

    private Integer code;
    private String desc;

    private UserStatusEnum(Integer code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public Integer getCode() {
        return code;
    }

    public String getDesc() {
        return desc;
    }
}
