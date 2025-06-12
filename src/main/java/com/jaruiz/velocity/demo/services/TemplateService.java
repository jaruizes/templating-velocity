package com.jaruiz.velocity.demo.services;

import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.VelocityEngine;
import org.apache.velocity.Template;
import org.springframework.stereotype.Service;

import java.io.StringWriter;
import java.util.Map;
import java.util.Properties;

@Service
public class TemplateService {

    private final VelocityEngine velocityEngine;

    public TemplateService() {
        Properties props = new Properties();
        props.setProperty("resource.loader", "class");
        props.setProperty("class.resource.loader.class", "org.apache.velocity.runtime.resource.loader.ClasspathResourceLoader");

        velocityEngine = new VelocityEngine(props);
        velocityEngine.init();
    }

    public String renderTemplate(String templatePath, Map<String, Object> data) {
        Template template = velocityEngine.getTemplate(templatePath);
        VelocityContext context = new VelocityContext();

        for (Map.Entry<String, Object> entry : data.entrySet()) {
            context.put(entry.getKey(), entry.getValue());
        }

        StringWriter writer = new StringWriter();
        template.merge(context, writer);
        return writer.toString();
    }
}
