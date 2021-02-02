package com.wanghanle.myrpc.Version3.core;

import lombok.AllArgsConstructor;

/**
 * @author WangHanle
 * @version 1.0
 * @date 2021/2/2 23:53
 */
@AllArgsConstructor
public enum MessageType {
    REQUEST(0),RESPONSE(1);
    private int code;
    public int getCode() {
        return code;
    }
}
