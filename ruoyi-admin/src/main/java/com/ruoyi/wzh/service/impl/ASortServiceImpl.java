package com.ruoyi.wzh.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.wzh.mapper.ASortMapper;
import com.ruoyi.wzh.domain.ASort;
import com.ruoyi.wzh.service.IASortService;

/**
 * 资产分类Service业务层处理
 * 
 * @author ruoyi
 * @date 2024-02-27
 */
@Service
public class ASortServiceImpl implements IASortService 
{
    @Autowired
    private ASortMapper aSortMapper;

    /**
     * 查询资产分类
     * 
     * @param id 资产分类主键
     * @return 资产分类
     */
    @Override
    public ASort selectASortById(Long id)
    {
        return aSortMapper.selectASortById(id);
    }

    /**
     * 查询资产分类列表
     * 
     * @param aSort 资产分类
     * @return 资产分类
     */
    @Override
    public List<ASort> selectASortList(ASort aSort)
    {
        return aSortMapper.selectASortList(aSort);
    }

    /**
     * 新增资产分类
     * 
     * @param aSort 资产分类
     * @return 结果
     */
    @Override
    public int insertASort(ASort aSort)
    {
        return aSortMapper.insertASort(aSort);
    }

    /**
     * 修改资产分类
     * 
     * @param aSort 资产分类
     * @return 结果
     */
    @Override
    public int updateASort(ASort aSort)
    {
        return aSortMapper.updateASort(aSort);
    }

    /**
     * 批量删除资产分类
     * 
     * @param ids 需要删除的资产分类主键
     * @return 结果
     */
    @Override
    public int deleteASortByIds(Long[] ids)
    {
        return aSortMapper.deleteASortByIds(ids);
    }

    /**
     * 删除资产分类信息
     * 
     * @param id 资产分类主键
     * @return 结果
     */
    @Override
    public int deleteASortById(Long id)
    {
        return aSortMapper.deleteASortById(id);
    }
}
