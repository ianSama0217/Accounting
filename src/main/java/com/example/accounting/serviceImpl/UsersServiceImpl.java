package com.example.accounting.serviceImpl;

import com.example.accounting.Constants.ReturnMsg;
import com.example.accounting.Vo.BasicRes;
import com.example.accounting.Vo.LoginReq;
import com.example.accounting.Vo.UserRes;
import com.example.accounting.dao.UsersDao;
import com.example.accounting.entity.Users;
import com.example.accounting.service.UsersService;
import jakarta.annotation.Resource;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class UsersServiceImpl implements UsersService {
    @Resource
    private UsersDao usersDao;

    @Resource
    private PasswordEncoder passwordEncoder;

    @Override
    public BasicRes<Void> register(Users user) {
        if(!checkParams(user.getUsername(), user.getPassword())){
            return BasicRes.fail(ReturnMsg.PARAMS_ERROR);
        }

        if(usersDao.existsByUsername(user.getUsername())){
            return BasicRes.fail(ReturnMsg.USERNAME_IS_EXISTED);
        }

        //  檢查密碼格式(8~16字符, 必須有英數字)
        String passwordPattern = "^(?=.*[A-Za-z])(?=.*\\d)[A-Za-z\\d]{8,16}$";
        if(!user.getPassword().matches(passwordPattern)){
            return BasicRes.fail(ReturnMsg.PASSWORD_PATTERN_ERROR);
        }

        // 密碼加密
        user.setPassword(passwordEncoder.encode(user.getPassword()));

        try{
            user.setCreateAt(LocalDateTime.now());
            usersDao.save(user);
        } catch (Exception e) {
            System.out.println("註冊發生錯誤: " + e);
            return BasicRes.fail(ReturnMsg.SERVER_ERROR);
        }
        return BasicRes.success(ReturnMsg.CREATE_SUCCESSFUL);
    }

    @Override
    public BasicRes<Void> login(LoginReq req) {
        if(!checkParams(req.getUsername(), req.getPassword())){
            return BasicRes.fail(ReturnMsg.PARAMS_ERROR);
        }

        // 檢查username是否存在
        Users user = usersDao.findByUsername(req.getUsername());
        if(user == null){
            return BasicRes.fail(ReturnMsg.USER_NOT_FOUND);
        }

        // 比對密碼是否正確
        if(!passwordEncoder.matches(req.getPassword(), user.getPassword())){
            return BasicRes.fail(ReturnMsg.PASSWORD_ERROR);
        }

        return BasicRes.success(ReturnMsg.SUCCESSFUL);
    }

    @Override
    public BasicRes<UserRes> getById(int userId) {
        return usersDao.findById(userId)
                .map(user -> {
                        UserRes res = new UserRes(user);
                        return BasicRes.success(ReturnMsg.SUCCESSFUL, res);}
                )
                .orElseGet(() -> BasicRes.<UserRes>fail(ReturnMsg.USER_NOT_FOUND));
    }

    private boolean checkParams(String username, String password){
        return username != null && password != null
                && !username.isBlank()
                && !password.isBlank();
    }
}
