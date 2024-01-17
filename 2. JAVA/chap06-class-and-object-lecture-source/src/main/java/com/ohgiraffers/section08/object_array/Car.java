package com.ohgiraffers.section08.object_array;

public class Car {

    private  String modelName;
    private  int maxSpeed;

    public Car() {
    }

    public Car(String modelName, int maxSpeed) {
        this.modelName = modelName;
        this.maxSpeed = maxSpeed;
    }

    public void driveMaxSpeed() {
        System.out.println(modelName + "차량이 최고 시속 " + maxSpeed + "(km/h)로 달립니다!!");
    }
}
