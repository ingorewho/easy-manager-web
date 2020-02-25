package com.easy.infra.util.mybatis.mapper;

import com.easy.infra.util.mybatis.element.EasyDeleteByIdElementGenerator;
import com.easy.infra.util.mybatis.element.EasyInsertElementGenerator;
import com.easy.infra.util.mybatis.element.EasySelectByIdElementGenerator;
import com.easy.infra.util.mybatis.element.EasySelectElementGenerator;
import com.easy.infra.util.mybatis.element.EasySelectOneElementGenerator;
import com.easy.infra.util.mybatis.element.EasyUpdateElementGenerator;
import org.mybatis.generator.api.FullyQualifiedTable;
import org.mybatis.generator.api.dom.xml.Attribute;
import org.mybatis.generator.api.dom.xml.XmlElement;
import org.mybatis.generator.codegen.mybatis3.xmlmapper.XMLMapperGenerator;
import org.mybatis.generator.codegen.mybatis3.xmlmapper.elements.AbstractXmlElementGenerator;
import org.mybatis.generator.internal.util.messages.Messages;

/**
 * @Author rzq
 * @Desc
 * @Date 2020-02-16
 **/
public class EasyXmlMapperGenerator extends XMLMapperGenerator {
    public EasyXmlMapperGenerator() {
    }

    protected XmlElement getSqlMapElement() {
        FullyQualifiedTable table = this.introspectedTable.getFullyQualifiedTable();
        this.progressCallback.startTask(Messages.getString("Progress.12", table.toString()));
        XmlElement answer = new XmlElement("mapper");
        String namespace = this.introspectedTable.getMyBatis3SqlMapNamespace();
        answer.addAttribute(new Attribute("namespace", namespace));
        this.addResultMapWithoutBLOBsElement(answer);
        this.addResultMapWithBLOBsElement(answer);
        this.addBaseColumnListElement(answer);
        this.addBlobColumnListElement(answer);
        this.addInsertElement(answer);
        this.addUpdateElement(answer);
        this.addDeleteByIdElement(answer);
        this.addSelectByIdElement(answer);
        this.addSelectElement(answer);
        this.addSelectOneElement(answer);
        return answer;
    }

    protected void addInsertElement(XmlElement parentElement) {
        AbstractXmlElementGenerator elementGenerator = new EasyInsertElementGenerator();
        this.initializeAndExecuteGenerator(elementGenerator, parentElement);
    }

    protected void addSelectByIdElement(XmlElement parentElement) {
        AbstractXmlElementGenerator elementGenerator = new EasySelectByIdElementGenerator();
        this.initializeAndExecuteGenerator(elementGenerator, parentElement);
    }

    protected void addDeleteByIdElement(XmlElement parentElement) {
        AbstractXmlElementGenerator elementGenerator = new EasyDeleteByIdElementGenerator(false);
        this.initializeAndExecuteGenerator(elementGenerator, parentElement);
    }

    protected void addUpdateElement(XmlElement parentElement) {
        AbstractXmlElementGenerator elementGenerator = new EasyUpdateElementGenerator();
        this.initializeAndExecuteGenerator(elementGenerator, parentElement);
    }

    protected void addSelectElement(XmlElement parentElement) {
        AbstractXmlElementGenerator elementGenerator = new EasySelectElementGenerator();
        this.initializeAndExecuteGenerator(elementGenerator, parentElement);
    }

    protected void addSelectOneElement(XmlElement parentElement) {
        AbstractXmlElementGenerator elementGenerator = new EasySelectOneElementGenerator();
        this.initializeAndExecuteGenerator(elementGenerator, parentElement);
    }
}

