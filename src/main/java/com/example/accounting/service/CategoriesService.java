package com.example.accounting.service;

import com.example.accounting.Vo.BasicRes;
import com.example.accounting.entity.Accounts;
import com.example.accounting.entity.Categories;

import java.util.List;

public interface CategoriesService {
    /*
     * 儲存/更新共用
     */
    public BasicRes<Void> create(Categories categories);

    public BasicRes<Void> delete(int categoryId);

    public BasicRes<List<Categories>> getByUserId(int userId);
}
