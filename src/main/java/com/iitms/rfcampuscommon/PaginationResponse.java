package com.iitms.rfcampuscommon;

import java.io.Serializable;
import java.util.List;

public class PaginationResponse implements Serializable{

    private int sEcho;
    private int iDisplayStart;
    private int iDisplayLength;
    private int iSortCol_0;
    private String sSortDir_0;
    private String sSearch;
    private int iTotalRecords;
    private int iTotalDisplayRecords;
    private List<?> aaData;
   
    public int getsEcho() {
        return sEcho;
    }
    public void setsEcho(int sEcho) {
        this.sEcho = sEcho;
    }
    public int getiTotalRecords() {
        return iTotalRecords;
    }
    public void setiTotalRecords(int iTotalRecords) {
        this.iTotalRecords = iTotalRecords;
    }
    public int getiTotalDisplayRecords() {
        return iTotalDisplayRecords;
    }
    public void setiTotalDisplayRecords(int iTotalDisplayRecords) {
        this.iTotalDisplayRecords = iTotalDisplayRecords;
    }
    public List<?> getAaData() {
        return aaData;
    }
    public void setAaData(List<?> aaData) {
        this.aaData = aaData;
    }
    public int getiDisplayStart() {
        return iDisplayStart;
    }
    public void setiDisplayStart(int iDisplayStart) {
        this.iDisplayStart = iDisplayStart;
    }
    public int getiDisplayLength() {
        return iDisplayLength;
    }
    public void setiDisplayLength(int iDisplayLength) {
        this.iDisplayLength = iDisplayLength;
    }
    public int getiSortCol_0() {
        return iSortCol_0;
    }
    public void setiSortCol_0(int iSortCol_0) {
        this.iSortCol_0 = iSortCol_0;
    }
    public String getsSortDir_0() {
        return sSortDir_0;
    }
    public void setsSortDir_0(String sSortDir_0) {
        this.sSortDir_0 = sSortDir_0;
    }
    public String getsSearch() {
        return sSearch;
    }
    public void setsSearch(String sSearch) {
        this.sSearch = sSearch;
    }
    
    
   

    
}
