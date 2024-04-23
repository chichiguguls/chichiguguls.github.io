package com.ruoyi.jsf.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.jsf.mapper.AGuihuanMapper;
import com.ruoyi.jsf.domain.AGuihuan;
import com.ruoyi.jsf.service.IAGuihuanService;

/**
 * 资产归还Service业务层处理
 * 
 * @author ruoyi
 * @date 2024-02-27
 */
@Service
public class AGuihuanServiceImpl implements IAGuihuanService 
{
    @Autowired
    private AGuihuanMapper aGuihuanMapper;

    /**
     * 查询资产归还
     * 
     * @param id 资产归还主键
     * @return 资产归还
     */
    @Override
    public AGuihuan selectAGuihuanById(Long id)
    {
        return aGuihuanMapper.selectAGuihuanById(id);
    }

    /**
     * 查询资产归还列表
     * 
     * @param aGuihuan 资产归还
     * @return 资产归还
     */
    @Override
    public List<AGuihuan> selectAGuihuanList(AGuihuan aGuihuan)
    {
        return aGuihuanMapper.selectAGuihuanList(aGuihuan);
    }

    /**
     * 新增资产归还
     * 
     * @param aGuihuan 资产归还
     * @return 结果
     */
    @Override
    public int insertAGuihuan(AGuihuan aGuihuan)
    {
        return aGuihuanMapper.insertAGuihuan(aGuihuan);
    }

    /**
     * 修改资产归还
     * 
     * @param aGuihuan 资产归还
     * @return 结果
     */
    @Override
    public int updateAGuihuan(AGuihuan aGuihuan)
    {
        return aGuihuanMapper.updateAGuihuan(aGuihuan);
    }

    /**
     * 批量删除资产归还
     * 
     * @param ids 需要删除的资产归还主键
     * @return 结果
     */
    @Override
    public int deleteAGuihuanByIds(Long[] ids)
    {
        return aGuihuanMapper.deleteAGuihuanByIds(ids);
    }

    /**
     * 删除资产归还信息
     * 
     * @param id 资产归还主键
     * @return 结果
     */
    @Override
    public int deleteAGuihuanById(Long id)
    {
        return aGuihuanMapper.deleteAGuihuanById(id);
    }
}
