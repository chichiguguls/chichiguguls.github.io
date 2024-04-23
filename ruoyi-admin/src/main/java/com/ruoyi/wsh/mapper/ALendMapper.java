package com.ruoyi.wsh.mapper;

import java.util.List;
import com.ruoyi.wsh.domain.ALend;

/**
 * 资产借出Mapper接口
 * 
 * @author ruoyi
 * @date 2024-02-27
 */
public interface ALendMapper 
{
    /**
     * 查询资产借出
     * 
     * @param id 资产借出主键
     * @return 资产借出
     */
    public ALend selectALendById(Long id);

    /**
     * 查询资产借出列表
     * 
     * @param aLend 资产借出
     * @return 资产借出集合
     */
    public List<ALend> selectALendList(ALend aLend);

    /**
     * 新增资产借出
     * 
     * @param aLend 资产借出
     * @return 结果
     */
    public int insertALend(ALend aLend);

    /**
     * 修改资产借出
     * 
     * @param aLend 资产借出
     * @return 结果
     */
    public int updateALend(ALend aLend);

    /**
     * 删除资产借出
     * 
     * @param id 资产借出主键
     * @return 结果
     */
    public int deleteALendById(Long id);

    /**
     * 批量删除资产借出
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteALendByIds(Long[] ids);
}
