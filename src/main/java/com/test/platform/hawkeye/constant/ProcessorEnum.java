package com.test.platform.hawkeye.constant;

public enum ProcessorEnum {

    HTTP( "HTTP" ),

    RPC( "RPC" ),

    AUTO( "AUTO" );

    ProcessorEnum(String value) {
        this.value = value;
    }

    private String value;


    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }


}
