package com.sda.model;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import java.time.LocalDate;

@Entity
public class Costume {

    @Id
    @GeneratedValue(generator = "")
    @SequenceGenerator(name = "", sequenceName = "", allocationSize = 1)


    private Long id;
    private String character;
    private enum size {
        S,M,L,XL,BIGMAMMA;
    }
    private enum genre {
        SUPERHEROES,WILDWEST,HORROR,PIRATES,ANIMALS;
    }
    private enum sex {
        FEMALE,MALE,REST;
    }
    private LocalDate borrowedTill;

    public Costume(Long id, String character, LocalDate borrowedTill) {
        this.id = id;
        this.character = character;
        this.borrowedTill = borrowedTill;
    }

    public Costume() {}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCharacter() {
        return character;
    }

    public void setCharacter(String character) {
        this.character = character;
    }

    public LocalDate getBorrowedTill() {
        return borrowedTill;
    }

    public void setBorrowedTill(LocalDate borrowedTill) {
        this.borrowedTill = borrowedTill;
    }
    
}
