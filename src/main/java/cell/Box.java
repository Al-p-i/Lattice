package cell;

import lattice.Lattice;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import particles.Particle;
import utils.IDGenerator;
import utils.Identifiable;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;

/**
 * User: alexeyk
 * Date: 01.12.13
 */
public class Box implements Cell, Identifiable {

    private static final Logger log = LoggerFactory.getLogger(Box.class.getName());

    private static final IDGenerator idGenerator = new IDGenerator();
    private final int id = idGenerator.nextID();

    private HashSet<Particle> particles;

    private Lattice lattice;

    private int x;
    private int y;
    private int z;

    public Box(Lattice lattice, int x, int y, int z) {
        assert x >= 0;
        assert y >= 0;
        assert z >= 0;

        this.particles = new HashSet<>();

        this.lattice = lattice;

        this.x = x;
        this.y = y;
        this.z = z;
    }

    public void addParticle(Particle particle) {
        particles.add(particle);
    }

    public Collection<Box> getNeighbours() {
        ArrayList<Box> neighbours = new ArrayList<>(27);

        int dx = lattice.getDX();
        int dy = lattice.getDY();
        int dz = lattice.getDZ();


        neighbours.add(lattice.getBox((x - 1 + dx) % dx, (y - 1 + dy) % dy, (z - 1 + dz) % dz));
        neighbours.add(lattice.getBox((x - 1 + dx) % dx, (y - 1 + dy) % dy, z));
        neighbours.add(lattice.getBox((x - 1 + dx) % dx, (y - 1 + dy) % dy, (z + 1) % dz));

        neighbours.add(lattice.getBox((x - 1 + dx) % dx, y, (z - 1 + dz) % dz));
        neighbours.add(lattice.getBox((x - 1 + dx) % dx, y, z));
        neighbours.add(lattice.getBox((x - 1 + dx) % dx, y, (z + 1) % dz));

        neighbours.add(lattice.getBox((x - 1 + dx) % dx, (y + 1) % dy, (z - 1 + dz) % dz));
        neighbours.add(lattice.getBox((x - 1 + dx) % dx, (y + 1) % dy, z));
        neighbours.add(lattice.getBox((x - 1 + dx) % dx, (y + 1) % dy, (z + 1) % dz));


        neighbours.add(lattice.getBox(x, (y - 1 + dy) % dy, (z - 1 + dz) % dz));
        neighbours.add(lattice.getBox(x, (y - 1 + dy) % dy, z));
        neighbours.add(lattice.getBox(x, (y - 1 + dy) % dy, (z + 1) % dz));

        neighbours.add(lattice.getBox(x, y, (z - 1 + dz) % dz));
        neighbours.add(lattice.getBox(x, y, z));
        neighbours.add(lattice.getBox(x, y, (z + 1) % dz));

        neighbours.add(lattice.getBox(x, (y + 1) % dy, (z - 1 + dz) % dz));
        neighbours.add(lattice.getBox(x, (y + 1) % dy, z));
        neighbours.add(lattice.getBox(x, (y + 1) % dy, (z + 1) % dz));


        neighbours.add(lattice.getBox((x + 1) % dx, (y - 1 + dy) % dy, (z - 1 + dz) % dz));
        neighbours.add(lattice.getBox((x + 1) % dx, (y - 1 + dy) % dy, z));
        neighbours.add(lattice.getBox((x + 1) % dx, (y - 1 + dy) % dy, (z + 1) % dz));

        neighbours.add(lattice.getBox((x + 1) % dx, y, (z - 1 + dz) % dz));
        neighbours.add(lattice.getBox((x + 1) % dx, y, z));
        neighbours.add(lattice.getBox((x + 1) % dx, y, (z + 1) % dz));

        neighbours.add(lattice.getBox((x + 1) % dx, (y + 1) % dy, (z - 1 + dz) % dz));
        neighbours.add(lattice.getBox((x + 1) % dx, (y + 1) % dy, z));
        neighbours.add(lattice.getBox((x + 1) % dx, (y + 1) % dy, (z + 1) % dz));

        return neighbours;
    }

    @Override
    public int getID() {
        return id;
    }

    @Override
    public Collection<Particle> getParticles() {
        return Collections.unmodifiableCollection(particles);
    }
}
