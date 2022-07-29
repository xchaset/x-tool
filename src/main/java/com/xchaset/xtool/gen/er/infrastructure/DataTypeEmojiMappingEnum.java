package com.xchaset.xtool.gen.er.infrastructure;

import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.HashMap;
import java.util.Map;

@AllArgsConstructor
@Getter
public enum DataTypeEmojiMappingEnum {
    VARCHAR("\uD83D\uDD24"),
    TIMESTAMP("⏱"),
    BIGINT("\uD83D\uDD22"),
    INT("\uD83D\uDD22"),
    TEXT("\uD83D\uDCC3"),
    LONGTEXT("\uD83D\uDCC3"),
    MEDIUMTEXT("\uD83D\uDD24"),
    ENUM("\uD83D\uDD22"),
    JSON("\uD83D\uDD22"),
    DATETIME("⏱"),
    BINARY("\uD83D\uDD22"),
    VARBINARY("\uD83D\uDD22"),
    TINYINT("\uD83D\uDD22"),
    BLOB("\uD83D\uDCBD"),
    DECIMAL("\uD83D\uDD22"),
    DOUBLE("0️⃣"),
    LONGBLOB("\uD83D\uDCBD"),
    SMALLINT("\uD83D\uDD22"),
    MEDIUMBLOB("\uD83D\uDD22"),
    TIME("⏱"),
    FLOAT("0️⃣"),
    TINYTEXT("\uD83D\uDD24"),
    DATE("⏱"),
    BIT("\uD83D\uDD22"),
    ;
    private final String emoji;

    private static final Map<String, String> dataTypeEmojiMap = new HashMap<>();

    static {
        for (DataTypeEmojiMappingEnum value : DataTypeEmojiMappingEnum.values()) {
            dataTypeEmojiMap.put(value.name(), value.getEmoji());
        }
    }

    public static String getEmojiByDataType(String dataType) {
        String data = dataType.toUpperCase();
        return dataTypeEmojiMap.getOrDefault(data, StringUtils.EMPTY);
    }
}
