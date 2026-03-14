package com.example.accounting.service;

import com.example.accounting.Vo.BasicRes;
import com.example.accounting.entity.Category;

import java.util.List;

public interface CategoryService {
    /*
     * 儲存/更新共用
     */
    public BasicRes<Void> create(Category categories);

    public BasicRes<Void> delete(int categoryId);

    public BasicRes<List<Category>> getByUserId(int userId);
}
