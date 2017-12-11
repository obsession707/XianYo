package com.xianyo.microblogmodule.service.implement;

import com.xianyo.microblogmodule.dao.mapper.MicroblogDataMapper;
import com.xianyo.microblogmodule.dao.pojo.MicroblogData;
import com.xianyo.microblogmodule.service.SetBlogService;
import com.xianyo.util.service.IDGeneratorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class SetBlogServiceImp implements SetBlogService {
    @Autowired
    MicroblogDataMapper microblogDataMapper;
    @Autowired
    IDGeneratorService idGeneratorService;

    @Override
    public void SetBlog(MicroblogData data) {
        init(data);
        data.setMicroblogid(BlogIDCreator());
        System.out.println(data);
        microblogDataMapper.insert(data);
    }

    private Long BlogIDCreator() {
        Long randomCreator = idGeneratorService.genetatorForOthers(2);
        long blogid;
        blogid = randomCreator;
        blogid = (blogid > 0) ? blogid : -blogid;
        return blogid;
    }

    private void init(MicroblogData data){
        Date date = new Date();
//        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
//        String nowdate = dateFormat.format(date);
        data.setPublishtime(date);
        data.setReadtime(0);
        data.setPraisetime(0);
        data.setCollecttime(0);
        data.setComplainttime(0);
    }

}
