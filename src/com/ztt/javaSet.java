package com.ztt;
import java.util.*;

public class javaSet {
    public static void demoSet(){
        //创建Set对象
        Set<String>st=new HashSet<String>();
        //add方法
        for(int i=0;i<4;i++)
            st.add(String.valueOf(i));
        print(st);
        //遍历
        for(Object i:st){
            System.out.print(String.format("%s ",i));
        }
    }
    public static void print(Object o){
        System.out.println(String.format("%s",o));
    }
    public static void main(String args[]){
        demoSet();
    }
}
