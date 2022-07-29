package com.xchaset.xtool.gen.er.infrastructure;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.HashMap;
import java.util.Map;

@AllArgsConstructor
@Getter
public enum ConstraintEmojiMappingEnum {
    PRI("\uD83D\uDD11"),
    UNI("\uD83D\uDD11"),
    MUL("\uD83D\uDD11"),
    DEFAULT("");

    private final String emoji;

    private static final Map<String,String> map = new HashMap<>();
    static {
        for (ConstraintEmojiMappingEnum value : ConstraintEmojiMappingEnum.values()) {
           map.put(value.name(),value.getEmoji());
        }
    }


    public static String getEmojiByColumnKey(String columnKey){
      return map.getOrDefault(columnKey,ConstraintEmojiMappingEnum.DEFAULT.getEmoji());
    }
}
