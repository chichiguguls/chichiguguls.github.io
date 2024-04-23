package com.ruoyi.wxh.controller;

import java.util.List;
import javax.servlet.http.HttpServletResponse;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.wxh.domain.AWxsm;
import com.ruoyi.wxh.service.IAWxsmService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 资产维修Controller
 * 
 * @author ruoyi
 * @date 2024-02-27
 */
@RestController
@RequestMapping("/wxh/wxsm")
public class AWxsmController extends BaseController
{
    @Autowired
    private IAWxsmService aWxsmService;

    /**
     * 查询资产维修列表
     */
    @PreAuthorize("@ss.hasPermi('wxh:wxsm:list')")
    @GetMapping("/list")
    public TableDataInfo list(AWxsm aWxsm)
    {
        startPage();
        List<AWxsm> list = aWxsmService.selectAWxsmList(aWxsm);
        return getDataTable(list);
    }

    /**
     * 导出资产维修列表
     */
    @PreAuthorize("@ss.hasPermi('wxh:wxsm:export')")
    @Log(title = "资产维修", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, AWxsm aWxsm)
    {
        List<AWxsm> list = aWxsmService.selectAWxsmList(aWxsm);
        ExcelUtil<AWxsm> util = new ExcelUtil<AWxsm>(AWxsm.class);
        util.exportExcel(response, list, "资产维修数据");
    }

    /**
     * 获取资产维修详细信息
     */
    @PreAuthorize("@ss.hasPermi('wxh:wxsm:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(aWxsmService.selectAWxsmById(id));
    }

    /**
     * 新增资产维修
     */
    @PreAuthorize("@ss.hasPermi('wxh:wxsm:add')")
    @Log(title = "资产维修", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody AWxsm aWxsm)
    {
        return toAjax(aWxsmService.insertAWxsm(aWxsm));
    }

    /**
     * 修改资产维修
     */
    @PreAuthorize("@ss.hasPermi('wxh:wxsm:edit')")
    @Log(title = "资产维修", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody AWxsm aWxsm)
    {
        return toAjax(aWxsmService.updateAWxsm(aWxsm));
    }

    /**
     * 删除资产维修
     */
    @PreAuthorize("@ss.hasPermi('wxh:wxsm:remove')")
    @Log(title = "资产维修", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(aWxsmService.deleteAWxsmByIds(ids));
    }
}
