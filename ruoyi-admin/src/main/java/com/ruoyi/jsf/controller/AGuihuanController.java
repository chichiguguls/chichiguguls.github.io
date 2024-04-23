package com.ruoyi.jsf.controller;

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
import com.ruoyi.jsf.domain.AGuihuan;
import com.ruoyi.jsf.service.IAGuihuanService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 资产归还Controller
 * 
 * @author ruoyi
 * @date 2024-02-27
 */
@RestController
@RequestMapping("/jsf/guihuan")
public class AGuihuanController extends BaseController
{
    @Autowired
    private IAGuihuanService aGuihuanService;

    /**
     * 查询资产归还列表
     */
    @PreAuthorize("@ss.hasPermi('jsf:guihuan:list')")
    @GetMapping("/list")
    public TableDataInfo list(AGuihuan aGuihuan)
    {
        startPage();
        List<AGuihuan> list = aGuihuanService.selectAGuihuanList(aGuihuan);
        return getDataTable(list);
    }

    /**
     * 导出资产归还列表
     */
    @PreAuthorize("@ss.hasPermi('jsf:guihuan:export')")
    @Log(title = "资产归还", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, AGuihuan aGuihuan)
    {
        List<AGuihuan> list = aGuihuanService.selectAGuihuanList(aGuihuan);
        ExcelUtil<AGuihuan> util = new ExcelUtil<AGuihuan>(AGuihuan.class);
        util.exportExcel(response, list, "资产归还数据");
    }

    /**
     * 获取资产归还详细信息
     */
    @PreAuthorize("@ss.hasPermi('jsf:guihuan:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(aGuihuanService.selectAGuihuanById(id));
    }

    /**
     * 新增资产归还
     */
    @PreAuthorize("@ss.hasPermi('jsf:guihuan:add')")
    @Log(title = "资产归还", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody AGuihuan aGuihuan)
    {
        return toAjax(aGuihuanService.insertAGuihuan(aGuihuan));
    }

    /**
     * 修改资产归还
     */
    @PreAuthorize("@ss.hasPermi('jsf:guihuan:edit')")
    @Log(title = "资产归还", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody AGuihuan aGuihuan)
    {
        return toAjax(aGuihuanService.updateAGuihuan(aGuihuan));
    }

    /**
     * 删除资产归还
     */
    @PreAuthorize("@ss.hasPermi('jsf:guihuan:remove')")
    @Log(title = "资产归还", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(aGuihuanService.deleteAGuihuanByIds(ids));
    }
}
