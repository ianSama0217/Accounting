package com.example.accounting.serviceImpl;

import com.example.accounting.Constants.ReturnMsg;
import com.example.accounting.Vo.BasicRes;
import com.example.accounting.dao.RecordDao;
import com.example.accounting.entity.Record;
import com.example.accounting.service.RecordService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class RecordServiceImpl implements RecordService {
    @Resource
    private RecordDao recordsDao;

    @Override
    public BasicRes<Void> create(Record record) {
        boolean isUpdate = false;

        if(record.getUserId() == 0 || record.getAccountId() == 0 || record.getCategoryId() == 0
                || record.getAmount() < 0 || record.getRecordDate() == null
                || (record.getType() != 0 && record.getType() != 1)){
            return BasicRes.fail(ReturnMsg.PARAMS_ERROR);
        }

        if(record.getId() != 0) isUpdate = true;

        try{
            record.setCreateAt(LocalDateTime.now()); // 設定創建明細時間
            recordsDao.save(record);
        } catch (Exception e) {
            System.out.println("儲存記帳明細發生錯誤: " + e);
            return BasicRes.fail(ReturnMsg.SERVER_ERROR);
        }

        return isUpdate ? BasicRes.success(ReturnMsg.SUCCESSFUL) : BasicRes.success(ReturnMsg.CREATE_SUCCESSFUL);
    }

    @Override
    public BasicRes<Void> delete(int recordId) {
        if (!recordsDao.existsById(recordId)) {
            return BasicRes.fail(ReturnMsg.RECORD_NOT_FOUND);
        }

        try{
            recordsDao.deleteById(recordId);
        } catch (Exception e) {
            System.out.println("刪除記帳明細發生錯誤: " + e);
            return BasicRes.fail(ReturnMsg.SERVER_ERROR);
        }

        return BasicRes.success(ReturnMsg.SUCCESSFUL);
    }

    @Override
    public BasicRes<Record> getById(int recordId) {
        return recordsDao.findById(recordId)
                .map(record -> BasicRes.success(ReturnMsg.SUCCESSFUL, record))
                .orElseGet(() -> BasicRes.<Record>fail(ReturnMsg.RECORD_NOT_FOUND));
    }

    @Override
    public BasicRes<List<Record>> getByUserId(int userId) {
        //TODO 檢查USER是否存在

        List<Record> list = recordsDao.findByUserId(userId);

        if (list.isEmpty()) {
            return BasicRes.<List<Record>>fail(ReturnMsg.RECORD_NOT_FOUND);
        }

        return BasicRes.success(ReturnMsg.SUCCESSFUL, list);
    }

    @Override
    public BasicRes<List<Record>> getByAccountId(int accountId) {
        //TODO 檢查ACCOUNT是否存在

        List<Record> list = recordsDao.findByAccountId(accountId);

        if (list.isEmpty()) {
            return BasicRes.<List<Record>>fail(ReturnMsg.RECORD_NOT_FOUND);
        }

        return BasicRes.success(ReturnMsg.SUCCESSFUL, list);
    }

    @Override
    public BasicRes<List<Record>> getByCategoryId(int categoryId) {
        //TODO 檢查category是否存在

        List<Record> list = recordsDao.findByCategoryId(categoryId);

        if (list.isEmpty()) {
            return BasicRes.<List<Record>>fail(ReturnMsg.RECORD_NOT_FOUND);
        }

        return BasicRes.success(ReturnMsg.SUCCESSFUL, list);
    }
}
