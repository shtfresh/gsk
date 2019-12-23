package com.tao.hana.bean;

/**
 * Copyright 2019 bejson.com
 */


import com.alibaba.fastjson.annotation.JSONField;

/**
 * Auto-generated: 2019-12-20 11:38:9
 *
 * @author bejson.com (i@bejson.com)
 * @website http://www.bejson.com/java2pojo/
 */
public class JsonRootBean {

    @JSONField(name="GLN_HEADER")
    private GLN_HEADER GLN_HEADER;
    @JSONField(name="GLN_BODY")
    private GLN_BODY GLN_BODY;
    public void setGLN_HEADER(GLN_HEADER GLN_HEADER) {
        this.GLN_HEADER = GLN_HEADER;
    }
    public GLN_HEADER getGLN_HEADER() {
        return GLN_HEADER;
    }

    public void setGLN_BODY(GLN_BODY GLN_BODY) {
        this.GLN_BODY = GLN_BODY;
    }
    public GLN_BODY getGLN_BODY() {
        return GLN_BODY;
    }

}