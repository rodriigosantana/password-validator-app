package com.security.app;

import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.context.AnnotationConfigServletWebServerApplicationContext;
import org.springframework.context.ApplicationContext;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ClassPathBeanDefinitionScanner;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.core.type.classreading.MetadataReader;
import org.springframework.core.type.classreading.MetadataReaderFactory;
import org.springframework.core.type.filter.TypeFilter;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;

@SpringBootApplication
public class SpringSampleApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringSampleApplication.class, args);
    }

    @Bean
    BeanFactoryPostProcessor beanFactoryPostProcessor(ApplicationContext beanRegistry){
        return beanFactory -> {
            genericApplicationContext((BeanDefinitionRegistry) ((AnnotationConfigServletWebServerApplicationContext) beanRegistry).getBeanFactory());
        };
    }

    void genericApplicationContext(BeanDefinitionRegistry beanRegistry){
        ClassPathBeanDefinitionScanner beanDefinitionScanner = new ClassPathBeanDefinitionScanner(beanRegistry);
        beanDefinitionScanner.addIncludeFilter(removeModelAndEntitiesFilter());
        beanDefinitionScanner.scan("com.security");
    }

    static TypeFilter removeModelAndEntitiesFilter(){
        return (MetadataReader mr, MetadataReaderFactory mrf) -> !mr.getClassMetadata()
                .getClassName()
                .endsWith("Entity");
    }
}
