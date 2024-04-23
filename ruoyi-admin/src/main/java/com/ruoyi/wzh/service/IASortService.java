package com.ruoyi.wzh.service;

import java.util.List;
import com.ruoyi.wzh.domain.ASort;

/**
 * 资产分类Service接口
 * 
 * @author ruoyi
 * @date 2024-02-27
 */
public interface IASortService 
{
    /**
     * 查询资产分类
     * 
     * @param id 资产分类主键
     * @return 资产分类
     */
    public ASort selectASortById(Long id);

    /**
     * 查询资产分类列表
     * 
     * @param aSort 资产分类
     * @return 资产分类集合
     */
    public List<ASort> selectASortList(ASort aSort);

    /**
     * 新增资产分类
     * 
     * @param aSort 资产分类
     * @return 结果
     */
    public int insertASort(ASort aSort);

    /**
     * 修改资产分类
     * 
     * @param aSort 资产分类
     * @return 结果
     */
    public int updateASort(ASort aSort);

    /**
     * 批量删除资产分类
     * 
     * @param ids 需要删除的资产分类主键集合
     * @return 结果
     */
    public int deleteASortByIds(Long[] ids);

    /**
     * 删除资产分类信息
     * 
     * @param id 资产分类主键
     * @return 结果
     */
    public int deleteASortById(Long id);
}
