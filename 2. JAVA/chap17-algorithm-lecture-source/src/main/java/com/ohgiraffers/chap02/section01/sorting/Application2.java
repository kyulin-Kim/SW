package com.ohgiraffers.chap02.section01.sorting;

import java.util.Scanner;

/* 수업목표. 선택 정렬을 이해할 수 있다. */
/* 필기.
 *  선택 정렬(Selection Sort)
 *   대상 데이터에서 최대나 최소 데이터를 찾아 맨 앞(또는 맨 뒤)와 교환하는 방법이다.
 *   배열의 모든 요소에 대해 반복한다.
 *   시간 복잡도는 O(n^2)이라 효율적이지는 않다.
* */
public class Application2 {
    /* 설명.
     *  문제 내용
     *   : N개의 정수가 주어졌을 때, 선택 정렬 알고리즘을 사용하여 내림차순으로 정렬하는 프로그램을 작성하시오.
     *  입력
     *   - 첫 번째 줄에 자연수 N(1 <= N <= 100)이 주어진다.
     *   - 두 번째 줄에 N개의 정수가 공백으로 구분되어 입력된다. 각 정수는 -10^9 이상, 10^9 이하이다.
     *  출력
     *    - 내림차순으로 정렬된 수열을 공백으로 구분하여 출력한다.
     *
     * 설명.
     *  예시 입력 1
     *    - 10
     *      32 7 34 39 40 41 22 31 23 25
     *  예시 출력 1
     *    - 41 40 39 34 32 31 25 23 22 7
     *
     * 설명.
     *  예시 입력 2
     *    - 6
     *      42 29 34 64 28 12
     *  예시 출력 2
     *    - 64 42 34 29 28 12
     * */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        /* 설명. 입력 데이터 받기 */
        int length = sc.nextInt();
        int[] arr = new int[length];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = sc.nextInt();                  // 공백을 구분자로 하여 하나씩 입력됨

        }

        /* 설명. 알고리즘 실행 */
        solution(length, arr);

        /* 설명. 정렬 결과 출력하기 */
        for (int i : arr) {
            System.out.print(i + " ");
        }
    }

        public static void solution(int length, int[] arr){
            for (int i = 0; i < length - 1; i++) {
                int maxIndex = 1;

                /* 설명. j범위에서 가장 큰 값을 maxIndex에 저장 */
                for (int j = i + 1; j < length; j++) {
                    if (arr[i] < arr[j]) {
                        maxIndex = j;
                        int temp = arr[i];
                        arr[i] = arr[maxIndex];
                        arr[maxIndex] = temp;
                    }
                }
            }
        }
    }

/*
* 선택 정렬 알고리즘에서 사용되는 for 루프들을 더 자세히 설명하겠습니다. 선택 정렬은 두 개의 중첩된 for 루프를 사용하여 배열을 정렬합니다.

1. 첫 번째 for 루프 (i 루프):

이 루프는 배열의 각 위치에 대해서 반복합니다. 각 반복에서 i는 현재 정렬해야 할 위치를 가리킵니다.
배열의 첫 번째 요소부터 시작하여, 마지막에서 두 번째 요소까지 순회합니다 (length - 1까지, 마지막 요소는 자동으로 정렬됨).
이 위치에서, 배열의 나머지 부분 중 가장 큰 요소를 찾아야 합니다.

2. 두 번째 for 루프 (j 루프):

이 루프는 i 다음 위치에서 시작하여 배열의 끝까지 진행합니다.
이 루프의 목적은 i 위치에 들어갈 최대값을 찾는 것입니다.
각 반복에서 현재 i 위치의 값과 비교하여 더 큰 값을 찾습니다. 더 큰 값이 발견되면, 해당 요소의 인덱스를 maxIndex에 저장합니다.

3. 요소 교환:

두 번째 루프가 종료되면, maxIndex에는 i 위치부터 배열 끝까지 중 가장 큰 요소의 인덱스가 저장되어 있습니다.
이제 i 위치의 요소와 maxIndex 위치의 요소를 교환합니다. 이로써 현재 i 위치에는 배열의 해당 부분에서 가장 큰 값이 오게 됩니다.
이 과정은 배열의 모든 요소가 올바르게 정렬될 때까지 반복됩니다.
이 과정을 통해 배열은 내림차순으로 정렬됩니다. 각 i 위치마다, 배열의 나머지 부분 중에서 가장 큰 요소를 찾아 해당 위치로 이동시키는 것입니다.
  */