package com.xchaset.xtool.plantuml.application;

import com.xchaset.xtool.plantuml.domain.er.ERClassDiagramGenerator;
import com.xchaset.xtool.plantuml.domain.repository.ColumnsRepository;
import com.xchaset.xtool.plantuml.domain.repository.TablesRepository;
import com.xchaset.xtool.plantuml.infrastructure.ConstraintEmojiMappingEnum;
import com.xchaset.xtool.plantuml.infrastructure.DataTypeEmojiMappingEnum;
import com.xchaset.xtool.plantuml.infrastructure.exporter.Exporter;
import com.xchaset.xtool.plantuml.infrastructure.model.ColumnsPO;
import com.xchaset.xtool.plantuml.infrastructure.model.TablesPO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@Service
public class GeneratorApplication {

    @Resource
    private ERClassDiagramGenerator erClassDiagramGenerator;

    @Autowired
    private Map<String, Exporter> exporterMap;

    public String genFile(String tableSchema, String formatFileType) {
        String pumlStr = erClassDiagramGenerator.gen(tableSchema);
        Exporter exporter = exporterMap.get(formatFileType + "Exporter");
        if (exporter == null) {
            throw new RuntimeException("not found exporter");
        }
        exporter.export(tableSchema, pumlStr);
        return pumlStr;
    }

    public String genSeqFile(String name, String formatFileType) {
        Exporter exporter = exporterMap.get(formatFileType + "Exporter");
        if (exporter == null) {
            throw new RuntimeException("not found exporter");
        }
        exporter.export(name, getUmlStr());
        return "ok";
    }

    private String getUmlStr() {
        StringBuilder sb = new StringBuilder();
        sb.append("@startuml");
        sb.append(System.lineSeparator());
        sb.append("Alice --> Bob");
        sb.append(System.lineSeparator());
        sb.append("Alice <-- Bob");
        sb.append(System.lineSeparator());
        sb.append("@enduml");
        return sb.toString();
    }


}
