package org.codingdojo.kata.ruler.enu;

public enum LengthUnit {
    M("m", 1000),
    DM("dm", 100),
    CM("cm", 10),
    MM("mm", 1);

    private String name;

    private int scale;

    LengthUnit(String name, int scale) {
        this.name = name;
        this.scale = scale;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getScale() {
        return scale;
    }

    public void setScale(int scale) {
        this.scale = scale;
    }

    public static boolean validUnit(String unit) {
        for (LengthUnit singleUnit: LengthUnit.values()) {
            if (singleUnit.getName().equals(unit)) {
                return true;
            }
        }
        return false;
    }

    public static LengthUnit parseUnit(String unit) {
        for (LengthUnit singleUnit: LengthUnit.values()) {
            if (singleUnit.getName().equals(unit)) {
                return singleUnit;
            }
        }
        return null;
    }
}
