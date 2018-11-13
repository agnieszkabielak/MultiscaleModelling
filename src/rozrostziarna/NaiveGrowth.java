package rozrostziarna;

import BoundaryConditions.BC;
import Neighbourhood.Neighbourhood;
import java.awt.Color;
import java.awt.Point;
import java.util.List;

public class NaiveGrowth {

    private Neighbourhood neighbourhood;

    public NaiveGrowth(Neighbourhood nh) {
        this.neighbourhood = nh;
    }

    public BC getBoundaryCondition() {
        return neighbourhood.bc;
    }

    public void changeNeighbourhood(Neighbourhood nh) {
        this.neighbourhood = nh;
    }

    public void changeBoundaryCondition(BC bc) {
        neighbourhood.setBC(bc);
    }

    public Color[][] growthStep(Color[][] matrix, Color[][] tmp) {
        for (int y = 0; y < tmp.length; y++) {
            for (int x = 0; x < tmp[0].length; x++) {
                if (tmp[y][x] == Color.blue) {
                    List<Point> neighbours = neighbourhood.getNeighbours(tmp, x, y);
                    int counterWinner = 0;
                    Color winner = tmp[y][x];
                    for (Point p : neighbours) {
                        if (tmp[p.y][p.x] != Color.blue && tmp[p.y][p.x] != Color.black) {
                            int counter = 0;
                            for (Point pp : neighbours) {
                                if (tmp[p.y][p.x] == tmp[pp.y][pp.x]) {
                                    counter++;
                                }
                            }
                            if (counter > counterWinner) {
                                counterWinner = counter;
                                winner = tmp[p.y][p.x];
                            }
                        }
                    }
                    if (winner != Color.blue ) {
                        matrix[y][x] = winner;
                    }
                }
            }
        }

        return matrix;
    }
}
