package com.example.accounting.service;

import com.example.accounting.Vo.BasicRes;
import com.example.accounting.entity.Categories;
import com.example.accounting.entity.Records;

import java.util.List;

public interface RecordsService {
    /*
     * 儲存/更新共用
     */
    public BasicRes<Void> create(Records record);

    public BasicRes<Void> delete(int recordId);

    public BasicRes<Records> getById(int recordId);

    public BasicRes<List<Records>> getByUserId(int userId);

    public BasicRes<List<Records>> getByAccountId(int accountId);

    public BasicRes<List<Records>> getByCategoryId(int categoryId);
}
