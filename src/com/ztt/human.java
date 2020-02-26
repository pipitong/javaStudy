package com.ztt;

public class human extends animal {
    String name;
    public human(String height,String weight,String name){
        //利用super方法给从父类继承过来的变量赋值
        super(height,weight);
        //利用this方法给本类定义的变量赋值
        this.name=name;
    }

    //重写say方法，快捷键ctrl+o
    @Override
    public void say() {
        System.out.println("I'm a human");
    }
}

