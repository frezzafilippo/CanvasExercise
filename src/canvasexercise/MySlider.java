package canvasexercise;


import javafx.geometry.Orientation;
import javafx.scene.control.Slider;


public class MySlider extends Slider{
    public final int CANVASDIMENSION=500;
        MySlider(){
        setOrientation(Orientation.VERTICAL);
        setShowTickLabels(true);
        setMajorTickUnit(1.0);
        setMax(CANVASDIMENSION);
        setMin(0.0);
        setSnapToTicks(true);
        };

    
}