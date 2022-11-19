package com.revature.P1SanchitKumar.Util;

import io.javalin.Javalin;

public class Application {

    public static void main(String[] args) {
        Javalin app = Javalin.create().start(8080);
    }

}
