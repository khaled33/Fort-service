package com.sid.Fort.Calcules.VulMap.Entity;

import java.util.List;
import java.util.Map;

public class VulMaPChldrenl<T> extends VulMap {
    private List<T> children;

    public VulMaPChldrenl() {
    }

    public VulMaPChldrenl(String id, String name, List<T> children, Map<String, String> data) {
        super(id, name, data);
        this.children=children;
    }

    public List<T> getChildren() {
        return children;
    }

    public void setChildren(List<T> children) {
        this.children = children;
    }
}
