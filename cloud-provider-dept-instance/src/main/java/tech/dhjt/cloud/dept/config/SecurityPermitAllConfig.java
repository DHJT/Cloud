package tech.dhjt.cloud.dept.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@EnableWebSecurity
public class SecurityPermitAllConfig extends WebSecurityConfigurerAdapter {


    // 允许通过名单
    private String[] ALLOW_LIST = new String[] {

    };
    // 禁止名单
    private String[] BLOCK_LIST = new String[] {

    };

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication().passwordEncoder(new BCryptPasswordEncoder()).withUser("user")
                .password(new BCryptPasswordEncoder().encode("user")).roles("USER").and().withUser("admin")
                .password(new BCryptPasswordEncoder().encode("admin")).roles("USER", "ADMIN");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable().authorizeRequests().anyRequest().permitAll()
//              .authenticated()
                .and().httpBasic();
//        http.authorizeRequests().anyRequest().permitAll()
//            .and().csrf().disable();
    }

    @Override
    public void configure(WebSecurity web) throws Exception {
        super.configure(web);
        // 忽略静态资源
        web.ignoring().antMatchers("/static/**");
    }
}
