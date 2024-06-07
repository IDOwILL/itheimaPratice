package com.itheima.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OprerateLog {
    private Integer id;             // 非必须 id
    private Integer operateEmpId;   // 非必须 操作人ID
    private LocalDate operateTime;          // 非必须 操作时间
    private String className;            // 非必须 类名
    private String methodName;           // 非必须 方法名
    private String methodParams;         // 非必须 方法请求参数
    private String returnValue;          // 非必须 返回值
    private Long costTime;               // 非必须 执行耗时，单位 ms
    private String operateEmpName;       // 非必须 操作人姓名


}
