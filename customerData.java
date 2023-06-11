/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entertamaintticketbookingmanagementsystem;

import java.sql.Date;
import java.sql.Time;

/**
 *
 * @author MOHAMMED
 */
public class customerData {
 private Integer id;
 private String type;
 private String title;
 private Integer quantity;
 private double total;
 private Date date;
 private Time time;
 
 
 public customerData(Integer id,String type,String title,Integer quantity,double total,Date date,Time time){
     this.id=id;
     this.type=type;
     this.quantity=quantity;
     this.total=total;
     this.date=date;
     this.time=time;
     this.title=title;
 }

    customerData(int aInt, String string, int aInt0, double aDouble, Time time) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
 
 public Integer getId(){
     return id;
     
 }
 public String getType(){
     return type;
 }
 public Integer getQuantity(){
     return quantity;
 }
 public double getTotal(){
     return total;
 }
 public Date getDate(){
     return date;
 }

    public Time getTime() {
        return time;
    }

    public String getTitle() {
        return title;
    }
 
}
