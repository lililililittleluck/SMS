package com.agiview.sms.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.text.SimpleDateFormat;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class smsRecord {
    private int id;
    private String sendTime;
    private String phone;
    private String text;
}
