package com.taiji.Lircon.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

/**
 * <p>
 * 基础3d模型表
 * </p>
 *
 * @author cao shunmao
 * @since 2024-03-16
 */
@Getter
@Setter
@TableName("model3d_base")
@ApiModel(value = "Model3dBase对象", description = "基础3d模型表")
public class Model3dBase implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "ID", type = IdType.ASSIGN_ID)
    private Long id;

    @ApiModelProperty("名称")
    @TableField("modelName")
    private String modelName;

    @ApiModelProperty("所属分类")
    @TableField("modelClassID")
    private Long modelClassID;

    @ApiModelProperty("厂商")
    @TableField("brand")
    private String brand;

    @ApiModelProperty("描述")
    @TableField("desc")
    private String desc;

    @ApiModelProperty("缩略图1")
    @TableField("thumbnail1")
    private String thumbnail1;

    @ApiModelProperty("缩略图2")
    @TableField("thumbnail2")
    private String thumbnail2;

    @ApiModelProperty("缩略图3")
    @TableField("thumbnail3")
    private String thumbnail3;

    @ApiModelProperty("模型文件1")
    @TableField("modelFile1")
    private String modelFile1;

    @ApiModelProperty("模型文件2")
    @TableField("modelFile2")
    private String modelFile2;

    @ApiModelProperty("模型文件3")
    @TableField("modelFile3")
    private String modelFile3;
}
