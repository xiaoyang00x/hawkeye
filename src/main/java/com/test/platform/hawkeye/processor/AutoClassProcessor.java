package com.test.platform.hawkeye.processor;


import com.httputil.apitest.testcase.TestCaseListener;
import com.test.platform.hawkeye.controller.testHttpInterface;
import com.test.platform.hawkeye.dao.AutoCaseMapper;
import com.test.platform.hawkeye.domain.general.AutoCase;
import com.test.platform.hawkeye.domain.general.AutoCaseExample;
import com.test.platform.hawkeye.service.AutoCaseService;
import com.test.platform.hawkeye.utils.DateTimeUtil;
import org.apache.ibatis.jdbc.SQL;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import org.springframework.transaction.annotation.Transactional;
import org.testng.annotations.Test;
import spoon.SpoonException;
import spoon.processing.AbstractProcessor;
import spoon.processing.ProcessorProperties;
import spoon.reflect.declaration.CtClass;
import spoon.reflect.declaration.CtMethod;


import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * autocase收集器
 */


@Service
@Transactional
public class AutoClassProcessor extends AbstractProcessor<CtClass> {

    protected static final Logger logger = LoggerFactory.getLogger( AutoClassProcessor.class );


    @Autowired
    AutoCaseMapper autoCaseMapper;

    @Autowired
    AutoCaseService autoCaseService;

    private Integer projectId;

    private Integer type;


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
                autoCase.setName( ctClass.getSimpleName() + "." + ctMethod.getSimpleName() );

                //关联项目id
                autoCase.setProjectId( this.projectId );

                //创建时间
                autoCase.setCreateTime( DateTimeUtil.getCurrentDateTIme() );
                try {
                    //书写不规范 SpoonException
                    autoCase.setContent( ctMethod.getBody().toString() );
                    ctMethodsList.add( autoCase );
                } catch (SpoonException e) {
                    ctMethodsList.add( autoCase );
                    e.printStackTrace();
                } catch (Exception e) {
                    System.out.println( "Exception" );
                    e.printStackTrace();
                    continue;
                }
            } else
                continue;
        }

        //不用insert list方式，在逻辑层进行日志收集，记录插入失败项  //增量

        for (AutoCase autoCase :
                ctMethodsList) {
            if (type == 0) {
                AutoCaseExample autoCaseExample = new AutoCaseExample();
                autoCaseExample.createCriteria().andCidEqualTo( autoCase.getCid() ).
                        andPathEqualTo( autoCase.getPath() ).
                        andNameEqualTo( autoCase.getName() ).
                        andProjectIdEqualTo( autoCase.getProjectId() ).
                        andIsDeleteEqualTo( (byte) 0 );
                long count = autoCaseMapper.countByExample( autoCaseExample );
                if (count > 0)
                    System.out.println( autoCase.toString() + "已经存在,不插入" );
                else
                    autoCaseMapper.insert( autoCase );
            } else {
                autoCaseMapper.insert( autoCase );

            }

        }

    }


    public AutoCaseMapper getAutoCaseMapper() {
        return autoCaseMapper;
    }

    public void setAutoCaseMapper(AutoCaseMapper autoCaseMapper) {
        this.autoCaseMapper = autoCaseMapper;
    }

    public Integer getProjectId() {
        return projectId;
    }

    public void setProjectId(Integer projectId) {
        this.projectId = projectId;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

}
