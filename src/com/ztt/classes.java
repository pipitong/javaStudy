package com.ztt;

import java.text.SimpleDateFormat;
import java.util.*;

public class classes {
    public static void main(String args[]){
        //随机数对象
        Random rd=new Random();
        //设定种子
        rd.setSeed(34);
        System.out.println(String.format("%d",rd.nextInt(1000)));

        //创建list对象，shuffle方法随机打乱
        List<Integer>lt=Arrays.asList(new Integer[]{1,2,3,4,5});
        Collections.shuffle(lt);
        System.out.println(String.format("%s",lt));

        //时间Date方法
        Date dt=new Date();
        System.out.println(String.format("%s",dt));
        //从1970.1.1到现在的秒数
        System.out.println(String.format("%s",dt.getTime()));
        //日期格式化
        SimpleDateFormat df=new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        System.out.println(String.format("%s",df.format(dt)));

        //UUID方法
        System.out.println(String.format("%s",UUID.randomUUID()));

        //Math类
        System.out.println(String.format("%s",Math.max(3,4)));
        System.out.println(String.format("%s",Math.ceil(3.4)));
        System.out.println(String.format("%s",Math.floor(3.4)));
        System.out.println(String.format("%s",Math.sqrt(4)));
        System.out.println(String.format("%s",Math.log(3.4)));
    }
}
