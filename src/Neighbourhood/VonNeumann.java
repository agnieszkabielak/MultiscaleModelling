package Neighbourhood;

import BoundaryConditions.BC;
import java.awt.Color;
import java.awt.Point;
import java.util.LinkedList;
import java.util.List;

public class VonNeumann extends Neighbourhood{

    public VonNeumann(BC bc) {
        super(bc);
    }

    @Override
    public List<Point> getNeighbours(Color[][] matrix, int x, int y) {
        bc.setBounds(x, y, matrix);
        List<Point> neighbours = new LinkedList<>();

        neighbours.add(new Point(x, bc.up));
        neighbours.add(new Point(x, bc.down));
        neighbours.add(new Point(bc.left, y));
        neighbours.add(new Point(bc.right, y));

        return neighbours;
    }
    
}
