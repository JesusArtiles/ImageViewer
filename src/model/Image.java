package model;

public interface Image {

    byte [] bitmap();
    Image next();
    Image previous();


}