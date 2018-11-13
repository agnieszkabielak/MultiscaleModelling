package Neighbourhood;

import BoundaryConditions.BC;
import java.awt.Color;
import java.awt.Point;
import java.util.List;

public abstract class Neighbourhood {
    public BC bc;

    public Neighbourhood(BC bc) {
        this.bc = bc;
    }
    
    public void setBC(BC bc) {
        this.bc = bc;
    }
    
    public abstract List<Point> getNeighbours(Color[][] matrix, int x, int y);
}
