package com.example.accounting.serviceImpl;

import com.example.accounting.Constants.ReturnMsg;
import com.example.accounting.Vo.BasicRes;
import com.example.accounting.dao.CategoriesDao;
import com.example.accounting.entity.Accounts;
import com.example.accounting.entity.Categories;
import com.example.accounting.service.CategoriesService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoriesServiceImpl implements CategoriesService {
    @Resource
    private CategoriesDao categoriesDao;

    @Override
    public BasicRes<Void> create(Categories categories) {
        boolean isUpdate = false;

        if(categories.getName().isEmpty() || categories.getUserId() == 0
         || (categories.getType() != 0 && categories.getType() != 1)){
            return BasicRes.fail(ReturnMsg.PARAMS_ERROR);
        }

        if(categories.getId() != 0) isUpdate = true;

        try{
            categoriesDao.save(categories);
        } catch (Exception e) {
            System.out.println("儲存記帳類別發生錯誤: " + e);
            return BasicRes.fail(ReturnMsg.SERVER_ERROR);
        }

        return isUpdate ? BasicRes.success(ReturnMsg.SUCCESSFUL) : BasicRes.success(ReturnMsg.CREATE_SUCCESSFUL);
    }

    @Override
    public BasicRes<Void> delete(int categoryId) {
        if (!categoriesDao.existsById(categoryId)) {
            return BasicRes.fail(ReturnMsg.CATEGORY_NOT_FOUND);
        }

        try{
            categoriesDao.deleteById(categoryId);
        } catch (Exception e) {
            System.out.println("刪除記帳類別發生錯誤: " + e);
            return BasicRes.fail(ReturnMsg.SERVER_ERROR);
        }

        return BasicRes.success(ReturnMsg.SUCCESSFUL);
    }

    @Override
    public BasicRes<List<Categories>> getByUserId(int userId) {
        //TODO 檢查USER是否存在

        List<Categories> list = categoriesDao.findByUserId(userId);

        if (list.isEmpty()) {
            return BasicRes.<List<Categories>>fail(ReturnMsg.CATEGORY_NOT_FOUND);
        }

        return BasicRes.success(ReturnMsg.SUCCESSFUL, list);
    }
}
