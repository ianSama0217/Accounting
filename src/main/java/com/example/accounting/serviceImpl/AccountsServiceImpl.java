package com.example.accounting.serviceImpl;

import com.example.accounting.Constants.ReturnMsg;
import com.example.accounting.Vo.BasicRes;
import com.example.accounting.dao.AccountsDao;
import com.example.accounting.entity.Accounts;
import com.example.accounting.service.AccountsService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountsServiceImpl implements AccountsService {
    @Resource
    private AccountsDao accountsDao;

    @Override
    public BasicRes<Void> create(Accounts account) {
        if(account.getName().isEmpty() || account.getUserId() == 0){
           return BasicRes.fail(ReturnMsg.PARAMS_ERROR);
        }

        try{
            accountsDao.save(account);
        } catch (Exception e) {
            System.out.println("儲存帳號發生錯誤: " + e);
            return BasicRes.fail(ReturnMsg.SERVER_ERROR);
        }
        return BasicRes.success(ReturnMsg.CREATE_SUCCESSFUL);
    }

    @Override
    public BasicRes<Void> delete(int accountId) {
        if (!accountsDao.existsById(accountId)) {
            return BasicRes.fail(ReturnMsg.ACCOUNT_NOT_FOUND);
        }

        try{
            accountsDao.deleteById(accountId);
        } catch (Exception e) {
            System.out.println("刪除帳號發生錯誤: " + e);
            return BasicRes.fail(ReturnMsg.SERVER_ERROR);
        }

        return BasicRes.success(ReturnMsg.SUCCESSFUL);
    }

    @Override
    public BasicRes<Accounts> getById(int accountId) {
        return accountsDao.findById(accountId)
                .map(account -> BasicRes.success(ReturnMsg.SUCCESSFUL, account))
                .orElseGet(() -> BasicRes.<Accounts>fail(ReturnMsg.ACCOUNT_NOT_FOUND));
    }

    @Override
    public BasicRes<List<Accounts>> getByUserId(int userId) {
        //TODO 檢查USER是否存在

        List<Accounts> list = accountsDao.findByUserId(userId);

        if (list.isEmpty()) {
            return BasicRes.<List<Accounts>>fail(ReturnMsg.ACCOUNT_NOT_FOUND);
        }

        return BasicRes.success(ReturnMsg.SUCCESSFUL, list);
    }
}
