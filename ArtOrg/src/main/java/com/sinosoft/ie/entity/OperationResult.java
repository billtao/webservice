package com.sinosoft.ie.entity;

import java.io.Serializable;

public class OperationResult implements Serializable {  
    private static final long serialVersionUID = -5939599230753662529L;  
  
    private boolean succeed;  
    private String msg;  
  
    public OperationResult() {  
    }  
  
    public OperationResult(boolean succeed, String msg) {  
        this.succeed = succeed;  
        this.msg = msg;  
    }  
  
   //set get  
  
    @Override  
    public String toString() {  
        return "OperationResult{" +  
                "succeed=" + succeed +  
                ", msg='" + msg + '\'' +  
                '}';  
    }  
}  