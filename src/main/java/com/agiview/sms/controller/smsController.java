package com.agiview.sms.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Random;

import com.agiview.sms.entity.smsRecord;
import com.agiview.sms.service.smsRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller

public class smsController {
    @Autowired
    private smsRecordService smsRecordService;

    @PostMapping("/send")
    @ResponseBody
    public int send(@RequestParam String phone, @RequestParam String text) {
        smsRecord record=new smsRecord();
        Date dNow = new Date( );
        SimpleDateFormat ft = new SimpleDateFormat ("yyyy.MM.dd  HH:mm:ss");
        record.setSendTime(ft.format(dNow));
        record.setPhone(phone);
        record.setText(text);
        return smsRecordService.send(record);
    }

    @GetMapping("/show")
    public String show(Model model) {
        List<smsRecord> records = smsRecordService.show();
        model.addAttribute("records",records);
        return "showRecords";
    }
}
