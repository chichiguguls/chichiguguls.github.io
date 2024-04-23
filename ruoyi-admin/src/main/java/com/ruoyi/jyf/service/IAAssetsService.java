package com.ruoyi.jyf.service;

import java.util.List;
import com.ruoyi.jyf.domain.AAssets;

/**
 * 资产信息Service接口
 * 
 * @author ruoyi
 * @date 2024-02-27
 */
public interface IAAssetsService 
{
    /**
     * 查询资产信息
     * 
     * @param id 资产信息主键
     * @return 资产信息
     */
    public AAssets selectAAssetsById(Long id);

    /**
     * 查询资产信息列表
     * 
     * @param aAssets 资产信息
     * @return 资产信息集合
     */
    public List<AAssets> selectAAssetsList(AAssets aAssets);

    /**
     * 新增资产信息
     * 
     * @param aAssets 资产信息
     * @return 结果
     */
    public int insertAAssets(AAssets aAssets);

    /**
     * 修改资产信息
     * 
     * @param aAssets 资产信息
     * @return 结果
     */
    public int updateAAssets(AAssets aAssets);

    /**
     * 批量删除资产信息
     * 
     * @param ids 需要删除的资产信息主键集合
     * @return 结果
     */
    public int deleteAAssetsByIds(Long[] ids);

    /**
     * 删除资产信息信息
     * 
     * @param id 资产信息主键
     * @return 结果
     */
    public int deleteAAssetsById(Long id);
}
