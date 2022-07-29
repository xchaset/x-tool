package com.xchaset.xtool.gen.er.infrastructure.exporter;

import net.sourceforge.plantuml.SourceStringReader;
import org.springframework.stereotype.Service;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

@Service("pngExporter")
public class PngExporter implements Exporter{

    @Override
    public void export(String name,String pumlStr) {
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(name + ".png");
            SourceStringReader sourceStringReader = new SourceStringReader(pumlStr);
            String desc = sourceStringReader.generateImage(fileOutputStream);
            System.out.println(desc);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
