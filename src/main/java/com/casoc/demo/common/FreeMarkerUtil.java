package com.casoc.demo.common;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import org.apache.commons.lang3.text.StrBuilder;

import java.io.IOException;
import java.io.Writer;
import java.util.Map;

public class FreeMarkerUtil {

    private static Configuration configuration;

    static {
        configuration = new Configuration();
        configuration.setClassForTemplateLoading(FreeMarkerUtil.class, "/template");
        configuration.setDefaultEncoding("UTF-8");
    }

    public static Template getTemplate(String path) throws IOException {
        return configuration.getTemplate(path);
    }

    public static String getHtml(Template template, Map root) throws IOException, TemplateException {
        StrBuilder strBuilder = new StrBuilder();
        Writer writer = strBuilder.asWriter();
        template.process(root, writer);
        return strBuilder.toString();
    }

}
