package com.ohgiraffers.section04.override;

import java.io.IOException;

public class Application1 {
    public static void main(String[] args) {
        SuperClass cs = new SubClass();
        try {
            cs.method();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
