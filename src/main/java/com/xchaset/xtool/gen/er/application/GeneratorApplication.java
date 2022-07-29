package com.xchaset.xtool.gen.er.application;

import com.xchaset.xtool.gen.er.domain.repository.ColumnsRepository;
import com.xchaset.xtool.gen.er.domain.repository.TablesRepository;
import com.xchaset.xtool.gen.er.infrastructure.ConstraintEmojiMappingEnum;
import com.xchaset.xtool.gen.er.infrastructure.DataTypeEmojiMappingEnum;
import com.xchaset.xtool.gen.er.infrastructure.exporter.Exporter;
import com.xchaset.xtool.gen.er.infrastructure.model.ColumnsPO;
import com.xchaset.xtool.gen.er.infrastructure.model.TablesPO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@Service
public class GeneratorApplication {

    @Resource
    private ColumnsRepository columnsRepository;

    @Resource
    private TablesRepository tablesRepository;

    @Autowired
    private Map<String, Exporter> exporterMap;

    public String genFile(String tableSchema,String formatFileType){
        String pumlStr = gen(tableSchema);
        Exporter exporter = exporterMap.get(formatFileType + "Exporter");
        if (exporter == null) {
            throw new RuntimeException("not found exporter");
        }
        exporter.export(tableSchema,pumlStr);
        return pumlStr;
    }

    public String gen(String tableSchema) {
        List<TablesPO> tablesPOS = tablesRepository.listTablesByTableSchema(tableSchema);
        StringBuilder sb = new StringBuilder();
        sb.append("@startuml");
        sb.append(System.lineSeparator());
        for (TablesPO table : tablesPOS) {
            String tableName = table.getTableName();
            String tableComment = table.getTableComment();
            sb.append("class ");
            sb.append(tableName);
            sb.append(" <<(T,green) ");
            sb.append(tableComment);
            sb.append(" >> {");
            sb.append(System.lineSeparator());
            List<ColumnsPO> columnsPOS = columnsRepository.listColumnsByTableSchemaAndTableName(tableSchema, tableName);
            for (ColumnsPO col : columnsPOS) {
                sb.append(DataTypeEmojiMappingEnum.getEmojiByDataType(col.getDataType()));
                sb.append(" ");
                sb.append(ConstraintEmojiMappingEnum.getEmojiByColumnKey(col.getColumnKey()));
                sb.append(" ");
                sb.append(col.getColumnName());
                sb.append(" ");
                sb.append(col.getColumnComment());
                sb.append(System.lineSeparator());

            }
            sb.append("}");
            sb.append(System.lineSeparator());
            sb.append(System.lineSeparator());

        }
        sb.append("@enduml");
        return sb.toString();
    }
}
