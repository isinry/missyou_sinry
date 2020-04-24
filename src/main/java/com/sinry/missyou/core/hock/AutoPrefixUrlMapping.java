package com.sinry.missyou.core.hock;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.servlet.mvc.method.RequestMappingInfo;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;

import java.lang.reflect.Method;

public class AutoPrefixUrlMapping extends RequestMappingHandlerMapping{

    @Value("${sinry.api-package}")
    private String apiPackagePath;

    @Override
    protected RequestMappingInfo getMappingForMethod(Method method, Class<?> handlerType) {
        RequestMappingInfo mappingForMethod = super.getMappingForMethod(method, handlerType);
        if (mappingForMethod != null) {
            String prefix = this.getPrefix(handlerType);

            return RequestMappingInfo.paths(prefix)  // 重新定义包前缀
                    .build()    // 生成新的mappingInfo
                    .combine(mappingForMethod); // 合并原有的mappingInfo

        }
        return mappingForMethod;
    }

    // 获取api前缀  “/v1”
    private String getPrefix (Class<?> handlerType) {
        String name = handlerType.getPackage().getName();
        return name.replaceAll(this.apiPackagePath, "").replace(".", "/");
    }
}
