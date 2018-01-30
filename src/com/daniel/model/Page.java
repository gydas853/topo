package com.daniel.model;

import java.util.List;

/**
 * Created by nero0 on 2018-01-29.
 */
public class Page {
    private static final int pageSize = 2;

    public static int getTotalPages(int totalRows){
        int totalPages = totalRows%pageSize==0?totalRows/pageSize:totalRows/pageSize+1;
        return totalPages;
    }
}
