/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.view;

import com.jfoenix.controls.datamodels.treetable.RecursiveTreeObject;

/**
 *
 * @author Conectando Paisaje
 */
public class ReportesView extends RecursiveTreeObject{
    
    
    private int num ;
    private String modForm;
    private long accplan;
    private long accreal;
    private long gradplan;
    private long gradreal;

    public ReportesView(int num, String modForm, long accplan, long accreal, long gradplan, long gradreal) {
        this.num = num;
        this.modForm = modForm;
        this.accplan = accplan;
        this.accreal = accreal;
        this.gradplan = gradplan;
        this.gradreal = gradreal;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public String getModForm() {
        return modForm;
    }

    public void setModForm(String modForm) {
        this.modForm = modForm;
    }

    public long getAccplan() {
        return accplan;
    }

    public void setAccplan(long accplan) {
        this.accplan = accplan;
    }

    public long getAccreal() {
        return accreal;
    }

    public void setAccreal(long accreal) {
        this.accreal = accreal;
    }

    public long getGradplan() {
        return gradplan;
    }

    public void setGradplan(long gradplan) {
        this.gradplan = gradplan;
    }

    public long getGradreal() {
        return gradreal;
    }

    public void setGradreal(long gradreal) {
        this.gradreal = gradreal;
    }

    
    
    
    
    
    
    
    
    
    
    
    
    
}
