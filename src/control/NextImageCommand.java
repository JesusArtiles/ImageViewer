package control;

import control.Command;
import view.ui.ImageDisplay;

public class NextImageCommand implements Command {
    private final ImageDisplay imageDisplay;

    public NextImageCommand(ImageDisplay imageDisplay) {
        this.imageDisplay = imageDisplay;
    }

    @Override
    public String name() {
        return "next";
    }

    @Override
    public void execute() {
        imageDisplay.display(imageDisplay.currentImage().next());
    }

}