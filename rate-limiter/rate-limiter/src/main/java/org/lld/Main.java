package org.lld;

import java.util.*;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {


        RateLimiter rl = new RateLimiter(3, 10);
        System.out.println("Is allowed : " + rl.allow("us1",1));
        System.out.println("Is allowed : " + rl.allow("us1",2));
        System.out.println("Is allowed : " + rl.allow("us1",3));
        System.out.println("Is allowed : " + rl.allow("us1",4));
        System.out.println("Is allowed : " + rl.allow("us2",4));
        System.out.println("Is allowed : " + rl.allow("us2",3));
        System.out.println("Is allowed : " + rl.allow("us2",2));
        System.out.println("Is allowed : " + rl.allow("us2",1));
    }
}

