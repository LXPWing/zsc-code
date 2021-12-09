package com.zsc.generator.domain;

import com.zsc.common.domain.BaseEntity;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import java.util.List;

/**
 * @author : xingpeng
 * @date : 2021-12-09 19:13
 **/
public class GenTable extends BaseEntity {

    private static final long serialVersionUID = 1L;

    /** 编号 */
    private Long tableId;

    /** 生成模块名 */
    @NotBlank(message = "生成模块名不能为空")
    private String moduleName;

    /** 表名称 */
    @NotBlank(message = "表名称不能为空")
    private String tableName;

    /** 表描述 */
    @NotBlank(message = "表描述不能为空")
    private String tableComment;

    /** 实体类名称(首字母大写) */
    @NotBlank(message = "实体类名称不能为空")
    private String className;

    /** 生成功能名 */
    @NotBlank(message = "生成功能名不能为空")
    private String functionName;

    /** 生成包路径 */
    @NotBlank(message = "生成包路径不能为空")
    private String packageName;

    /** 表列信息 */
    @Valid
    private List<GenTableColumn> columns;

    public Long getTableId() {
        return tableId;
    }

    public void setTableId(Long tableId) {
        this.tableId = tableId;
    }

    public String getTableName() {
        return tableName;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName;
    }

    public String getTableComment() {
        return tableComment;
    }

    public void setTableComment(String tableComment) {
        this.tableComment = tableComment;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public List<GenTableColumn> getColumns() {
        return columns;
    }

    public void setColumns(List<GenTableColumn> columns) {
        this.columns = columns;
    }

    public String getModuleName() {
        return moduleName;
    }

    public void setModuleName(String moduleName) {
        this.moduleName = moduleName;
    }

    public String getFunctionName() {
        return functionName;
    }

    public void setFunctionName(String functionName) {
        this.functionName = functionName;
    }

    public String getPackageName() {
        return packageName;
    }

    public void setPackageName(String packageName) {
        this.packageName = packageName;
    }
}
