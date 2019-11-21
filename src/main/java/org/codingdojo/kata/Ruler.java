package org.codingdojo.kata;


import org.codingdojo.kata.ruler.utils.Utils;

import java.util.Scanner;

public class Ruler {

    public static void main(String[] args) {
        System.out.println("请输入物品1长度(eg: 12 m, 2 dm, 99 cm, 0.1 mm):");
        Scanner scanner = new Scanner(System.in);
        String[] lengthArray = getStringFromInput(scanner);
        Length length1 = new Length(lengthArray[0], lengthArray[1]);
        System.out.println("物品1的长度是:" + length1.toString());

        System.out.println("请输入物品2长度(eg: 12 m, 2 dm, 99 cm, 0.1 mm):");
        lengthArray = getStringFromInput(scanner);
        Length length2 = new Length(lengthArray[0], lengthArray[1]);
        System.out.println("物品2的长度是:" + length2.toString());

        if (length1.compareTo(length2) > 0) {
            System.out.println("物品1更长，长度是：" + length1.toString());
        } else if (length1.compareTo(length2) < 0) {
            System.out.println("物品2更长，长度是：" + length2.toString());
        } else {
            System.out.println("两个物品一样长，长度是：" + length1.toString() + " 和 " + length2.toString());
        }
    }

    private static String[] getStringFromInput(Scanner scanner) {
        String[] lengthArray = scanner.nextLine().split("\\s+");
        System.out.println(lengthArray.length);
        while (!Utils.validLengthString(lengthArray)) {
            System.out.println("输入错误，重新输入:");
            System.out.println("请输入物品1长度单位(eg: m, dm, cm, mm):");
            scanner = new Scanner(System.in);
            lengthArray = scanner.next().split(" ");
        }
        return lengthArray;
    }
}
