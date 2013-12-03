package graph;

import bonds.Bond;
import org.jgrapht.UndirectedGraph;
import org.jgrapht.graph.SimpleGraph;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import particles.Particle;
import utils.IDGenerator;
import utils.Identifiable;

/**
 * User: alexeyk
 * Date: 03.12.13
 */
public class PolimerizationGraph implements Identifiable {

    private static final Logger log = LoggerFactory.getLogger(PolimerizationGraph.class.getName());

    private static final IDGenerator idGenerator = new IDGenerator();
    private final int id = idGenerator.nextID();

    public UndirectedGraph<Particle, Bond> graph;

    public PolimerizationGraph() {
        init();
    }

    private void init() {
        graph = new SimpleGraph<>(Bond.class);
    }

    @Override
    public int getID() {
        return id;
    }

    public void addBond(Bond bond) {
        graph.addVertex(bond.getPair().getObj1());
        graph.addVertex(bond.getPair().getObj2());
        graph.addEdge(bond.getPair().getObj1(), bond.getPair().getObj2(), bond);
    }


}
