package com.example.accounting.service;

import com.example.accounting.Vo.BasicRes;
import com.example.accounting.entity.Account;

import java.util.List;

public interface AccountService {
    /*
     * 儲存/更新共用
     */
    public BasicRes<Void> create(Account account);

    public BasicRes<Void> delete(int accountId);

    public BasicRes<Account> getById(int accountId);

    public BasicRes<List<Account>> getByUserId(int userId);
}
