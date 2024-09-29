package com.tk.learn.springapachefop.test1;

public class CustomModelObject {

    String codeValue;

    public CustomModelObject() {
        codeValue = null;
    }

    public CustomModelObject(final String value) {
        this.codeValue = value;
    }

    public String getCodeValue() {
        return codeValue;
    }

    public void setCodeValue(String codeValue) {
        this.codeValue = codeValue;
    }

}