package com.ruoyi.jyf.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.jyf.mapper.AAssetsMapper;
import com.ruoyi.jyf.domain.AAssets;
import com.ruoyi.jyf.service.IAAssetsService;

/**
 * 资产信息Service业务层处理
 * 
 * @author ruoyi
 * @date 2024-02-27
 */
@Service
public class AAssetsServiceImpl implements IAAssetsService 
{
    @Autowired
    private AAssetsMapper aAssetsMapper;

    /**
     * 查询资产信息
     * 
     * @param id 资产信息主键
     * @return 资产信息
     */
    @Override
    public AAssets selectAAssetsById(Long id)
    {
        return aAssetsMapper.selectAAssetsById(id);
    }

    /**
     * 查询资产信息列表
     * 
     * @param aAssets 资产信息
     * @return 资产信息
     */
    @Override
    public List<AAssets> selectAAssetsList(AAssets aAssets)
    {
        return aAssetsMapper.selectAAssetsList(aAssets);
    }

    /**
     * 新增资产信息
     * 
     * @param aAssets 资产信息
     * @return 结果
     */
    @Override
    public int insertAAssets(AAssets aAssets)
    {
        return aAssetsMapper.insertAAssets(aAssets);
    }

    /**
     * 修改资产信息
     * 
     * @param aAssets 资产信息
     * @return 结果
     */
    @Override
    public int updateAAssets(AAssets aAssets)
    {
        return aAssetsMapper.updateAAssets(aAssets);
    }

    /**
     * 批量删除资产信息
     * 
     * @param ids 需要删除的资产信息主键
     * @return 结果
     */
    @Override
    public int deleteAAssetsByIds(Long[] ids)
    {
        return aAssetsMapper.deleteAAssetsByIds(ids);
    }

    /**
     * 删除资产信息信息
     * 
     * @param id 资产信息主键
     * @return 结果
     */
    @Override
    public int deleteAAssetsById(Long id)
    {
        return aAssetsMapper.deleteAAssetsById(id);
    }
}
