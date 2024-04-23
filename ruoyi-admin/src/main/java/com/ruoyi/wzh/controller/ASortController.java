package com.ruoyi.wzh.controller;

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
import com.ruoyi.wzh.domain.ASort;
import com.ruoyi.wzh.service.IASortService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 资产分类Controller
 * 
 * @author ruoyi
 * @date 2024-02-27
 */
@RestController
@RequestMapping("/wzh/sort")
public class ASortController extends BaseController
{
    @Autowired
    private IASortService aSortService;

    /**
     * 查询资产分类列表
     */
    @PreAuthorize("@ss.hasPermi('wzh:sort:list')")
    @GetMapping("/list")
    public TableDataInfo list(ASort aSort)
    {
        startPage();
        List<ASort> list = aSortService.selectASortList(aSort);
        return getDataTable(list);
    }

    /**
     * 导出资产分类列表
     */
    @PreAuthorize("@ss.hasPermi('wzh:sort:export')")
    @Log(title = "资产分类", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, ASort aSort)
    {
        List<ASort> list = aSortService.selectASortList(aSort);
        ExcelUtil<ASort> util = new ExcelUtil<ASort>(ASort.class);
        util.exportExcel(response, list, "资产分类数据");
    }

    /**
     * 获取资产分类详细信息
     */
    @PreAuthorize("@ss.hasPermi('wzh:sort:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(aSortService.selectASortById(id));
    }

    /**
     * 新增资产分类
     */
    @PreAuthorize("@ss.hasPermi('wzh:sort:add')")
    @Log(title = "资产分类", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody ASort aSort)
    {
        return toAjax(aSortService.insertASort(aSort));
    }

    /**
     * 修改资产分类
     */
    @PreAuthorize("@ss.hasPermi('wzh:sort:edit')")
    @Log(title = "资产分类", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody ASort aSort)
    {
        return toAjax(aSortService.updateASort(aSort));
    }

    /**
     * 删除资产分类
     */
    @PreAuthorize("@ss.hasPermi('wzh:sort:remove')")
    @Log(title = "资产分类", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(aSortService.deleteASortByIds(ids));
    }
}
