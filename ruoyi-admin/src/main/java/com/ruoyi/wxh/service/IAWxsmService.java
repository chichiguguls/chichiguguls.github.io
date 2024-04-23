package com.ruoyi.wxh.service;

import java.util.List;
import com.ruoyi.wxh.domain.AWxsm;

/**
 * 资产维修Service接口
 * 
 * @author ruoyi
 * @date 2024-02-27
 */
public interface IAWxsmService 
{
    /**
     * 查询资产维修
     * 
     * @param id 资产维修主键
     * @return 资产维修
     */
    public AWxsm selectAWxsmById(Long id);

    /**
     * 查询资产维修列表
     * 
     * @param aWxsm 资产维修
     * @return 资产维修集合
     */
    public List<AWxsm> selectAWxsmList(AWxsm aWxsm);

    /**
     * 新增资产维修
     * 
     * @param aWxsm 资产维修
     * @return 结果
     */
    public int insertAWxsm(AWxsm aWxsm);

    /**
     * 修改资产维修
     * 
     * @param aWxsm 资产维修
     * @return 结果
     */
    public int updateAWxsm(AWxsm aWxsm);

    /**
     * 批量删除资产维修
     * 
     * @param ids 需要删除的资产维修主键集合
     * @return 结果
     */
    public int deleteAWxsmByIds(Long[] ids);

    /**
     * 删除资产维修信息
     * 
     * @param id 资产维修主键
     * @return 结果
     */
    public int deleteAWxsmById(Long id);
}
