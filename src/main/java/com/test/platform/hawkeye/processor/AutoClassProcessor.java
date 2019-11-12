package com.test.platform.hawkeye.processor;


import com.httputil.apitest.testcase.TestCaseListener;
import com.test.platform.hawkeye.dao.AutoCaseMapper;
import com.test.platform.hawkeye.domain.general.AutoCase;
import com.test.platform.hawkeye.utils.DateTimeUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import org.testng.annotations.Test;
import spoon.processing.AbstractProcessor;
import spoon.reflect.declaration.CtClass;
import spoon.reflect.declaration.CtMethod;


import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * autocase收集器
 */

@Service
public class AutoClassProcessor extends AbstractProcessor<CtClass> {


    @Autowired
    AutoCaseMapper autoCaseMapper;


    /**
     * 是不是预期方法
     *
     * @param ctMethod
     * @return
     */
    public boolean isExpect(CtMethod ctMethod) {

        if (ctMethod.hasAnnotation( Test.class ) && ctMethod.hasAnnotation( TestCaseListener.class ))
            return true;
        return false;
    }


    @Override
    public void process(CtClass ctClass) {

        List<AutoCase> ctMethodsList = new ArrayList<AutoCase>();

        Set<CtMethod<?>> methodSet = ctClass.getAllMethods();

        for (CtMethod ctMethod :
                methodSet) {
            //符合预期才进行插入
            if (isExpect( ctMethod )) {
                AutoCase autoCase = new AutoCase();
                TestCaseListener testCaseListener = ctMethod.getAnnotation( TestCaseListener.class );

                //set @TestCaseListener内容
                autoCase.setCid( testCaseListener.cid() );
                autoCase.setPath( testCaseListener.path() );
                autoCase.setLevel( testCaseListener.level() );
                autoCase.setAuthor( testCaseListener.author() );
                autoCase.setDescription( testCaseListener.description() );

                //方法名
                autoCase.setName( ctMethod.getSimpleName() );

                //case内容
                autoCase.setContent( ctMethod.getBody().toString() );

                //关联项目id
                autoCase.setProjectId( 1 );


                //创建时间
                autoCase.setCreateTime( DateTimeUtil.getCurrentDateTIme() );


                ctMethodsList.add( autoCase );
            } else
                continue;

        }

        //不用insert list方式，在逻辑层进行日志收集，记录插入失败项

        for (AutoCase autoCase :
                ctMethodsList) {
            autoCaseMapper.insert( autoCase );
        }

    }


}
