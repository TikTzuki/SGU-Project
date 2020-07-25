/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTO;

/**
 *
 * @author Tik
 */
public class Genre {
    private int genre_id;
    private String name;

    public Genre() {
    }

    public Genre(int genre_id, String name) {
        this.genre_id = genre_id;
        this.name = name;
    }

    public int getGenre_id() {
        return genre_id;
    }

    public void setGenre_id(int genre_id) {
        this.genre_id = genre_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Genre{" + "genre_id=" + genre_id + ", name=" + name + '}';
    }
    
}
