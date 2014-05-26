package com.starplex.smartbasic;

import static java.lang.System.out;

/**
 * Created by Влад on 23.05.2014.
 */
public class SmartBasicCompiler {
    static void compile(String fileName) {
        out.println("Compiling " + fileName + "...");

        SmartBasicProgram program = new SmartBasicProgram();
        program.parse(fileName);
    }
}
