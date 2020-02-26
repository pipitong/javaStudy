package com.ztt;

public class javaString {
    /**
     *
     * @param index
     * @param c
     */
    public static void fun(int index,Object c){
        System.out.println(String.format("%d :%s",index,c));
    }
    public static void mystring(String str){
        System.out.println(String.format("%s",str.indexOf('o')));//输出第一个o的下标
        System.out.println(String.format("%s",str.charAt(1)));//输出str[1]
        System.out.println(String.format("%s",str.codePointAt(1)));//二进制形式输出str[1]的值
        System.out.println(String.format("%s",str.compareToIgnoreCase("hello World")));//忽略大小写比较字符串
        System.out.println(String.format("%s",str.compareTo("hello world")));//比较字符串，有三种返回结果：-1，0，1
        System.out.println(String.format("%s",str.compareTo("hello vorld")));
        System.out.println(String.format("%s",str.compareTo("hello xorld")));
        System.out.println(String.format("%s",str.concat("!!!")));//在字符串后拼接字符串，但是不会改变原字符串
        System.out.println(String.format("%s",str.contains("he")));//是否包含子字符串
        System.out.println(String.format("%s",str.toUpperCase()));//转为大写
        System.out.println(String.format("%s",str.startsWith("hel")));//是否以某字符串开头
        System.out.println(String.format("%s",str.endsWith("d")));//是否以某字符串结尾
        System.out.println(String.format("%s",str.replace('e','c')));//替换所有字母e为c
        System.out.println(String.format("%s",str.replaceAll("e|o","z")));//支持正则表达式的替换
        System.out.println(String.format("%s",str.replaceAll("hell","ztt")));//同上
        System.out.println(String.format("%s",str+str));




    }
    public static void main(String[]args) {
//        fun(1,"hello");
//        fun(2,"hello2");
        mystring("hello world");
    }
}
