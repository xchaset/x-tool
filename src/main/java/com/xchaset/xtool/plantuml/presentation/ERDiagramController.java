package com.xchaset.xtool.plantuml.presentation;

import com.xchaset.xtool.plantuml.application.GeneratorApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RequestMapping("/gen/er")
@RestController
public class ERDiagramController {
    @Resource
    private GeneratorApplication generatorApplication;

    @GetMapping("/{tableSchema}/{fileFormatType}")
    public String genFile(@PathVariable String tableSchema,@PathVariable String fileFormatType) {
        return generatorApplication.genFile(tableSchema,fileFormatType);
    }

    @GetMapping("/seq/{name}/{fileFormatType}")
    public String genSeqFile(@PathVariable String name,@PathVariable String fileFormatType) {
        return generatorApplication.genSeqFile(name,fileFormatType);
    }

}
