package BoundaryConditions;

import java.awt.Color;

public abstract class BC {
    public int left;
    public int right;
    public int up;
    public int down;

    public abstract void setBounds(int x, int y, Color[][] matrix);
}
