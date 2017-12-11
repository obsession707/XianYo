package com.xianyo.util.service.implement;

import com.xianyo.util.service.IDGeneratorService;
import org.springframework.stereotype.Service;

@Service
public class IDGenerationImpl implements IDGeneratorService {
    @Override
    public long genetatorForOthers(int flag) {
        long idhead = 0;
        //  [0,1)--random()
        if (flag ==1 ){//user
            idhead =(1+ (int) (Math.random()*10))*1000000000;//01-09+*********
        }else if (flag ==2){//blog
            idhead = (10+(int) (Math.random()*10))*1000000000;//10-19+*********
        }else if (flag ==3){//question
            idhead = (20+(int) (Math.random()*10))*1000000000;//20-29+*********
        }else if (flag ==4){//answer
            idhead = (30+(int) (Math.random()*10))*1000000000;//30-39+*********
        }else if (flag ==5){//travelnote
            idhead = (40+(int) (Math.random()*10))*1000000000;//40-49+*********
        }else if (flag ==6){//scenic
            idhead = (50+(int) (Math.random()*10))*1000000000;//50-59+*********
        }else if (flag == 7){//feedback
            idhead = (60+(int) (Math.random()*10))*1000000000;//50-59+*********
        }else if (flag==8){//report
            idhead = (70+(int) (Math.random()*10))*1000000000;//50-59+*********
        }
        long idend =1+ (int) (Math.random() * 1000000000);
        return idhead+idend;
    }

    @Override
    public int generatorForAdmin() {
        return 1+ (int) (Math.random() * 100);
    }
}
