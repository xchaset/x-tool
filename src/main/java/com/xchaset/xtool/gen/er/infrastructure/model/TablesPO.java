package com.xchaset.xtool.gen.er.infrastructure.model;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("TABLES")
public class TablesPO {

    private String tableSchema;

    private String tableName;

    private String tableComment;
}
