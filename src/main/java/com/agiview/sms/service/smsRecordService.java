package com.agiview.sms.service;

import com.agiview.sms.entity.smsRecord;

import java.util.List;

public interface smsRecordService {
    int send(smsRecord record);
    List<smsRecord> show();
}
