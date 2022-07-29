package com.xchaset.xtool.gen.er.domain.repository;

import com.xchaset.xtool.gen.er.infrastructure.mapper.TablesMapper;
import com.xchaset.xtool.gen.er.infrastructure.model.ColumnsPO;
import com.xchaset.xtool.gen.er.infrastructure.model.TablesPO;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@Service
public class TablesRepository {
    @Resource
    private TablesMapper tablesMapper;

    public List<TablesPO> listTablesByTableSchema(String tableSchema){
      return tablesMapper.selectByMap(Map.of("table_schema",tableSchema));
    }
}
