package subway.domain.path;

import java.util.List;
import org.jgrapht.graph.DefaultWeightedEdge;
import org.jgrapht.graph.WeightedMultigraph;
import subway.domain.Station;
import subway.domain.StationRepository;
import subway.utils.Constants;

public class DistanceGraphRepository {

    private static final WeightedMultigraph<Station, DefaultWeightedEdge> distanceGraph = new WeightedMultigraph<>(
        DefaultWeightedEdge.class);

    public static WeightedMultigraph<Station, DefaultWeightedEdge> distanceGraph() {
        return distanceGraph;
    }

    public static void addStation(Station station) {
        distanceGraph.addVertex(station);
    }

    public static void addAllStation() {
        for (Station station : StationRepository.stations()) {
            addStation(station);
        }
    }

    public static void setUpSection(Station station1, Station station2, int weight) {
        distanceGraph.setEdgeWeight(distanceGraph.addEdge(station1, station2), weight);
    }

    public static String findWeight(Station startStation, Station endStation) {

        for (List<String> info : Constants.DISTANCE_SECTION_LIST) {
            if (info.contains(startStation.getName()) && info.contains(endStation.getName())) {
                return info.get(2);
            }
        }
        return null;
    }
}
