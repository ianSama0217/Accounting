package com.example.accounting.service;

import com.example.accounting.Vo.BasicRes;
import com.example.accounting.entity.Accounts;

import java.util.List;

public interface AccountsService {
    /*
     * 儲存/更新共用
     */
    public BasicRes<Void> create(Accounts account);

    public BasicRes<Void> delete(int accountId);

    public BasicRes<Accounts> getById(int accountId);

    public BasicRes<List<Accounts>> getByUserId(int userId);
}
