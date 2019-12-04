package com.test.platform.hawkeye.processor;

import com.test.platform.hawkeye.dao.InterfaceMapper;
import com.test.platform.hawkeye.domain.general.Interface;
import com.test.platform.hawkeye.domain.general.InterfaceExample;
import com.test.platform.hawkeye.service.InterfaceService;
import com.test.platform.hawkeye.service.UserService;
import com.test.platform.hawkeye.utils.DateTimeUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import spoon.processing.AbstractProcessor;
import spoon.reflect.declaration.CtAnnotation;
import spoon.reflect.declaration.CtClass;
import spoon.reflect.declaration.CtElement;
import spoon.reflect.declaration.CtMethod;

import java.lang.annotation.Annotation;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;


/**
 * http收集器
 */

@Service
@Transactional
public class HttpClassProcessor extends AbstractProcessor<CtClass> {


    protected static final Logger logger = LoggerFactory.getLogger( HttpClassProcessor.class );


    @Autowired
    InterfaceService interfaceService;

    private Integer projectId;

    private Integer type;


    @Override
    public boolean isToBeProcessed(CtClass candidate) {
        boolean flag = false;
        List<CtAnnotation<? extends Annotation>> list = candidate.getAnnotations();
        for (CtAnnotation ctAnnotation : list) {
            CtElement ctElement = ctAnnotation.getAnnotatedElement();
            if (ctElement.hasAnnotation( RequestMapping.class ) || ctElement.hasAnnotation( Controller.class ) || ctElement.hasAnnotation( RestController.class ))
                flag = true;
        }
        return flag;
    }

    @Override
    public void process(CtClass ctClass) {


        List<Interface> interfaceList = new ArrayList<Interface>();
        String classAnnotation = "";
        List<CtAnnotation<? extends Annotation>> list = ctClass.getAnnotations();
        for (CtAnnotation ctAnnotation : list) {
            if (ctAnnotation.getAnnotationType().getSimpleName().equals( RequestMapping.class.getSimpleName() )) {
                classAnnotation = ctAnnotation.getAllValues().get( "value" ).toString().replace( "\"", "" );
            }

        }


        Set<CtMethod<?>> ctMethodsSet = ctClass.getAllMethods();
        for (CtMethod<?> set :
                ctMethodsSet) {
            Interface in = new Interface();

            if (set.getAnnotation( RequestMapping.class ) != null) {

                if (!StringUtils.isEmpty( set.getAnnotation( RequestMapping.class ).method() ) && set.getAnnotation( RequestMapping.class ).method().length > 0) {


                    //set requestType
                    int requestType;
                    switch (set.getAnnotation( RequestMapping.class ).method()[0].toString()) {
                        case "GET":
                            requestType = 1;
                            break;

                        case "POST":
                            requestType = 2;
                            break;

                        case "DELTE":
                            requestType = 3;
                            break;

                        case "PATCH":
                            requestType = 4;
                            break;

                        case "OPTIONS":
                            requestType = 5;
                            break;

                        case "HEAD":
                            requestType = 6;
                            break;

                        case "TRACE":
                            requestType = 7;
                            break;

                        default:
                            //默认没配置method,该接口支持所有请求方式
                            requestType = 0;

                    }
                    in.setRequestType( requestType );

                }

                if (set.getAnnotation( GetMapping.class ) != null)
                    in.setRequestType( 2 );

                if (set.getAnnotation( PostMapping.class ) != null)
                    in.setRequestType( 1 );


                //set projectId 后期修改为对应的项目id
                in.setProjectId( this.projectId );

                //set method name
                in.setName( set.getSimpleName() );

                //set type 0http 1rpc
                in.setType( 0 );

                //settime
                in.setCreateTime( DateTimeUtil.getCurrentDateTIme() );


                //set path
                try {

                    classAnnotation = classAnnotation.replace( "{", "" ).replace( "}", "" );
                    String pathArr[] = classAnnotation.split( "," );


                    //处理特殊RequestMapping eg:@RequestMapping({"/inner/mobile/card", "/mobile/card"})
                    if (pathArr.length > 1) {
                        for (String pathstr :
                                pathArr) {
                            in.setPath( (pathstr + "/" + set.getAnnotation( RequestMapping.class ).value()[0]).replace( "//", "/" ).replace( "///", "/" ).replace( " ", "" ) );
                            Interface interfaceTemp = new Interface();
                            BeanUtils.copyProperties( in, interfaceTemp );
                            interfaceList.add( interfaceTemp );
                        }
                    } else {
                        in.setPath( (classAnnotation + "/" + set.getAnnotation( RequestMapping.class ).value()[0]).replace( "//", "/" ).replace( "///", "/" ).replace( " ", "" ) );
                        interfaceList.add( in );
                    }


                } catch (Exception e) {
                    continue;
                }

            }

        }

        //不用insert list方式，在逻辑层进行日志收集，记录插入失败项
        for (Interface record :
                interfaceList) {

            if (this.type == 0) {
                long count = interfaceService.countNoDeleteByExample( record );
                if (count > 0)
                    logger.info( record.toString() + "已经存在,不插入" );
                else
                    interfaceService.saveInterface( record );
            } else {
                interfaceService.saveInterface( record );

            }

        }

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
