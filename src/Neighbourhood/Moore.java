package Neighbourhood;

import BoundaryConditions.BC;
import java.awt.Color;
import java.awt.Point;
import java.util.LinkedList;
import java.util.List;

public class Moore extends Neighbourhood {

    public Moore(BC bc) {
        super(bc);
    }

    @Override
    public List<Point> getNeighbours(Color[][] matrix, int x, int y) {
        bc.setBounds(x, y, matrix);
        List<Point> neighbours = new LinkedList<>();

        neighbours.add(new Point(bc.left, bc.up)); // base.bc.left
        neighbours.add(new Point(x, bc.up));
        neighbours.add(new Point(bc.right, bc.up));
        neighbours.add(new Point(bc.left, bc.down));
        neighbours.add(new Point(x, bc.down));
        neighbours.add(new Point(bc.right, bc.down));
        neighbours.add(new Point(bc.left, y));
        neighbours.add(new Point(bc.right, y));

        return neighbours;
    }

}
