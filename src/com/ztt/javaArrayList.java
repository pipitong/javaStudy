package com.ztt;
import java.util.*;

public class javaArrayList {
    public static void print(Object o){
        System.out.println(String.format("%s",o));
    }

    public static void demoList(){
        //ArrayList：可变数组
        List<String> lst=new ArrayList<String>();
        for(int i=0;i<4;i++){
            //add方法：逐个加入
            lst.add(String.valueOf(i));
        }
        print(lst);
        List<String> lst2=new ArrayList<String>();
        for(int i=0;i<4;i++){
            lst2.add(String.valueOf(i*i));
        }
        print(lst2);

        //addAll方法：两个可变数组相加。
        lst.addAll(lst2);
        print(lst);

        //remove方法：删除某下标元素或者删除某个对象的第一个。
        lst.remove(0);
        print(lst);
        lst.remove("1");
        print(lst);

        //get方法：得到下标为0的元素
        print(lst.get(0));

        //Collections类
        //sort方法：
        Collections.sort(lst);
        print(lst);

        //自定义排序
        Collections.sort(lst,new Comparator<String>(){
            @Override
            public int compare(String o1,String o2) {
                return o1.compareTo(o2);//反过来写是从大到小
            }
        });
        print(lst);

        //reverse方法：
        Collections.reverse(lst);
        print(lst);

        //遍历ArrayList
        //方法1：
        for(Object o:lst){
            System.out.print(String.format("%s",o));
        }
        System.out.println();

        //方法2：
        for(int i=0;i<lst.size();i++){
            System.out.print(String.format("%s",lst.get(i)));
        }
        System.out.println();

    }
    public static void main(String args[]){
        demoList();
    }
}
