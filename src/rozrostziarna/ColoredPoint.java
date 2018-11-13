package rozrostziarna;

import java.awt.Color;
import java.awt.Point;

public class ColoredPoint extends Point{
    public Color color;

    public ColoredPoint(int x, int y, Color color) {
        super(x, y);
        this.color = color;
    }
    
    public ColoredPoint(Point point, Color color) {
        super(point);
        this.color = color;
    }
}
