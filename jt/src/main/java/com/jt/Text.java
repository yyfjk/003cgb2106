package com.jt;
public class Text{

    public static void main(String[] args) {
        int[] arr = { 9,8,7,6,5,4,3,2,1};
        System.out.println("排序次数" + bogo(arr));
        for (int i : arr) {
            System.out.print(i + " ");
        }
    }



    public static int bogo(int[] arr) {
        int count = 0;
        while (!isOrdered(arr)) {
            shuffle(arr);
            count++;
        }
        return count;
    }

    // 判断是否有序方法
    public static boolean isOrdered(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            if (arr[i - 1] > arr[i]) {
                return false;
            }
        }
        return true;
    }

    // 随机排序方法
    public static void shuffle(int[] arr) {
        int temp;
        for (int i = 0; i < arr.length; i++) {
            int j = (int) (Math.random() * arr.length);
            temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        }
    }

}