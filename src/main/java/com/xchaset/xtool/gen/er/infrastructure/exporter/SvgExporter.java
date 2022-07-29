package com.xchaset.xtool.gen.er.infrastructure.exporter;

import net.sourceforge.plantuml.FileFormat;
import net.sourceforge.plantuml.FileFormatOption;
import net.sourceforge.plantuml.FileUtils;
import net.sourceforge.plantuml.SourceStringReader;
import org.springframework.stereotype.Service;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
@Service("svgExporter")
public class SvgExporter implements Exporter{
    @Override
    public void export(String name, String pumlStr) {
        SourceStringReader reader = new SourceStringReader(pumlStr);
        try(final ByteArrayOutputStream os = new ByteArrayOutputStream()){
            String desc = reader.generateImage(os, new FileFormatOption(FileFormat.SVG));
            System.out.println(desc);
            FileUtils.copyToFile(os.toByteArray(),new File(name + ".svg"));
        }catch (IOException e) {
            e.printStackTrace();
        }
    }
}
