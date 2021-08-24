package com.security.app.config;

import org.springframework.context.annotation.ClassPathScanningCandidateComponentProvider;
import org.springframework.core.type.filter.AnnotationTypeFilter;
import org.springframework.stereotype.Component;

import java.util.Objects;
import java.util.stream.Collectors;
import javax.ws.rs.Path;
import javax.ws.rs.ext.Provider;
import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.util.ClassUtils;

@Component
public class WebJerseyConfiguration extends ResourceConfig {

    public WebJerseyConfiguration() {
        var scanner = new ClassPathScanningCandidateComponentProvider(false);
        scanner.addIncludeFilter(new AnnotationTypeFilter(Provider.class));
        scanner.addIncludeFilter(new AnnotationTypeFilter(Path.class));
        registerClasses(scanner.findCandidateComponents("com.security.adapter.input.controller").stream()
                .map(beanDefinition -> ClassUtils.resolveClassName(Objects.requireNonNull(beanDefinition.getBeanClassName()), getClassLoader()))
                .collect(Collectors.toSet()));
    }

}

