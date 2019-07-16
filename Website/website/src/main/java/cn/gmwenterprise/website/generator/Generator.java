package cn.gmwenterprise.website.generator;

import freemarker.template.Template;
import freemarker.template.TemplateException;

import java.io.*;

public class Generator {

    private static final String PO_PATH = "src/main/java/cn/gmwenterprise/website/po/";
    private static final String BO_PATH = "src/main/java/cn/gmwenterprise/website/bo/";

    /**
     * 生成po
     * @throws IOException
     * @throws TemplateException
     */
    public static void generatePo(TableStruct tableStruct) throws IOException, TemplateException {
        Template template = FreemarkerConfig.getTemplate("entity-po.ftl");
        File po = new File(System.getProperty("user.dir") + PO_PATH + tableStruct.getEntityName() + ".java");
        Writer out = new OutputStreamWriter(new FileOutputStream(po));
        template.process(tableStruct, out);
        out.flush();
    }
}
