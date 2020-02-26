package com.ztt;

public class animal implements talking{
    String hight,weight;
    @Override
    public void say() {
        System.out.print("I'm an animal!");
    }
    public animal(String height,String weight){
        this.hight=height;
        this.weight=weight;
    }
}
