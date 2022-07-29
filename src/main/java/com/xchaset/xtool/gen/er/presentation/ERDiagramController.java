package com.xchaset.xtool.gen.er.presentation;

import com.xchaset.xtool.gen.er.application.GeneratorApplication;
import com.xchaset.xtool.gen.er.infrastructure.model.ColumnsPO;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RequestMapping("/gen/er")
@RestController
public class ERDiagramController {
    @Resource
    private GeneratorApplication generatorApplication;

    @GetMapping("/{tableSchema}")
    public String gen(@PathVariable String tableSchema) {
        return generatorApplication.gen(tableSchema);
    }


    @GetMapping("/{tableSchema}/{fileFormatType}")
    public String genFile(@PathVariable String tableSchema,@PathVariable String fileFormatType) {
        return generatorApplication.genFile(tableSchema,fileFormatType);
    }

}
