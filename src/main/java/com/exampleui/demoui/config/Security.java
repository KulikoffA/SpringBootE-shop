package com.exampleui.demoui.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

import javax.sql.DataSource;

@Configuration
@EnableWebSecurity
public class Security extends WebSecurityConfigurerAdapter {

    @Qualifier("dataSource")
    @Autowired
    DataSource dataSource;

    @Autowired
    public void configAuthentication(AuthenticationManagerBuilder amb) throws Exception {
        amb.jdbcAuthentication().dataSource(dataSource)
                .usersByUsernameQuery("select username, password, enabled from users where username=?")
                .authoritiesByUsernameQuery("select username, role from user_roles where username=?");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.formLogin().loginPage("/login").usernameParameter("username").passwordParameter("password")
                .defaultSuccessUrl("/eshop").failureUrl("/login?error").and()
                .logout().logoutSuccessUrl("/login?logout").and()
                .exceptionHandling().accessDeniedPage("/login?accessDenied").and()
                .authorizeRequests()
                    .antMatchers("/").permitAll()
                    .antMatchers("/**/manager/**").hasRole("ADMIN").and()
                .csrf().disable();
    }
}
