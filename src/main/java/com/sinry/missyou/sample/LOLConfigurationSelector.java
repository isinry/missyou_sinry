package com.sinry.missyou.sample;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.type.AnnotationMetadata;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

@Slf4j
public class LOLConfigurationSelector implements ImportSelector {

    public static final String FACTORIES_RESOURCE = "lol-spring.factories";

    @Override
    public String[] selectImports(AnnotationMetadata annotationMetadata) {
        try {
            InputStream resource = ClassLoader.getSystemResourceAsStream(FACTORIES_RESOURCE);
            assert resource != null;
            int available = 0;
                available = resource.available();
            byte[] b = new byte[available];
            int read = resource.read(b);
            if (read <= 0) {
                throw new IOException("{} file not fount!");
            }
            String classesStr = new String(b);
            resource.close();

            String[] clazzArr = classesStr.split("\r\n");
//            clazzArr.removeIf(s -> s.contains("#"));
            List<String> newClazzArr = new ArrayList<>();
            for (String s : clazzArr) {
                if (!s.contains("#")) {
                    newClazzArr.add(s);
                }
            }
            if (newClazzArr.size() <= 0) {
                throw new IOException("{} file is empty!");
            }
            return newClazzArr.toArray(new String[0]);
        } catch (IOException e) {
            log.error(e.getMessage(), FACTORIES_RESOURCE);
            return null;
        }
    }
}
