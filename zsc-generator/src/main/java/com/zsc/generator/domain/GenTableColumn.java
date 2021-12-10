package com.zsc.generator.domain;

import com.zsc.common.domain.BaseEntity;
import lombok.Data;

import javax.persistence.Entity;
import javax.validation.constraints.NotBlank;

/**
 * @author : xingpeng
 * @date : 2021-12-09 19:13
 **/
@Data
@Entity
public class GenTableColumn extends BaseEntity {

    private static final long serialVersionUID = 1L;

    /** 编号 */
    private Long columnId;

    /** 归属表编号 */
    private Long tableId;

    /** 字段名称 */
    private String columnName;

    /** 字段描述 */
    private String columnComment;

    /** 字段类型 */
    private String columnType;

    /** JAVA类型 */
    private String javaType;

    /** JAVA属性名 */
    @NotBlank(message = "Java属性不能为空")
    private String javaField;

    /** 是否主键（1是） */
    private String isPk;

    /** 是否自增（1是） */
    private String isIncrement;

    /** 是否必填（1是） */
    private String isRequired;

    /** 查询方式（EQ等于、NE不等于、GT大于、LT小于、LIKE模糊、BETWEEN范围） */
    private String queryType;

    /** 排序 */
    private Integer sort;

//    public boolean isSuperColumn()
//    {
//        return isSuperColumn(this.javaField);
//    }

//    public static boolean isSuperColumn(String javaField)
//    {
//        return StringUtils.equalsAnyIgnoreCase(javaField,
//                // BaseEntity
//                "createBy", "createTime", "updateBy", "updateTime");
//    }

}
