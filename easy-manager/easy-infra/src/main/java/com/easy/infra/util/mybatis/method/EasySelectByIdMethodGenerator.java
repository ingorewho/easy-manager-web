package com.easy.infra.util.mybatis.method;

import org.mybatis.generator.api.IntrospectedColumn;
import org.mybatis.generator.api.dom.java.FullyQualifiedJavaType;
import org.mybatis.generator.api.dom.java.Interface;
import org.mybatis.generator.api.dom.java.JavaVisibility;
import org.mybatis.generator.api.dom.java.Method;
import org.mybatis.generator.api.dom.java.Parameter;
import org.mybatis.generator.codegen.mybatis3.javamapper.elements.AbstractJavaMapperMethodGenerator;

import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

/**
 * @Author rzq
 * @Desc
 * @Date 2020-02-16
 **/
public class EasySelectByIdMethodGenerator extends AbstractJavaMapperMethodGenerator {

    public void addInterfaceElements(Interface interfaze) {
        Method method = new Method();
        method.setVisibility(JavaVisibility.PUBLIC);
        FullyQualifiedJavaType returnType = this.introspectedTable.getRules().calculateAllFieldsClass();
        method.setReturnType(returnType);
        System.out.println("处理" + returnType.getShortName() + "对应的相关映射!");
        Set<FullyQualifiedJavaType> importedTypes = new TreeSet();
        importedTypes.add(returnType);
        method.setName("selectById");
        List<IntrospectedColumn> introspectedColumns = this.introspectedTable.getPrimaryKeyColumns();
        boolean annotate = introspectedColumns.size() > 1;
        if (annotate) {
            importedTypes.add(new FullyQualifiedJavaType("org.apache.ibatis.annotations.Param"));
        }

        StringBuilder sb = new StringBuilder();

        Parameter parameter;
        for(Iterator var8 = introspectedColumns.iterator(); var8.hasNext(); method.addParameter(parameter)) {
            IntrospectedColumn introspectedColumn = (IntrospectedColumn)var8.next();
            FullyQualifiedJavaType type = introspectedColumn.getFullyQualifiedJavaType();
            importedTypes.add(type);
            parameter = new Parameter(type, introspectedColumn.getJavaProperty());
            if (annotate) {
                sb.setLength(0);
                sb.append("@Param(\"");
                sb.append(introspectedColumn.getJavaProperty());
                sb.append("\")");
                parameter.addAnnotation(sb.toString());
            }
        }

        this.context.getCommentGenerator().addGeneralMethodComment(method, this.introspectedTable);
        interfaze.addImportedTypes(importedTypes);
        interfaze.addMethod(method);
    }
}
