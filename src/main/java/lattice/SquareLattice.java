package lattice;

import cell.Box;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import particles.Particle;
import utils.Debug;
import utils.IDGenerator;
import utils.Identifiable;

import java.util.Collection;
import java.util.HashSet;

/**
 * User: alpi
 * Date: 01.12.13
 */
public class SquareLattice implements Lattice, Identifiable {

    private static final Logger log = LoggerFactory.getLogger(SquareLattice.class.getName());

    private static final IDGenerator idGenerator = new IDGenerator();
    private final int id = idGenerator.nextID();

    private double period;
    private Box[][][] boxes;

    private int dx;
    private int dy;
    private int dz;

    @Debug
    private int nOfActiveBoxes;


    public SquareLattice(int dx, int dy, int dz, double period) {
        assert period > 0;

        this.dx = dx;
        this.dy = dy;
        this.dz = dz;

        this.period = period;
        this.boxes = new Box[dx][dy][dz];
    }

    @Override
    public void addParticles(Collection<Particle> particles) {
        for (Particle particle : particles) {
            getBox(particle).addParticle(particle);
        }
    }

    @Override
    public int getDX() {
        return dx;
    }

    @Override
    public int getDY() {
        return dy;
    }

    @Override
    public int getDZ() {
        return dz;
    }

    @Override
    public int getID() {
        return id;
    }

    @Override
    public Box getBox(Particle particle) {
        int x = (int) Math.floor(particle.getX() / period);
        int y = (int) Math.floor(particle.getY() / period);
        int z = (int) Math.floor(particle.getZ() / period);

        if (boxes[x][y][z] == null) {
            boxes[x][y][z] = new Box(this, x, y, z);
            nOfActiveBoxes++;
        }

        return boxes[x][y][z];
    }

    @Override
    public Box getBox(int xGridIndex, int yGridIndex, int zGridIndex) {
        assert xGridIndex >= 0;
        assert yGridIndex >= 0;
        assert zGridIndex >= 0;
        assert xGridIndex < dx;
        assert yGridIndex < dy;
        assert zGridIndex < dz;


        return boxes[xGridIndex][yGridIndex][zGridIndex];
    }

    @Override
    public Collection<Particle> getNeighbours(Particle particle) {
        HashSet<Particle> neighbours = new HashSet<>();
        for (Box neighbourBox : getBox(particle).getNeighbours()) {
            if (neighbourBox != null)
                neighbours.addAll(neighbourBox.getParticles());

            neighbours.remove(particle);
        }
        return neighbours;
    }


    public int getNOfActiveBoxes() {
        return nOfActiveBoxes;
    }
}
