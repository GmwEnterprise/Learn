package cn.gmwenterprise.website.generator;

import freemarker.template.Template;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.Map;

public class CodeHelper {

    private static final String PO_PATH = "/src/main/java/cn/gmwenterprise/website/domain/";
    private static final String BO_PATH = "/src/main/java/cn/gmwenterprise/website/vo/";
    private static final String DAO_PATH = "/src/main/java/cn/gmwenterprise/website/dao/";
    private static final String MAPPER_PATH = "/src/main/resources/dao-mapping/";
    private static final String SERVICE_PATH = "/src/main/java/cn/gmwenterprise/website/service/";
    private static final String SERVICE_IMPL_PATH = "/src/main/java/cn/gmwenterprise/website/service/impl/";
    private static final String SERVICE_JS_PATH = "/src/main/resources/service-js/";
    private static final String CONTROLLER_PATH = "/src/main/java/cn/gmwenterprise/website/web/";

    public static void main(String[] args) throws Exception {
        generateTable("sys_table_list");
        generateTable("comment");
        generateTable("article");
        generateTable("account");
    }

    public static void generateTable(String tableName) throws Exception {
        TableStruct tableStruct = DatabaseHelper.getInstance().getTableStruct(tableName);
        if (tableStruct == null) {
            System.err.println(tableName + "表不存在");
            return;
        }
        generateAllFiles(tableStruct);
    }

    public static void generateAllFiles(TableStruct ts) throws Exception {
        if (ts == null) {
            System.out.println("滚");
            return;
        }
        Map<String, Object> tsMap = ts.toMap();
//        generateServiceJsFile(tsMap);
//        generateControllerFile(tsMap);
//        generatePoFile(tsMap);
//        generateBoFile(tsMap);
//        generateDaoFile(tsMap);
        generateMapperFile(tsMap);
//        generateServiceFile(tsMap);
//        generateServiceImplFile(tsMap);
    }

    /**
     * 生成po
     *
     * @throws Exception 异常
     */
    public static void generatePoFile(Map<String, Object> ts) throws Exception {
        Template template = FreemarkerConfig.getTemplate("entity-po.ftl");
        File po = new File(System.getProperty("user.dir") + PO_PATH + ts.get("entityName") + ".java");
        Writer out = new OutputStreamWriter(new FileOutputStream(po));
        template.process(ts, out);
        out.flush();
    }

    /**
     * 生成bo
     *
     * @throws Exception 异常
     */
    public static void generateBoFile(Map<String, Object> ts) throws Exception {
        Template template = FreemarkerConfig.getTemplate("entity-bo.ftl");
        File po = new File(System.getProperty("user.dir") + BO_PATH + ts.get("entityName") + "Vo.java");
        Writer out = new OutputStreamWriter(new FileOutputStream(po));
        template.process(ts, out);
        out.flush();
    }

    /**
     * 生成dao
     *
     * @throws Exception 异常
     */
    public static void generateDaoFile(Map<String, Object> ts) throws Exception {
        Template template = FreemarkerConfig.getTemplate("dao.ftl");
        File po = new File(System.getProperty("user.dir") + DAO_PATH + ts.get("entityName") + "Dao.java");
        Writer out = new OutputStreamWriter(new FileOutputStream(po));
        template.process(ts, out);
        out.flush();
    }

    /**
     * 生成mapper
     *
     * @throws Exception 异常
     */
    public static void generateMapperFile(Map<String, Object> ts) throws Exception {
        Template template = FreemarkerConfig.getTemplate("mapper.ftl");
        File po = new File(System.getProperty("user.dir") + MAPPER_PATH + ts.get("entityName") + "Mapper.xml");
        Writer out = new OutputStreamWriter(new FileOutputStream(po));
        template.process(ts, out);
        out.flush();
    }

    /**
     * 生成service
     *
     * @throws Exception 异常
     */
    public static void generateServiceFile(Map<String, Object> ts) throws Exception {
        Template template = FreemarkerConfig.getTemplate("service.ftl");
        File po = new File(System.getProperty("user.dir") + SERVICE_PATH + ts.get("entityName") + "Service.java");
        Writer out = new OutputStreamWriter(new FileOutputStream(po));
        template.process(ts, out);
        out.flush();
    }

    /**
     * 生成serviceImpl
     *
     * @throws Exception 异常
     */
    public static void generateServiceImplFile(Map<String, Object> ts) throws Exception {
        Template template = FreemarkerConfig.getTemplate("service-impl.ftl");
        File po = new File(System.getProperty("user.dir") + SERVICE_IMPL_PATH + ts.get("entityName") + "ServiceImpl.java");
        Writer out = new OutputStreamWriter(new FileOutputStream(po));
        template.process(ts, out);
        out.flush();
    }

    /**
     * 生成controller
     *
     * @throws Exception 异常
     */
    public static void generateControllerFile(Map<String, Object> ts) throws Exception {
        Template template = FreemarkerConfig.getTemplate("controller.ftl");
        File po = new File(System.getProperty("user.dir") + CONTROLLER_PATH + ts.get("entityName") + "Controller.java");
        Writer out = new OutputStreamWriter(new FileOutputStream(po));
        template.process(ts, out);
        out.flush();
    }

    /**
     * 生成serviceImpl
     *
     * @throws Exception 异常
     */
    public static void generateServiceJsFile(Map<String, Object> ts) throws Exception {
        Template template = FreemarkerConfig.getTemplate("service-js.ftl");
        File po = new File(System.getProperty("user.dir") + SERVICE_JS_PATH + ts.get("entityAlias") + ".js");
        Writer out = new OutputStreamWriter(new FileOutputStream(po));
        template.process(ts, out);
        out.flush();
    }
}
