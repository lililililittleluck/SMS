package com.agiview.sms.mapper;

import com.agiview.sms.entity.smsRecord;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import java.util.List;

@Mapper
public interface smsRecordMapper {
    @Insert("insert into record(sendTime,phone,text) values (#{sendTime},#{phone},#{text})")
    int insertRecord(smsRecord record);

    @Select("select * from record order by id desc limit 10")
    List<smsRecord> show();
}
