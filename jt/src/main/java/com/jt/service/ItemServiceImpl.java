package com.jt.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.jt.mapper.ItemDescMapper;
import com.jt.mapper.ItemMapper;
import com.jt.pojo.Item;
import com.jt.pojo.ItemDesc;
import com.jt.vo.ItemVO;
import com.jt.vo.PageResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import java.util.List;

@Service
public class ItemServiceImpl implements ItemService {







    @Autowired
    private ItemMapper itemMapper;
    @Autowired
    private ItemDescMapper itemDescMapper;

    @Override
    @Transactional
    public PageResult getItemList(PageResult pageResult) {
        //总数
        //分页结果
        QueryWrapper queryWrapper = new QueryWrapper();
        //判断用户的数据是否有值
        boolean flag = StringUtils.hasLength(pageResult.getQuery());
        queryWrapper.like(flag, "title", pageResult.getQuery());
        //编辑Mp的分页对象
        IPage<Item> page = new Page<>(pageResult.getPageNum(), pageResult.getPageSize());
        itemMapper.selectPage(page, queryWrapper);
        //获取总数
        long total = page.getTotal();
        //获取记录数
        List<Item> rows = page.getRecords();
        return pageResult.setTotal(total).setRows(rows);


    }

    @Override
    public void saveItem(ItemVO itemVO) {
        Item item = itemVO.getItem();
        item.setStatus(true);
        //要求item入库之后，动态返回id
        //MP的原则：入库之后动态的回显数据!!!
        itemMapper.insert(item);
        //实现itemDesc对象的入库
        ItemDesc itemDesc = itemVO.getItemDesc();
        itemDesc.setId(item.getId());
        itemDescMapper.insert(itemDesc);

    }

}
