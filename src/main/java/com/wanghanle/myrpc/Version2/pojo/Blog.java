package com.wanghanle.myrpc.Version2.pojo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author WangHanle
 * @version 1.0
 * @date 2021/2/1 22:12
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Blog implements Serializable {
    private Integer id;
    private Integer useId;
    private String title;
}
