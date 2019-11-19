package org.codingdojo.kata;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Ruler {

    public static void main(String[] args) {
        List<String> availableUnit = new ArrayList<>();
        availableUnit.add("mm");
        availableUnit.add("cm");
        availableUnit.add("m");
        availableUnit.add("dm");
        System.out.println("请输入物品1长度单位(eg: m, dm, cm, mm):");
        Scanner scanner = new Scanner(System.in);
        String unit1 = scanner.next();
        while (!availableUnit.contains(unit1)) {
            System.out.println("输入错误，重新输入:");
            System.out.println("请输入物品1长度单位(eg: m, dm, cm, mm):");
            scanner = new Scanner(System.in);
            unit1 = scanner.next();
        }
        System.out.println("请输入物品1长度:");
        long length1 = scanner.nextLong();
        System.out.println("物品1的长度是:" + length1 + unit1);
        Leng leng1 = new Leng(length1, unit1);
        System.out.println("请输入物品2长度单位(eg: m, dm, cm, mm):");
        String unit2 = scanner.next();
        while (!availableUnit.contains(unit2)) {
            System.out.println("输入错误，重新输入:");
            System.out.println("请输入物品2长度单位(eg: m, dm, cm, mm):");
            scanner = new Scanner(System.in);
            unit2 = scanner.next();
        }
        System.out.println("请输入物品2长度:");
        long length2 = scanner.nextLong();
        Leng leng2 = new Leng(length2, unit2);
        System.out.println("物品2的长度是" + length2 + unit2);
        if (leng1.compareTo(leng2) > 0) {
            System.out.println("物品1更长，长度是：" + leng1.toString());
        } else if (leng1.compareTo(leng2) < 0) {
            System.out.println("物品2更长，长度是：" + leng2.toString());
        } else {
            System.out.println("两个物品一样长，长度是：" + leng1.toString());
        }
    }
}
