package com.example.accounting.Constants;

import lombok.Getter;

@Getter
public enum ReturnMsg {
    /* Basic message */
    SUCCESSFUL(200, "API執行成功"),
    CREATE_SUCCESSFUL(201, "儲存成功"),
    PARAMS_ERROR(400, "參數錯誤"),
    SERVER_ERROR(500, "SERVER錯誤"),
    /* Users */
    /* Accounts */
    ACCOUNT_NOT_FOUND(404, "帳號不存在"),
    /* Categories */
    CATEGORY_NOT_FOUND(404, "記帳類別不存在"),
    /* Records */
    RECORD_NOT_FOUND(404, "記帳明細不存在"),
    ;

    private final int statusCode;

    private final String message;

    private ReturnMsg(int statusCode, String message) {
        this.statusCode = statusCode;
        this.message = message;
    }
}
