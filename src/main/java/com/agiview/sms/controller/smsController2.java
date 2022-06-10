package com.agiview.sms.controller;

import com.agiview.sms.entity.smsRecord;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Controller
public class smsController2 {
    //@Autowired
    private List<smsRecord> smsRecords=new ArrayList<>();
    private int num=0;

    @PostMapping("/send2")
    @ResponseBody
    public boolean send(@RequestParam String phone, @RequestParam String text) {
        num++;
        smsRecord record=new smsRecord();
        Date dNow = new Date( );
        SimpleDateFormat ft = new SimpleDateFormat ("yyyy.MM.dd  HH:mm:ss");
        record.setId(num);
        record.setSendTime(ft.format(dNow));
        record.setPhone(phone);
        record.setText(text);
        if (smsRecords!=null && smsRecords.size()==10){
            smsRecords.remove(0);
        }
        return smsRecords.add(record);
    }

    @GetMapping("/show2")
    public String show(Model model) {
        model.addAttribute("records",smsRecords);
        return "showRecords";
    }
}
