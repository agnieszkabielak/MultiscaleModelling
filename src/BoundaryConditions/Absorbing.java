package BoundaryConditions;

import java.awt.Color;

public class Absorbing extends BC{

    @Override
    public void setBounds(int x, int y, Color[][] matrix) {
        left = x - 1;
        right = x + 1;
        up = y - 1;
        down = y + 1;
        if (left < 0)
            left = x;
        if (right > matrix[0].length - 1)
            right = x;
        if (up < 0)
            up = y;
        if (down > matrix.length - 1)
            down = y;
    }
    
}
