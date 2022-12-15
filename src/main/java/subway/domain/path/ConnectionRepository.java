package subway.domain.path;

import org.jgrapht.graph.DefaultWeightedEdge;
import org.jgrapht.graph.WeightedMultigraph;
import subway.domain.Station;

public class ConnectionRepository {

    private static final WeightedMultigraph<Station, DefaultWeightedEdge> connections = new WeightedMultigraph<>(
        DefaultWeightedEdge.class);

    public static WeightedMultigraph<Station, DefaultWeightedEdge> connections() {
        return connections;
    }

    public static void addStation(Station station) {
        connections.addVertex(station);
    }

    public static void setUpSection(Station station1, Station station2, int weight) {
        connections.setEdgeWeight(connections.addEdge(station1, station2), weight);
    }



}
