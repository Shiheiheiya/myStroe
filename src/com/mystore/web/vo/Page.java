package com.mystore.web.vo;

import com.mystore.web.pojo.Product;

import java.util.List;

public class Page {

    private int currentIndex;
    private int maxCount;
    private int totalPages;
    private List<Product> productList;
    private int currentPage;
    private int totalCount;


    public int getCurrentIndex() {
        return currentIndex;
    }

    public void setCurrentIndex(int currentIndex) {
        this.currentIndex = currentIndex;
    }

    public int getMaxCount() {
        return maxCount;
    }

    public void setMaxCount(int maxCount) {
        this.maxCount = maxCount;
    }

    public int getTotalPages() {
        return totalPages;
    }

    public void setTotalPages(int totalPages) {
        this.totalPages = totalPages;
    }

    public List<Product> getProductList() {
        return productList;
    }

    public void setProductList(List<Product> productList) {
        this.productList = productList;
    }

    public int getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }

    public int getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(int totalCount) {
        this.totalCount = totalCount;
    }

    @Override
    public String toString() {
        return "Page{" +
                "currentIndex=" + currentIndex +
                ", maxCount=" + maxCount +
                ", totalPages=" + totalPages +
                ", productList=" + productList +
                ", currentPage=" + currentPage +
                ", totalCount=" + totalCount +
                '}';
    }
}
