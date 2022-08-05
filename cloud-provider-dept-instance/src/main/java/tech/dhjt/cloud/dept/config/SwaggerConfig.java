package tech.dhjt.cloud.dept.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.github.xiaoymin.knife4j.spring.extension.OpenApiExtensionResolver;
import com.google.common.base.Function;
import com.google.common.base.Optional;
import com.google.common.base.Predicate;

import springfox.documentation.RequestHandler;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
//@EnableSwagger2WebMvc
@EnableSwagger2
@Profile({ "dev", "test", "docker" }) // 设置 dev test 环境开启
public class SwaggerConfig {

    /*引入Knife4j提供的扩展类*/
    private final OpenApiExtensionResolver openApiExtensionResolver;

    @Autowired
    public SwaggerConfig(OpenApiExtensionResolver openApiExtensionResolver) {
        this.openApiExtensionResolver = openApiExtensionResolver;
    }

    /**
     * @description 创建一个Docket对象 调用select()方法， 生成ApiSelectorBuilder对象实例，该对象负责定义外漏的API入口
     * 通过使用RequestHandlerSelectors和PathSelectors来提供Predicate，在此我们使用any()方法，将所有API都通过Swagger进行文档管理
     * @return
     */
    @Bean
    public Docket createRestApi() {
        String groupName = "2.X版本";
        return new Docket(DocumentationType.SWAGGER_2).apiInfo(apiInfo())
                .groupName(groupName)
                .select()
//                .apis(RequestHandlerSelectors.basePackage("com.engine.controller")).paths(PathSelectors.any())
                .apis(basePackage(
                        "com.engine.healtheval.metric.controller;com.engine.healtheval.mock;com.engine.healtheval.core.controller"))
                .paths(PathSelectors.any()).build()
                //赋予插件体系
                .extensions(openApiExtensionResolver.buildExtensions(groupName));
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                // 标题
                .title("cloud")
                // 简介
                .description("微服务平台")
                // 服务条款
                .termsOfServiceUrl("no bugs!")
                // 作者个人信息
                .contact(new Contact("DHJT", "", "dhjt11@qq.com"))
                // 版本
//                .version("版本号: " + engineProperties.getApp().getVersion() + "-" + engineProperties.getApp().getBuildTime())
                .version("版本号: 1.0")
                .license("©DHJT").build();
    }

    public static Predicate<RequestHandler> basePackage(final String basePackage) {
        return input -> declaringClass(input).transform(handlerPackage(basePackage)).or(true);
    }

    private static Function<Class<?>, Boolean> handlerPackage(final String basePackage) {
        return input -> {
            // 循环判断匹配
            for (String strPackage : basePackage.split(";")) {
                boolean isMatch = input.getPackage().getName().startsWith(strPackage);
                if (isMatch) {
                    return true;
                }
            }
            return false;
        };
    }

    private static Optional<? extends Class<?>> declaringClass(RequestHandler input) {
        return Optional.fromNullable(input.declaringClass());
    }

}
