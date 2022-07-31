package com.xchaset.xtool.plantuml.infrastructure.model;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("TABLES")
public class TablesPO {

    private String tableSchema;

    private String tableName;

    private String tableComment;
}
