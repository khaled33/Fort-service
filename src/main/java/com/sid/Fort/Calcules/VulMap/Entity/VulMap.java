package com.sid.Fort.Calcules.VulMap.Entity;

import java.util.List;
import java.util.Map;

public class VulMap {
    private Long id;
    private String name;
    private List<VulMap> children;
    private Map<String,String> data;

    public VulMap() {
    }

    public VulMap(Long id, String name, List<VulMap> children, Map<String, String> data) {
        this.id = id;
        this.name = name;
        this.children = children;
        this.data = data;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<VulMap> getChildren() {
        return children;
    }

    public void setChildren(List<VulMap> children) {
        this.children = children;
    }

    public Map<String, String> getData() {
        return data;
    }

    public void setData(Map<String, String> data) {
        this.data = data;
    }
}
