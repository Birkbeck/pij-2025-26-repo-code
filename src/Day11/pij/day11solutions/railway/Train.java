package pij.day11solutions.railway;

import java.util.List;

public class Train extends RailwayRollingStock {

    private Locomotive locomotive;
    private List<Carriage> carriages;

    public Train(Locomotive locomotive, List<Carriage> carriages) {
        super(locomotive.getGaugeMM()); // implicitly checks locomotive != null
        // TODO add check that carriages neither is not contains null
        // TODO add check that carriages is not empty
        // TODO add check that all gauges must be identical (or "close enough")
        this.locomotive = locomotive;
        this.carriages = List.copyOf(carriages);
    }

    public Locomotive getLocomotive() {
        return locomotive;
    }

    public List<Carriage> getCarriages() {
        return carriages;
    }
}
