package com.zsc.generator.utils;

import cn.hutool.core.util.StrUtil;
import com.zsc.generator.domain.GenTable;
import com.zsc.generator.domain.GenTableColumn;
import org.apache.velocity.VelocityContext;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 * @author : xingpeng
 * @date : 2021-12-09 19:06
 **/
public class VelocityUtils {

    /** 项目空间路径 */
    private static final String PROJECT_PATH = "main/java";

    /**
     * 设置模板变量信息
     *
     * @return 模板列表
     */
    public static VelocityContext prepareContext(GenTable genTable) {
        VelocityContext velocityContext = new VelocityContext();
        String moduleName = genTable.getModuleName();
        String packageName = genTable.getPackageName();
        String functionName = genTable.getFunctionName();

        velocityContext.put("functionName", functionName);
        velocityContext.put("moduleName", moduleName);
        velocityContext.put("packageName", packageName);
        velocityContext.put("ClassName", genTable.getClassName());
        velocityContext.put("className", StringUtils.uncapitalize(genTable.getClassName()));
        velocityContext.put("importList", getImportList(genTable.getColumns()));
        velocityContext.put("columns", genTable.getColumns());
        velocityContext.put("table", genTable);

        return velocityContext;
    }

    /**
     * 获取模板信息
     *
     * @return 模板列表
     */
    public static List<String> getTemplateList(){
        List<String> templates = new ArrayList<>();
        templates.add("vm/java/BaseController.java.vm");
        templates.add("vm/java/BaseService.java.vm");
        templates.add("vm/java/CustomControllers.java.vm");
        templates.add("vm/java/Domain.java.vm");
        templates.add("vm/java/QueryBean.java.vm");
        templates.add("vm/java/Repository.java.vm");
        return templates;
    }

    /**
     * 获取文件名
     */
    public static String getFileName(String template, GenTable genTable) {
        // 文件名称
        String fileName = "";
        // 包路径
        String packageName = genTable.getPackageName();
        // 模块名
        String moduleName = genTable.getModuleName();
        // 大写类名
        String className = genTable.getClassName();
        String javaPath = PROJECT_PATH + "/" + StringUtils.replace(packageName, ".", "/");

        if (template.contains("BaseController.java.vm")) {
            fileName = String.format("%s/controller/%s.java", javaPath, className);
        } else if (template.contains("BaseService.java.vm")) {
            fileName = String.format("%s/service/%s.java", javaPath, className);
        } else if (template.contains("CustomControllers.java.vm")) {
            fileName = String.format("%s/controller/%s.java", javaPath, className);
        } else if (template.contains("Domain.java.vm")) {
            fileName = String.format("%s/domain/%s.java", javaPath, className);
        } else if (template.contains("QueryBean.java.vm")) {
            fileName = String.format("%s/queryBean/%s.java", javaPath, className);
        } else if (template.contains("Repository.java.vm")) {
            fileName = String.format("%s/repository/%s.java", javaPath, className);
        }
        
        return fileName;
    }

    /**
     * 获取包前缀
     *
     * @param packageName 包名称
     * @return 包前缀名称
     */
    public static String getPackagePrefix(String packageName)
    {
        int lastIndex = packageName.lastIndexOf(".");
        String basePackage = StrUtil.sub(packageName,0,lastIndex);
        return basePackage;
    }

    /**
     * 根据列类型获取导入包
     *
     * @param columns 列集合
     * @return 返回需要导入的包列表
     */
    public static HashSet<String> getImportList(List<GenTableColumn> columns) {
        HashSet<String> importList = new HashSet<String>();
        for (GenTableColumn column : columns) {
            // if ()
        }
        return importList;
    }

}
