package com.test.platform.hawkeye.domain.general;

public class Test {

    private String type = "GET";

    private String path;


    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    @Override
    public String toString() {
        return "Test{" +
                "type='" + type + '\'' +
                ", path='" + path + '\'' +
                '}';
    }
}
