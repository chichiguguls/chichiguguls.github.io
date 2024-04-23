package com.ruoyi.jyf.controller;

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
import com.ruoyi.jyf.domain.AAssets;
import com.ruoyi.jyf.service.IAAssetsService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 资产信息Controller
 * 
 * @author ruoyi
 * @date 2024-02-27
 */
@RestController
@RequestMapping("/jyf/assets")
public class AAssetsController extends BaseController
{
    @Autowired
    private IAAssetsService aAssetsService;

    /**
     * 查询资产信息列表
     */
    @PreAuthorize("@ss.hasPermi('jyf:assets:list')")
    @GetMapping("/list")
    public TableDataInfo list(AAssets aAssets)
    {
        startPage();
        List<AAssets> list = aAssetsService.selectAAssetsList(aAssets);
        return getDataTable(list);
    }

    /**
     * 导出资产信息列表
     */
    @PreAuthorize("@ss.hasPermi('jyf:assets:export')")
    @Log(title = "资产信息", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, AAssets aAssets)
    {
        List<AAssets> list = aAssetsService.selectAAssetsList(aAssets);
        ExcelUtil<AAssets> util = new ExcelUtil<AAssets>(AAssets.class);
        util.exportExcel(response, list, "资产信息数据");
    }

    /**
     * 获取资产信息详细信息
     */
    @PreAuthorize("@ss.hasPermi('jyf:assets:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(aAssetsService.selectAAssetsById(id));
    }

    /**
     * 新增资产信息
     */
    @PreAuthorize("@ss.hasPermi('jyf:assets:add')")
    @Log(title = "资产信息", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody AAssets aAssets)
    {
        return toAjax(aAssetsService.insertAAssets(aAssets));
    }

    /**
     * 修改资产信息
     */
    @PreAuthorize("@ss.hasPermi('jyf:assets:edit')")
    @Log(title = "资产信息", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody AAssets aAssets)
    {
        return toAjax(aAssetsService.updateAAssets(aAssets));
    }

    /**
     * 删除资产信息
     */
    @PreAuthorize("@ss.hasPermi('jyf:assets:remove')")
    @Log(title = "资产信息", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(aAssetsService.deleteAAssetsByIds(ids));
    }
}
