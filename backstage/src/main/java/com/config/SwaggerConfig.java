package com.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;

/**
 * @author 李璟瑜
 * @date 2024/8/22 9:23
 * @description:
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig {
    @Bean
    public Docket docket() {
        // 创建一个Docket实例并指定文档类型为Swagger 2
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())     // 设置API的基本信息，如标题、描述等
                .select()               // 选择扫描哪些包
                .apis(RequestHandlerSelectors.basePackage("com.controller"))
                .paths(PathSelectors.any())     // 选择扫描哪些路径下的接口
                .build();                       // 构建 Docket
    }

    // 配置 Swagger 信息
    public ApiInfo apiInfo(){
        return new ApiInfo("ljy's接口文檔"    // 标签
                , "这是 接口文档"        // 描述
                , "v1.0"
                , "https://www.baidu.com"
                , new Contact("ljy", "https://github.com/Bai-Tu/cykj_session3_physical", "")    // 作者信息
                , "Apache 2.0"
                , "http://www.apache.org/licenses/LICENSE-2.0"
                , new ArrayList());
    }


}
