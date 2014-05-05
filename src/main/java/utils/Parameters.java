package utils;

/**
 * User: alpi
 * Date: 02.12.13
 */
public class Parameters {
    private Parameters() {
    }

    static Parameters parameters;

    public static Parameters get() {
        if (parameters == null) {
            parameters = new Parameters();
        }
        return parameters;
    }

    public double getCUBE_DX() {
        return CUBE_DX;
    }

    public void setCUBE_DX(double CUBE_DX) {
        this.CUBE_DX = CUBE_DX;
    }

    public double getCUBE_DY() {
        return CUBE_DY;
    }

    public void setCUBE_DY(double CUBE_DY) {
        this.CUBE_DY = CUBE_DY;
    }

    public double getCUBE_DZ() {
        return CUBE_DZ;
    }

    public void setCUBE_DZ(double CUBE_DZ) {
        this.CUBE_DZ = CUBE_DZ;
    }

    private double CUBE_DX = 1000;
    private double CUBE_DY = 1000;
    private double CUBE_DZ = 1000;
}
