package com.ztt;
import java.util.*;
public class javaHashMap {
    public static void main(String args[]){
        demoHashMap();
    }

    private static void demoHashMap() {
        Map<String,String>mp2=new Hashtable<String,String>();

        //创建Map对象
        Map<String,String>mp=new HashMap<String,String>();

        //put方法
        for(int i=0;i<4;i++){
            mp.put(String.valueOf(i),String.valueOf(i*i));
        }
        print(mp);

        //get方法
        print(mp.get("1"));

        //containsKey方法,containsValue方法
        print(mp.containsKey("A"));
        print(mp.containsValue("0"));

        //利用entrySet方法遍历map
        for(Map.Entry<String,String>it:mp.entrySet()){
            System.out.println(String.format("%s %s",it.getKey(),it.getValue()));
        }

        //values方法，keySet方法
        print(mp.keySet());
        print(mp.values());

        //repalce方法
        mp.replace("0","z");
        print(mp);
    }

    private static void print(Object o) {
        System.out.println(String.format("%s",o));
    }
}
