package net.add1s.entity.common;

/**
 * @author pj.w@qq.com
 */
public enum Sort {

    ASC("ASC"),
    DESC("DESC");

    private String sort;

    Sort(String sort) {
        this.sort = sort;
    }

    public String getSort() {
        return sort;
    }
}
