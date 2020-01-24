package view.ui;

import model.Image;

public interface ImageDisplay {

    Image currentImage();
    void display(Image image);

}
