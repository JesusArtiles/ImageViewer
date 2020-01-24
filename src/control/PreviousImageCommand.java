package control;

import control.Command;
import view.ui.ImageDisplay;

public class PreviousImageCommand implements Command {

    private final ImageDisplay imageDisplay;

    public PreviousImageCommand(ImageDisplay imageDisplay) {
        this.imageDisplay = imageDisplay;
    }


    @Override
    public String name() {
        return "previous";
    }

    @Override
    public void execute() {
        imageDisplay.display(imageDisplay.currentImage().previous());
    }


}
