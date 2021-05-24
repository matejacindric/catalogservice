package com.companyname.catalogservice.enums;


public enum Category {
    
    PHONES("Mobile phone"),
    LAPTOP("Laptop"),
    TV("TV and Home Theatre"),
    TABLETS("Tablets"),
    PRINTERS("Printers and Ink"),
    CAMERA("Camera and photo"),
    VIDEOGAMES("Video games"),
    ELECTRONICS("Electronics and photo"),
    COMPUTERS("Computers and office"),
    SOFTWARE("Software");
    
    private String name;
    
    Category(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }

}
