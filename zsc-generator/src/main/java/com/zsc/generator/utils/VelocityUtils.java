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
        velocityContext.put("importJavaList", getImportListWithJava(genTable.getColumns()));

        HashSet<String> importListWithVue = getImportListWithVue(genTable.getColumns());
        velocityContext.put("importVueList",importListWithVue);
        velocityContext.put("extendsName",getExtendsName(importListWithVue));
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
        // java
        List<String> templates = new ArrayList<>();
        templates.add("vm/java/BaseController.java.vm");
        templates.add("vm/java/BaseService.java.vm");
        templates.add("vm/java/CustomControllers.java.vm");
        templates.add("vm/java/Domain.java.vm");
        templates.add("vm/java/QueryBean.java.vm");
        templates.add("vm/java/Repository.java.vm");

        // vue
        templates.add("vm/vue/BaseEntity.ts.vm");
        templates.add("vm/vue/Controller.ts.vm");
        templates.add("vm/vue/Domain.ts.vm");
        templates.add("vm/vue/HasCreatorAndUserEntity.ts.vm");
        templates.add("vm/vue/HasTimeEntity.ts.vm");
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
     * 后端根据列类型获取导入包
     *
     * @param columns 列集合
     * @return 返回需要导入的包列表
     */
    public static HashSet<String> getImportListWithJava(List<GenTableColumn> columns) {
        HashSet<String> importJavaList = new HashSet<String>();
        for (GenTableColumn column : columns) {
             if (column.getJavaType().equals("LocalDateTime")) {
                 importJavaList.add("import java.time.LocalDateTime");
             }
             else if (column.getJavaType().equals("BigDecimal")) {
                 importJavaList.add("java.math.BigDecimal");
             }
        }
        return importJavaList;
    }

    /**
     * 前端根据列类型获取导入包
     *
     * @param columns 列集合
     * @return 返回需要导入的包列表
     */
    public static HashSet<String> getImportListWithVue(List<GenTableColumn> columns) {
        HashSet<String> importVueList = new HashSet<String>();
        int id = 0;
        int created = 0;
        int creator = 0;
        for (GenTableColumn column : columns) {
            if (column.getColumnName().equals("id")){
                id++;
            } else if (column.getColumnName().equals("created")) {
                created++;
            } else if (column.getColumnName().equals("creator")) {
                creator++;
            }
        }

        if (creator==1){
            importVueList.add("import HasCreatorAndUserEntity from \'@/zsc/entity/base/has-creator-and-user-entity\'");
            return importVueList;
        } else if (created == 1) {
            importVueList.add("import HasTimeEntity from \'@/zsc/entity/base/has-time-entity\'");
            return importVueList;
        } else if (id==1) {
            importVueList.add("import BaseEntity from \'@/zsc/entity/base/base-entity\'");
            return importVueList;
        } else {
            return importVueList;
        }
    }

    private static String getExtendsName(HashSet<String> hs){
        for(String item : hs){
            if (item.equals("import HasCreatorAndUserEntity from \'@/zsc/entity/base/has-creator-and-user-entity\'")){
                return "HasCreatorAndUserEntity";
            } else if (item.equals("import HasTimeEntity from \'@/zsc/entity/base/base-entity\'")) {
                return "HasTimeEntity";
            } else if (item.equals("import BaseEntity from \'@/zsc/entity/base/base-entity\'")) {
                return "BaseEntity";
            }
        }
        return null;
    }
}
