package com.xchaset.xtool.plantuml.domain.er;

import com.xchaset.xtool.plantuml.domain.repository.ColumnsRepository;
import com.xchaset.xtool.plantuml.domain.repository.TablesRepository;
import com.xchaset.xtool.plantuml.infrastructure.ConstraintEmojiMappingEnum;
import com.xchaset.xtool.plantuml.infrastructure.DataTypeEmojiMappingEnum;
import com.xchaset.xtool.plantuml.infrastructure.model.ColumnsPO;
import com.xchaset.xtool.plantuml.infrastructure.model.TablesPO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ERClassDiagramGenerator {

    @Autowired
    private TablesRepository tablesRepository;

    @Autowired
    private ColumnsRepository columnsRepository;

    public String gen(String tableSchema) {
        List<TablesPO> tablesPOS = tablesRepository.listTablesByTableSchema(tableSchema);
        StringBuilder sb = new StringBuilder();
        sb.append("@startuml");
        sb.append(System.lineSeparator());
        sb.append("!pragma layout smetana");
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
