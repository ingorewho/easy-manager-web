package com.easy.infra.util.mybatis.mapper;

import com.easy.infra.util.mybatis.method.EasyDeleteByIdMethodGenerator;
import com.easy.infra.util.mybatis.method.EasyInsertMethodGenerator;
import com.easy.infra.util.mybatis.method.EasySelectByIdMethodGenerator;
import com.easy.infra.util.mybatis.method.EasySelectMethodGenerator;
import com.easy.infra.util.mybatis.method.EasySelectOneMethodGenerator;
import com.easy.infra.util.mybatis.method.EasyUpdateMethodGenerator;
import org.mybatis.generator.api.CommentGenerator;
import org.mybatis.generator.api.dom.java.CompilationUnit;
import org.mybatis.generator.api.dom.java.FullyQualifiedJavaType;
import org.mybatis.generator.api.dom.java.Interface;
import org.mybatis.generator.api.dom.java.JavaVisibility;
import org.mybatis.generator.api.dom.java.TopLevelClass;
import org.mybatis.generator.codegen.mybatis3.javamapper.JavaMapperGenerator;
import org.mybatis.generator.codegen.mybatis3.javamapper.elements.AbstractJavaMapperMethodGenerator;
import org.mybatis.generator.internal.util.StringUtility;
import org.mybatis.generator.internal.util.messages.Messages;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author rzq
 * @Desc
 * @Date 2020-02-16
 **/
public class EasyJavaMapperGenerator extends JavaMapperGenerator {

    public List<CompilationUnit> getCompilationUnits() {
        this.progressCallback.startTask(Messages.getString("Progress.17", this.introspectedTable.getFullyQualifiedTable().toString()));
        CommentGenerator commentGenerator = this.context.getCommentGenerator();
        FullyQualifiedJavaType type = new FullyQualifiedJavaType(this.introspectedTable.getMyBatis3JavaMapperType());
        Interface interfaze = new Interface(type);
        interfaze.setVisibility(JavaVisibility.PUBLIC);
        commentGenerator.addJavaFileComment(interfaze);
        String rootInterface = this.introspectedTable.getTableConfigurationProperty("rootInterface");
        if (!StringUtility.stringHasValue(rootInterface)) {
            rootInterface = this.context.getJavaClientGeneratorConfiguration().getProperty("rootInterface");
        }

        if (StringUtility.stringHasValue(rootInterface)) {
            FullyQualifiedJavaType fqjt = new FullyQualifiedJavaType(rootInterface);
            interfaze.addSuperInterface(fqjt);
            interfaze.addImportedType(fqjt);
        }

        this.addInsertMethod(interfaze);
        this.addUpdateMethod(interfaze);
//        this.addDeleteByIdMethod(interfaze);
//        this.addSelectByIdMethod(interfaze);
        this.addSelectMethod(interfaze);
        this.addSelectOneMethod(interfaze);
        List<CompilationUnit> answer = new ArrayList();
        if (this.context.getPlugins().clientGenerated(interfaze, (TopLevelClass) null, this.introspectedTable)) {
            answer.add(interfaze);
        }

        List<CompilationUnit> extraCompilationUnits = this.getExtraCompilationUnits();
        if (extraCompilationUnits != null) {
            answer.addAll(extraCompilationUnits);
        }

        return answer;
    }

    protected void addInsertMethod(Interface interfaze) {
        AbstractJavaMapperMethodGenerator methodGenerator = new EasyInsertMethodGenerator();
        this.initializeAndExecuteGenerator(methodGenerator, interfaze);
    }

    protected void addSelectByIdMethod(Interface interfaze) {
        AbstractJavaMapperMethodGenerator methodGenerator = new EasySelectByIdMethodGenerator();
        this.initializeAndExecuteGenerator(methodGenerator, interfaze);
    }

    protected void addDeleteByIdMethod(Interface interfaze) {
        AbstractJavaMapperMethodGenerator methodGenerator = new EasyDeleteByIdMethodGenerator();
        this.initializeAndExecuteGenerator(methodGenerator, interfaze);
    }

    protected void addUpdateMethod(Interface interfaze) {
        AbstractJavaMapperMethodGenerator methodGenerator = new EasyUpdateMethodGenerator();
        this.initializeAndExecuteGenerator(methodGenerator, interfaze);
    }

    protected void addSelectMethod(Interface interfaze) {
        AbstractJavaMapperMethodGenerator methodGenerator = new EasySelectMethodGenerator();
        this.initializeAndExecuteGenerator(methodGenerator, interfaze);
    }

    protected void addSelectOneMethod(Interface interfaze) {
        AbstractJavaMapperMethodGenerator methodGenerator = new EasySelectOneMethodGenerator();
        this.initializeAndExecuteGenerator(methodGenerator, interfaze);
    }
}