package com.jt.controller;

import com.jt.pojo.ItemCat;
import com.jt.service.ItemCatService;
import com.jt.vo.SysResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/itemCat")
public class ItemCatController {

    @Autowired
    private ItemCatService itemCatService;


    /*
     * 查询3级分类数据的信息
     * URL
     * 返回值：
     *
     * */
    @GetMapping("/findItemCatList/{level}")
    public SysResult findItemCatList(@PathVariable Integer level) {
        List<ItemCat> list = itemCatService.findItemCatList(level);
        return SysResult.success(list);
    }

    /*
     * 实现商品分类的新增的操作
     * URL:/itemCat/saveItemCat
     * 参数:   this.itemCatForm  JSON
     * 返回值：SysResult对象
     *
     * */
    @PostMapping("/saveItemCat")
    public SysResult saveItemCat(@RequestBody ItemCat itemCat) {
        itemCatService.saveItemCat(itemCat);
        return SysResult.success();


    }

    /*
     * 实现商品分类删除的操作
     * URL:/itemCat/deleteItemCat?id=xx&
     * 参数:id/level
     * 返回值sysResult
     * */
    @DeleteMapping("/deleteItemCat")
    public SysResult deleteItemCat(ItemCat itemCat) {
        itemCatService.deleteItemCat(itemCat);
        return SysResult.success();
    }

    /*
     * 需求:修改状态
     * URL:/itemCat/status/{id}/{status}
     * 参数：id/status
     * 返回值：SysResult
     *
     * */
    @PutMapping("/status/{id}/{status}")
    public SysResult updateStatus(ItemCat itemCat) {

        itemCatService.updateStatus(itemCat);
        return SysResult.success();
    }

    /*
     * 需求：
     * 修改 商品分类的信息
     * URL:/itemCat/updateItemCat
     * 参数:表单数据ITEMCat对象
     * 返回值SysResult对象
     * */
    @PutMapping("/updateItemCat")
    public SysResult updateItemCat(@RequestBody ItemCat itemCat){

        itemCatService.updateItemCat(itemCat);
        return SysResult.success();
    }



}
