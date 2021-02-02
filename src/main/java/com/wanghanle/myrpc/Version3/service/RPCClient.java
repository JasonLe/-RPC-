package com.wanghanle.myrpc.Version3.service;

import com.wanghanle.myrpc.Version3.pojo.RPCRequest;
import com.wanghanle.myrpc.Version3.pojo.RPCResponse;

/**
 * @author WangHanle
 * @version 1.0
 * @date 2021/2/2 14:45
 */
public interface RPCClient {
    RPCResponse sendRequest(RPCRequest request);
}
