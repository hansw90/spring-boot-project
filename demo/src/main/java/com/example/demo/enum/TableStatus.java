package com.example.demo;

public enum TableStatus {

    Y("1",true),
    N("0",false);

    private String tableValue;
    private boolean table2Value;


    TableStatus(String tableValue, boolean table2Value) {
        this.tableValue = tableValue;
        this.table2Value = table2Value;
    }

    public String getTableValue(){
        return tableValue;
    }

    public boolean isTable2Value(){
        return table2Value;
    }
}