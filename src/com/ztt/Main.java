package com.ztt;

public class Main {
    public static void main(String args[]){
        human lily=new human("170","45kg","lily");
        lily.say();

        //体现了多态性：运行时决定执行的方法是什么
        animal zst=new human("175","91kg","zst");
        zst.say();

        animal kiki=new animal("180","50kg");
        kiki.say();
    }
}
