package com.sid.Fort.Calcules.VulMap.Entity;

import java.util.Map;

public abstract class VulMap {
    private String id;
    private String name;
    private Map<String,String> data;

    public VulMap() {
    }

    public VulMap(String id, String name, Map<String, String> data) {
        this.id = id;
        this.name = name;
        this.data = data;
    }


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    

    public Map<String, String> getData() {
        return data;
    }

    public void setData(Map<String, String> data) {
        this.data = data;
    }
}
