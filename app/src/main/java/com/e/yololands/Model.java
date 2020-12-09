package com.e.yololands;

public class Model {
    private int id;
    private String landType;
    private String loc;
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLandType() {
        return landType;
    }

    public void setLandType(String landType) {
        this.landType = landType;
    }

    public String getLoc() {
        return loc;
    }

    public void setLoc(String loc) {
        this.loc = loc;
    }

    public Model(int id, String landType, String loc) {
        this.id = id;
        this.landType = landType;
        this.loc = loc;
    }
}
