package com.wanghanle.myrpc.pojo;

import lombok.*;

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
