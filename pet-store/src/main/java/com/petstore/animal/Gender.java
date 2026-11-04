package com.petstore.animal;

/**
 * 动物性别枚举（统一使用 雄 / 雌）。
 *
 * @author pet-store
 */
public enum Gender {

    /** 雄性 */
    MALE("雄"),

    //该行等价于public static final Gender MALE = new Gender("雄");
    //enum的本质是类

    /** 雌性 */
    FEMALE("雌");

    private final String displayName;

    Gender(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return displayName;
    }

    //没有set方法，只能为雄雌不可更改为其他

    @Override
    public String toString() {
        return displayName;
    }
}
