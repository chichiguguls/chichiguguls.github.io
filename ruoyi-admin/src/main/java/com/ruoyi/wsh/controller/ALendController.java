package com.ruoyi.wsh.controller;

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
import com.ruoyi.wsh.domain.ALend;
import com.ruoyi.wsh.service.IALendService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 资产借出Controller
 * 
 * @author ruoyi
 * @date 2024-02-27
 */
@RestController
@RequestMapping("/wsh/lend")
public class ALendController extends BaseController
{
    @Autowired
    private IALendService aLendService;

    /**
     * 查询资产借出列表
     */
    @PreAuthorize("@ss.hasPermi('wsh:lend:list')")
    @GetMapping("/list")
    public TableDataInfo list(ALend aLend)
    {
        startPage();
        List<ALend> list = aLendService.selectALendList(aLend);
        return getDataTable(list);
    }

    /**
     * 导出资产借出列表
     */
    @PreAuthorize("@ss.hasPermi('wsh:lend:export')")
    @Log(title = "资产借出", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, ALend aLend)
    {
        List<ALend> list = aLendService.selectALendList(aLend);
        ExcelUtil<ALend> util = new ExcelUtil<ALend>(ALend.class);
        util.exportExcel(response, list, "资产借出数据");
    }

    /**
     * 获取资产借出详细信息
     */
    @PreAuthorize("@ss.hasPermi('wsh:lend:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(aLendService.selectALendById(id));
    }

    /**
     * 新增资产借出
     */
    @PreAuthorize("@ss.hasPermi('wsh:lend:add')")
    @Log(title = "资产借出", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody ALend aLend)
    {
        return toAjax(aLendService.insertALend(aLend));
    }

    /**
     * 修改资产借出
     */
    @PreAuthorize("@ss.hasPermi('wsh:lend:edit')")
    @Log(title = "资产借出", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody ALend aLend)
    {
        return toAjax(aLendService.updateALend(aLend));
    }

    /**
     * 删除资产借出
     */
    @PreAuthorize("@ss.hasPermi('wsh:lend:remove')")
    @Log(title = "资产借出", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(aLendService.deleteALendByIds(ids));
    }
}
