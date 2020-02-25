package com.easy.infra.util.mybatis;

import com.easy.infra.util.mybatis.mapper.EasyJavaMapperGenerator;
import com.easy.infra.util.mybatis.mapper.EasyXmlMapperGenerator;
import org.mybatis.generator.api.GeneratedXmlFile;
import org.mybatis.generator.api.ProgressCallback;
import org.mybatis.generator.api.dom.xml.Document;
import org.mybatis.generator.codegen.AbstractJavaClientGenerator;
import org.mybatis.generator.codegen.mybatis3.IntrospectedTableMyBatis3Impl;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author rzq
 * @Desc
 * @Date 2020-02-16
 **/
public class EasyIntrospectedTableMyBatis3Impl extends IntrospectedTableMyBatis3Impl {

    public EasyIntrospectedTableMyBatis3Impl() {

    }
    @Override
    protected void calculateXmlMapperGenerator(AbstractJavaClientGenerator javaClientGenerator, List<String> warnings, ProgressCallback progressCallback) {
        this.xmlMapperGenerator = new EasyXmlMapperGenerator();
        this.initializeAbstractGenerator(this.xmlMapperGenerator, warnings, progressCallback);
    }

    @Override
    public List<GeneratedXmlFile> getGeneratedXmlFiles() {
        List<GeneratedXmlFile> answer = new ArrayList();
        if (this.xmlMapperGenerator != null) {
            Document document = this.xmlMapperGenerator.getDocument();
            GeneratedXmlFile gxf = new GeneratedXmlFile(document, this.getMyBatis3XmlMapperFileName(), this.getMyBatis3XmlMapperPackage(), this.context.getSqlMapGeneratorConfiguration().getTargetProject(), false, this.context.getXmlFormatter());
            if (this.context.getPlugins().sqlMapGenerated(gxf, this)) {
                answer.add(gxf);
            }
        }

        return answer;
    }

    @Override
    protected AbstractJavaClientGenerator createJavaClientGenerator() {
        return this.context.getJavaClientGeneratorConfiguration() == null ? null : new EasyJavaMapperGenerator();
    }
}
