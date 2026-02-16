package com.example.accounting.Vo;


import com.example.accounting.Constants.ReturnMsg;
import lombok.Getter;

@Getter
public class BasicRes<T> {
    private final ReturnMsg returnMsg;
    private final T data;

    private BasicRes(ReturnMsg returnMsg, T data) {
        this.returnMsg = returnMsg;
        this.data = data;
    }

    // ===== 成功,有資料 =====
    public static <T> BasicRes<T> success(ReturnMsg returnMsg, T data) {
        return new BasicRes<>(returnMsg, data);
    }

    // ===== 成功,無資料 =====
    public static <T> BasicRes<T> success(ReturnMsg returnMsg) {
        return new BasicRes<>(returnMsg, null);
    }

    // ===== 失敗 =====
    public static <T> BasicRes<T> fail(ReturnMsg returnMsg) {
        return new BasicRes<>(returnMsg, null);
    }
}
