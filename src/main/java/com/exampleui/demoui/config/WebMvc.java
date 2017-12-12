package com.exampleui.demoui.config;

import com.exampleui.demoui.interceptor.CartProducer;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ResourceBundleMessageSource;
//import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.web.accept.ContentNegotiationManager;
//import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.*;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;
import org.springframework.web.servlet.view.ContentNegotiatingViewResolver;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;
import org.springframework.web.servlet.view.json.MappingJackson2JsonView;
//import org.springframework.web.servlet.view.xml.MarshallingView;

import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.Locale;

@EnableWebMvc
@Configuration
@ComponentScan({"com"})
public class WebMvc extends WebMvcConfigurerAdapter {


    // Шаблон создания пути для ответа
    @Bean
    public InternalResourceViewResolver getInternalResourceViewResolver() {
        InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
        viewResolver.setViewClass(JstlView.class);
        viewResolver.setPrefix("/WEB-INF/views/");
        viewResolver.setSuffix(".jsp");
        return viewResolver;
    }

    // Управление относительными ссылками для доступа к ресурсам
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/img/**").addResourceLocations("/WEB-INF/resources/img/");
        registry.addResourceHandler("/css/**").addResourceLocations("/WEB-INF/resources/css/");
        registry.addResourceHandler("/js/**").addResourceLocations("/WEB-INF/resources/js/");
    }

    // Выбор ресурса для интернационализации
    @Bean
    public MessageSource messageSource() {
        ResourceBundleMessageSource source = new ResourceBundleMessageSource();
        source.setBasename("language");
        return source;
    }

    // Загрузка файлов на сервер
    @Bean
    public CommonsMultipartResolver multipartResolver() {
        CommonsMultipartResolver resolver = new CommonsMultipartResolver();
        resolver.setDefaultEncoding("UTF-8");
        resolver.setMaxUploadSize(10240000);
        return resolver;
    }

    // Преобразование Java объектов в файл формата JSON
    @Bean
    public MappingJackson2JsonView jsonView() {
        MappingJackson2JsonView jsonView = new MappingJackson2JsonView();
        jsonView.setPrettyPrint(true);
        return jsonView;
    }

    /*@Bean
    public MarshallingView xmlView() {
        Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
        marshaller.setClassesToBeBound(Product.class);
        return new MarshallingView(marshaller);
    }*/

    // Выбор метода преобразования Java<->JSON
    @Bean
    public ViewResolver contentNegotiatingViewResolver(ContentNegotiationManager manager) {
        ContentNegotiatingViewResolver resolver = new ContentNegotiatingViewResolver();
        resolver.setContentNegotiationManager(manager);
        ArrayList<View> views = new ArrayList<>();
        views.add(jsonView());
//        views.add(xmlView());
        resolver.setDefaultViews(views);
        return resolver;
    }

    // Локаль по умолчанию (формат даты, данных, валюты и т.п.)
    @Bean
    public LocaleResolver localeResolver(){
        SessionLocaleResolver resolver = new SessionLocaleResolver();
        resolver.setDefaultLocale(new Locale("en"));
        return resolver;
    }
    @Bean
    public HandlerInterceptor cartProducer() {
        return new CartProducer();
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(cartProducer()).addPathPatterns("/**");
    }

    // Включить конфигурацию приложения через Spring
    @Override
    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
        configurer.enable();
    }

}
