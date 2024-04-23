package com.ruoyi.wsh.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.wsh.mapper.ALendMapper;
import com.ruoyi.wsh.domain.ALend;
import com.ruoyi.wsh.service.IALendService;

/**
 * 资产借出Service业务层处理
 * 
 * @author ruoyi
 * @date 2024-02-27
 */
@Service
public class ALendServiceImpl implements IALendService 
{
    @Autowired
    private ALendMapper aLendMapper;

    /**
     * 查询资产借出
     * 
     * @param id 资产借出主键
     * @return 资产借出
     */
    @Override
    public ALend selectALendById(Long id)
    {
        return aLendMapper.selectALendById(id);
    }

    /**
     * 查询资产借出列表
     * 
     * @param aLend 资产借出
     * @return 资产借出
     */
    @Override
    public List<ALend> selectALendList(ALend aLend)
    {
        return aLendMapper.selectALendList(aLend);
    }

    /**
     * 新增资产借出
     * 
     * @param aLend 资产借出
     * @return 结果
     */
    @Override
    public int insertALend(ALend aLend)
    {
        return aLendMapper.insertALend(aLend);
    }

    /**
     * 修改资产借出
     * 
     * @param aLend 资产借出
     * @return 结果
     */
    @Override
    public int updateALend(ALend aLend)
    {
        return aLendMapper.updateALend(aLend);
    }

    /**
     * 批量删除资产借出
     * 
     * @param ids 需要删除的资产借出主键
     * @return 结果
     */
    @Override
    public int deleteALendByIds(Long[] ids)
    {
        return aLendMapper.deleteALendByIds(ids);
    }

    /**
     * 删除资产借出信息
     * 
     * @param id 资产借出主键
     * @return 结果
     */
    @Override
    public int deleteALendById(Long id)
    {
        return aLendMapper.deleteALendById(id);
    }
}
