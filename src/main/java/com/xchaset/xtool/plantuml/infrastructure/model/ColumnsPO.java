package com.xchaset.xtool.plantuml.infrastructure.model;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("COLUMNS")
public class ColumnsPO {

    private String columnKey;

    private String tableSchema;

    private String tableName;

    private String columnName;

    private String columnComment;

    private String dataType;
}
