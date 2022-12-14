package com.xchaset.xtool.plantuml.domain.repository;

import com.xchaset.xtool.plantuml.infrastructure.mapper.ColumnsMapper;
import com.xchaset.xtool.plantuml.infrastructure.model.ColumnsPO;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@Service
public class ColumnsRepository {
    @Resource
    private ColumnsMapper columnsMapper;

    public List<ColumnsPO> listColumnsByTableSchemaAndTableName(String tableSchema,String tableName){
      return columnsMapper.selectByMap(Map.of("table_schema",tableSchema,"table_name",tableName));
    }
}
