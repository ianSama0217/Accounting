package com.example.accounting.service;

import com.example.accounting.Vo.BasicRes;
import com.example.accounting.entity.Record;

import java.util.List;

public interface RecordService {
    /*
     * 儲存/更新共用
     */
    public BasicRes<Void> create(Record record);

    public BasicRes<Void> delete(int recordId);

    public BasicRes<Record> getById(int recordId);

    public BasicRes<List<Record>> getByUserId(int userId);

    public BasicRes<List<Record>> getByAccountId(int accountId);

    public BasicRes<List<Record>> getByCategoryId(int categoryId);
}
