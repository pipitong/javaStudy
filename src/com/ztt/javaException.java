package com.ztt;
import java.util.*;

public class javaException {
    public static void demoException(){
       int c=2;
        try{
           int a=3;
           a=a/0;
       }catch (Exception e){
           //逻辑错误
           print(e.getMessage());

           //业务异常
           if(c==2){
               System.out.println("设置异常");
           }
       }finally {
           System.out.println("总会执行");
       }
    }
    public static void print(Object o){
        System.out.println(String.format("%s",o));
    }
    public static void main(String args[]){
        demoException();
    }
}
