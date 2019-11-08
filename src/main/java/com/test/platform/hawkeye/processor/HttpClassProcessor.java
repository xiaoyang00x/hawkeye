package com.test.platform.hawkeye.processor;

import com.test.platform.hawkeye.domain.general.Interface;
import com.test.platform.hawkeye.domain.general.Test;
import com.test.platform.hawkeye.service.InterfaceService;
import com.test.platform.hawkeye.utils.DateTimeUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import spoon.processing.AbstractProcessor;
import spoon.reflect.declaration.CtAnnotation;
import spoon.reflect.declaration.CtClass;
import spoon.reflect.declaration.CtElement;
import spoon.reflect.declaration.CtMethod;
import spoon.reflect.reference.CtTypeReference;

import java.lang.annotation.Annotation;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;


/**
 * http收集器
 */
public class HttpClassProcessor extends AbstractProcessor<CtClass> {

    @Autowired
    InterfaceService interfaceService;


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
            if (ctAnnotation.getAnnotationType().getSimpleName().equals( RequestMapping.class.getSimpleName() ))
                classAnnotation = ctAnnotation.getAllValues().get( "value" ).toString().replace( "\"", "" );
        }


        Set<CtMethod<?>> ctMethodsSet = ctClass.getAllMethods();
        for (CtMethod<?> set :
                ctMethodsSet) {
            Interface in = new Interface();
            if (set.getAnnotation( RequestMapping.class ) != null) {
                //set path
                in.setPath( classAnnotation + set.getAnnotation( RequestMapping.class ).value()[0] );

                if (!StringUtils.isEmpty( set.getAnnotation( RequestMapping.class ).method() ) && set.getAnnotation( RequestMapping.class ).method().length > 0) {

                    int requestType = RequestMethod.POST.toString().equals( set.getAnnotation( RequestMapping.class ).method()[0].toString() ) ? 1 : 2;

                    //set requesttype 1post 2get 0无
                    in.setRequestType( requestType );

                }

                if (set.getAnnotation( GetMapping.class ) != null)
                    in.setRequestType( 2 );

                if (set.getAnnotation( PostMapping.class ) != null)
                    in.setRequestType( 1 );

                //set projectId
                in.setProjectId( 0 );

                //set method name
                in.setName( set.getSimpleName() );

                //set type 0http 1rpc
                in.setType( 0 );

                //settime
                in.setCreateTime( DateTimeUtil.getCurrentDateTIme() );


                interfaceList.add( in );
            }

        }

        for (Interface record :
                interfaceList) {
            System.out.println( record.toString() );

        }

    }
}
