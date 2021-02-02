package com.wanghanle.myrpc.Version1.pojo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author WangHanle
 * @version 1.0
 * @date 2021/2/1 23:58
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Book implements Serializable {
    private int id;
    private String bookName;
}
