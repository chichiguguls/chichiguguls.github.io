package com.ruoyi.jsf.mapper;

import java.util.List;
import com.ruoyi.jsf.domain.AGuihuan;

/**
 * 资产归还Mapper接口
 * 
 * @author ruoyi
 * @date 2024-02-27
 */
public interface AGuihuanMapper 
{
    /**
     * 查询资产归还
     * 
     * @param id 资产归还主键
     * @return 资产归还
     */
    public AGuihuan selectAGuihuanById(Long id);

    /**
     * 查询资产归还列表
     * 
     * @param aGuihuan 资产归还
     * @return 资产归还集合
     */
    public List<AGuihuan> selectAGuihuanList(AGuihuan aGuihuan);

    /**
     * 新增资产归还
     * 
     * @param aGuihuan 资产归还
     * @return 结果
     */
    public int insertAGuihuan(AGuihuan aGuihuan);

    /**
     * 修改资产归还
     * 
     * @param aGuihuan 资产归还
     * @return 结果
     */
    public int updateAGuihuan(AGuihuan aGuihuan);

    /**
     * 删除资产归还
     * 
     * @param id 资产归还主键
     * @return 结果
     */
    public int deleteAGuihuanById(Long id);

    /**
     * 批量删除资产归还
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteAGuihuanByIds(Long[] ids);
}
