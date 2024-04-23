package com.ruoyi.wsh.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 资产借出对象 a_lend
 * 
 * @author ruoyi
 * @date 2024-02-27
 */
public class ALend extends BaseEntity
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

    /** 数量 */
    @Excel(name = "数量")
    private Long quantity;

    /** 借出日期 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "借出日期", width = 30, dateFormat = "yyyy-MM-dd")
    private Date lend;

    /** 用户名 */
    @Excel(name = "用户名")
    private String userName;

    /** 姓名 */
    @Excel(name = "姓名")
    private String surname;

    /** 手机号 */
    @Excel(name = "手机号")
    private String phone;

    /** 身份证 */
    @Excel(name = "身份证")
    private String card;

    /** 是否审核 */
    @Excel(name = "是否审核")
    private String ssfh;

    /** 审核回复 */
    @Excel(name = "审核回复")
    private String shhf;

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
    public void setQuantity(Long quantity) 
    {
        this.quantity = quantity;
    }

    public Long getQuantity() 
    {
        return quantity;
    }
    public void setLend(Date lend) 
    {
        this.lend = lend;
    }

    public Date getLend() 
    {
        return lend;
    }
    public void setUserName(String userName) 
    {
        this.userName = userName;
    }

    public String getUserName() 
    {
        return userName;
    }
    public void setSurname(String surname) 
    {
        this.surname = surname;
    }

    public String getSurname() 
    {
        return surname;
    }
    public void setPhone(String phone) 
    {
        this.phone = phone;
    }

    public String getPhone() 
    {
        return phone;
    }
    public void setCard(String card) 
    {
        this.card = card;
    }

    public String getCard() 
    {
        return card;
    }
    public void setSsfh(String ssfh) 
    {
        this.ssfh = ssfh;
    }

    public String getSsfh() 
    {
        return ssfh;
    }
    public void setShhf(String shhf) 
    {
        this.shhf = shhf;
    }

    public String getShhf() 
    {
        return shhf;
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
            .append("quantity", getQuantity())
            .append("lend", getLend())
            .append("remark", getRemark())
            .append("userName", getUserName())
            .append("surname", getSurname())
            .append("phone", getPhone())
            .append("card", getCard())
            .append("ssfh", getSsfh())
            .append("shhf", getShhf())
            .append("addtime", getAddtime())
            .toString();
    }
}
