package org.codingdojo.kata;

public class Leng {

    private long length;

    private String unit;

    public Leng(long length, String unit) {
        this.length = length;
        this.unit = unit;
    }

    public int compareTo(Leng leng) {
        Long leng1 = getLength(this);
        Long leng2 = getLength(leng);

        if(leng1>leng2) {
            return 1;
        } else if (leng1 < leng2) {
            return -1;
        } else {
            return 0;
        }
    }

    private long getLength(Leng leng) {
        switch (leng.unit) {
            case "m" :
                return leng.length * 1000;
            case "dm" :
                return leng.length * 100;
            case "cm" :
                return leng.length * 10;
            case "mm" :
                return leng.length;
            default:
                return length;
        }
    }

    @Override
    public String toString() {
        return length + unit;
    }
}
