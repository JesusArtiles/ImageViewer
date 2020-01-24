package main;


import control.NextImageCommand;
import control.PreviousImageCommand;
import implementation.view.persistence.FileImageLoader;
import implementation.view.ui.MainFrame;
import view.persistence.ImageLoader;

public class Main {

    public static void main(String[] args) {
        ImageLoader loader = new FileImageLoader("data/Images");
        MainFrame mainFrame = new MainFrame();
        mainFrame.add(new NextImageCommand(mainFrame.getImageDisplay()));
        mainFrame.add(new PreviousImageCommand(mainFrame.getImageDisplay()));
        mainFrame.getImageDisplay().display(loader.load());
    }

}