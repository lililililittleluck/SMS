package com.agiview.sms.service;

import com.agiview.sms.entity.smsRecord;
import com.agiview.sms.mapper.smsRecordMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class smsRecordServiceImpl implements smsRecordService {
    @Autowired
    private smsRecordMapper smsRecordMapper;

    @Override
    public int send(smsRecord record) {
        return smsRecordMapper.insertRecord(record);
    }

    @Override
    public List<smsRecord> show() {
        List<smsRecord> records = smsRecordMapper.show();
        int len=records.size();
        for (smsRecord record : records) {
            record.setId(len--);
        }
        Collections.reverse(records);
        return records;
    }
}
