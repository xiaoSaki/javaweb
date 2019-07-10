package com.lnsf.dao;

import org.springframework.stereotype.Repository;

@Repository
public class PersonDao {
    private String label="2";

    public String getLabel(){
        return label;
    }
    public void setLabel(String label){
        this.label=label;
    }
    @Override
    public String toString(){
        return "PersonDao{"+
                "lable='"+label+"\'"+"}";
    }
}

