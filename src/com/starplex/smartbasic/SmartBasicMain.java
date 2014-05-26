package com.starplex.smartbasic;

import static java.lang.System.out;
import static java.lang.System.in;

public class SmartBasicMain {

    public static void main(String[] args) {
        out.println("SmartBasic compiler 0.01");
        out.println("Copyright (c) Starplex inc.");

        if (args.length < 1) {
            out.println("Error: no input files");
        } else {
            for (String f : args) {
                SmartBasicCompiler.compile(f);
            }
        }
    }
}
