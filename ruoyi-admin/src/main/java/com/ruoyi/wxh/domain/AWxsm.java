package com.ruoyi.wxh.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 资产维修对象 a_wxsm
 * 
 * @author ruoyi
 * @date 2024-02-27
 */
public class AWxsm extends BaseEntity
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

    /** 数量 */
    @Excel(name = "数量")
    private String quantity;

    /** 维修数量 */
    @Excel(name = "维修数量")
    private Long weixiushuliang;

    /** 维修说明 */
    @Excel(name = "维修说明")
    private String shuoming;

    /** 维修进度 */
    @Excel(name = "维修进度")
    private String schedule;

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
    public void setQuantity(String quantity) 
    {
        this.quantity = quantity;
    }

    public String getQuantity() 
    {
        return quantity;
    }
    public void setWeixiushuliang(Long weixiushuliang) 
    {
        this.weixiushuliang = weixiushuliang;
    }

    public Long getWeixiushuliang() 
    {
        return weixiushuliang;
    }
    public void setShuoming(String shuoming) 
    {
        this.shuoming = shuoming;
    }

    public String getShuoming() 
    {
        return shuoming;
    }
    public void setSchedule(String schedule) 
    {
        this.schedule = schedule;
    }

    public String getSchedule() 
    {
        return schedule;
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
            .append("quantity", getQuantity())
            .append("weixiushuliang", getWeixiushuliang())
            .append("shuoming", getShuoming())
            .append("schedule", getSchedule())
            .append("addtime", getAddtime())
            .toString();
    }
}
