package com.jkxy.car.demo.pojo;
/**
 * 分页实体类
 */
public class PageHelpParam {
    /**
     * 当前页
     */
    private String currentPageParam ;

    /**
     * 当前页条数
     */
    private String pageSizeParam;

    /**
     * 模糊查询参数fuzzy
     */
    private String fuzzy;

    /**
     * 模糊查询参数 nextFuzzy
     */

    private String nextFuzzy;

    public String getCurrentPageParam() {
        return currentPageParam;
    }

    public void setCurrentPageParam(String currentPageParam) {
        this.currentPageParam = currentPageParam;
    }

    public String getPageSizeParam() {
        return pageSizeParam;
    }

    public void setPageSizeParam(String pageSizeParam) {
        this.pageSizeParam = pageSizeParam;
    }

    public String getFuzzy() {
        return fuzzy;
    }

    public void setFuzzy(String fuzzy) {
        this.fuzzy = fuzzy;
    }

    public String getNextFuzzy() {
        return nextFuzzy;
    }

    public void setNextFuzzy(String nextFuzzy) {
        this.nextFuzzy = nextFuzzy;
    }
}
