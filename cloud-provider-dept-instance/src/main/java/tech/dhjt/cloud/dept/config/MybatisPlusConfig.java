package tech.dhjt.cloud.dept.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.baomidou.mybatisplus.core.injector.DefaultSqlInjector;
import com.baomidou.mybatisplus.core.injector.ISqlInjector;
import com.baomidou.mybatisplus.extension.plugins.OptimisticLockerInterceptor;
import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;

/**
 * @description mybatis配置类
 * @author DHJT 2020-09-04 10:45:45
 */
@EnableTransactionManagement
@Configuration
@MapperScan({ "tech.dhjt.cloud.dept.mapper" })
public class MybatisPlusConfig {

    /**
     * 乐观锁 插件
     * @return
     */
    @Bean
    public OptimisticLockerInterceptor optimisticLockerInterceptor() {
        return new OptimisticLockerInterceptor();
    }

    @Bean
    public PaginationInterceptor paginationInterceptor() {
        PaginationInterceptor paginationInterceptor = new PaginationInterceptor();
        // 设置请求的页面大于最大页后操作， true调回到首页，false 继续请求  默认false
        // paginationInterceptor.setOverflow(false);
        // 设置最大单页限制数量，默认 500 条，-1 不受限制
        paginationInterceptor.setLimit(100_000);
        return paginationInterceptor;
    }

    @Bean
    public ISqlInjector sqlInjector() {
        return new DefaultSqlInjector();
    }

    /**
     * SQL执行效率插件
     */
//    @Bean
//    @Profile({ "dev", "test" })
//    @Profile({ "test" })
//    public PerformanceInterceptor performanceInterceptor() {
//        PerformanceInterceptor p = new PerformanceInterceptor();
//        p.setMaxTime(50000);
//        p.setFormat(true);
//        return p;
//    }
}
