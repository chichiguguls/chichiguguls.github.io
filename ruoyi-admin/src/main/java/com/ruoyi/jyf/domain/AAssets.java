package com.ruoyi.jyf.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 资产信息对象 a_assets
 * 
 * @author ruoyi
 * @date 2024-02-27
 */
public class AAssets extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 主键 */
    private Long id;

    /** 资产编号 */
    @Excel(name = "资产编号")
    private String no;

    /** 设备名称 */
    @Excel(name = "设备名称")
    private String name;

    /** 资产分类 */
    @Excel(name = "资产分类")
    private String sort;

    /** 资产图片 */
    @Excel(name = "资产图片")
    private String picture;

    /** 单价 */
    @Excel(name = "单价")
    private String money;

    /** 数量 */
    @Excel(name = "数量")
    private Long quantity;

    /** 当前位置 */
    @Excel(name = "当前位置")
    private String position;

    /** 创建时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "创建时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date addtime;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setNo(String no) 
    {
        this.no = no;
    }

    public String getNo() 
    {
        return no;
    }
    public void setName(String name) 
    {
        this.name = name;
    }

    public String getName() 
    {
        return name;
    }
    public void setSort(String sort) 
    {
        this.sort = sort;
    }

    public String getSort() 
    {
        return sort;
    }
    public void setPicture(String picture) 
    {
        this.picture = picture;
    }

    public String getPicture() 
    {
        return picture;
    }
    public void setMoney(String money) 
    {
        this.money = money;
    }

    public String getMoney() 
    {
        return money;
    }
    public void setQuantity(Long quantity) 
    {
        this.quantity = quantity;
    }

    public Long getQuantity() 
    {
        return quantity;
    }
    public void setPosition(String position) 
    {
        this.position = position;
    }

    public String getPosition() 
    {
        return position;
    }
    public void setAddtime(Date addtime) 
    {
        this.addtime = addtime;
    }

    public Date getAddtime() 
    {
        return addtime;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("no", getNo())
            .append("name", getName())
            .append("sort", getSort())
            .append("picture", getPicture())
            .append("money", getMoney())
            .append("quantity", getQuantity())
            .append("remark", getRemark())
            .append("position", getPosition())
            .append("addtime", getAddtime())
            .toString();
    }
}
