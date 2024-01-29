package com.ohgiraffers.section02.uses.subsection01.generation;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class Application1 {
    public static void main(String[] args) {

        /* 수업목표. 배열이나 컬렉션은 스트림을 이용할 수 있고 이를 이해해서 활용할 수 있다. */
        String[] sArr = new String[]{"java", "oracle", "jdbc"};

        /* 필기.
         *  Arrays.stream(배열): 배열 자료형을 stream 자료형으로 변환
        * */
        /* 설명. 1. 배열로 스트림 생성 */
        Stream<String> strStream1 = Arrays.stream(sArr);
        strStream1.forEach(System.out::println);
//        strStream1.forEach(s -> System.out.println(s));

        System.out.println();           // 구분을 위한 단순 개행

        Stream<String> strStream2 = Arrays.stream(sArr, 0, 2);
        strStream2.forEach(System.out::println);
        System.out.println();

        /* 설명. 컬렉션으로 컬렉션 스트림 생성 */
        List<String> stringList = Arrays.asList("html", "css", "javascript");

        Stream<String> stringStream3 = stringList.stream();
        stringStream3.forEach(System.out::println);
        System.out.println();

        /* 설명. 3.
         *  Builder를 활용한 스트림 생성
         *  builder는 static<T>로 되어 있는 메소드이며, 호출시 타입 파라미터를 메소드 호출 방식으로 전달한다.
        * */
        Stream<String> builderStream = Stream.<String>builder()
                                             .add("홍길동")
                                             .add("유관순")
                                             .add("윤봉길")
                                             .build();

        builderStream.forEach(System.out::println);

        /* 설명. 4. iterator()를 활용하여 수열 형태의 스트림을 생성 */
        Stream<Integer> intStream =Stream.iterate(10, value -> value * 2)
                                         .limit(10);
        intStream.forEach(value -> System.out.println(value + " "));
    }
}
