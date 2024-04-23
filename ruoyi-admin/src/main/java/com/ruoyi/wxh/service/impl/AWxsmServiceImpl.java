package com.ruoyi.wxh.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.wxh.mapper.AWxsmMapper;
import com.ruoyi.wxh.domain.AWxsm;
import com.ruoyi.wxh.service.IAWxsmService;

/**
 * 资产维修Service业务层处理
 * 
 * @author ruoyi
 * @date 2024-02-27
 */
@Service
public class AWxsmServiceImpl implements IAWxsmService 
{
    @Autowired
    private AWxsmMapper aWxsmMapper;

    /**
     * 查询资产维修
     * 
     * @param id 资产维修主键
     * @return 资产维修
     */
    @Override
    public AWxsm selectAWxsmById(Long id)
    {
        return aWxsmMapper.selectAWxsmById(id);
    }

    /**
     * 查询资产维修列表
     * 
     * @param aWxsm 资产维修
     * @return 资产维修
     */
    @Override
    public List<AWxsm> selectAWxsmList(AWxsm aWxsm)
    {
        return aWxsmMapper.selectAWxsmList(aWxsm);
    }

    /**
     * 新增资产维修
     * 
     * @param aWxsm 资产维修
     * @return 结果
     */
    @Override
    public int insertAWxsm(AWxsm aWxsm)
    {
        return aWxsmMapper.insertAWxsm(aWxsm);
    }

    /**
     * 修改资产维修
     * 
     * @param aWxsm 资产维修
     * @return 结果
     */
    @Override
    public int updateAWxsm(AWxsm aWxsm)
    {
        return aWxsmMapper.updateAWxsm(aWxsm);
    }

    /**
     * 批量删除资产维修
     * 
     * @param ids 需要删除的资产维修主键
     * @return 结果
     */
    @Override
    public int deleteAWxsmByIds(Long[] ids)
    {
        return aWxsmMapper.deleteAWxsmByIds(ids);
    }

    /**
     * 删除资产维修信息
     * 
     * @param id 资产维修主键
     * @return 结果
     */
    @Override
    public int deleteAWxsmById(Long id)
    {
        return aWxsmMapper.deleteAWxsmById(id);
    }
}
