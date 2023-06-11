/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entertamaintticketbookingmanagementsystem;

import java.sql.Date;

/**
 *
 * @author MOHAMMED
 */
public class movieDatabase {
    private Integer id;
    private String title;
    private String genre;
    private String duration;
    private Date date;
    private String image;
    private String current;
    public movieDatabase(Integer id ,String title,String genre,String duration,Date date,String image,String current){
        this.id =id;
        this.title =title;
        this.genre = genre;
        this.duration = duration;
        this.date = date;
        this.image = image;
        this.current =current ;
    }

    public Integer getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getGenre() {
        return genre;
    }

    public String getDuration() {
        return duration;
    }

    public Date getDate() {
        return date;
    }

    public String getImage() {
        return image;
    }

    public String getCurrent() {
        return current;
    }
  
    
}
