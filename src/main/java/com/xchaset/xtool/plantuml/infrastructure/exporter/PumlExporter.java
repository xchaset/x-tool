package com.xchaset.xtool.plantuml.infrastructure.exporter;

import net.sourceforge.plantuml.FileUtils;
import net.sourceforge.plantuml.security.SFile;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
@Service
public class PumlExporter implements Exporter{
    @Override
    public void export(String name, String pumlStr) {
        try {
            FileUtils.copyToFile(pumlStr.getBytes(StandardCharsets.UTF_8),new SFile(name + ".puml"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
