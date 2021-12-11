package com.zsc.generator.domain;

import com.zsc.common.domain.BaseEntity;
import lombok.Data;
import lombok.experimental.Tolerate;

import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import java.util.List;

/**
 * @author : xingpeng
 * @date : 2021-12-09 19:13
 **/
@Data
@Entity
@Table(name = "gen_table")
public class GenTable extends BaseEntity {

    private static final long serialVersionUID = 1L;

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
    @OneToMany(targetEntity = GenTableColumn.class, cascade = CascadeType.ALL)
    @JoinColumn(name = "table_id",referencedColumnName = "id")
    private List<GenTableColumn> columns;
}
