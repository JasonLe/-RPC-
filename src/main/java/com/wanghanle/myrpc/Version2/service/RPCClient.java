package com.wanghanle.myrpc.Version2.service;

import com.wanghanle.myrpc.Version2.pojo.RPCRequest;
import com.wanghanle.myrpc.Version2.pojo.RPCResponse;

/**
 * @author WangHanle
 * @version 1.0
 * @date 2021/2/2 14:45
 */
public interface RPCClient {
    RPCResponse sendRequest(RPCRequest request);
}
