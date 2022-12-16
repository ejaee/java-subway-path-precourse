package subway.domain.path;

import java.util.List;
import org.jgrapht.alg.shortestpath.DijkstraShortestPath;
import org.jgrapht.graph.DefaultWeightedEdge;
import org.jgrapht.graph.WeightedMultigraph;
import subway.domain.Station;

public class ShortestPathFunction {
    private static DijkstraShortestPath<Station, DefaultWeightedEdge> shortestPath;

    public static List<Station> getPathList(WeightedMultigraph<Station, DefaultWeightedEdge> graph, Station startStation, Station endStation) {
        shortestPath = new DijkstraShortestPath<>(graph);

        return shortestPath.getPath(startStation, endStation).getVertexList();
    }

    public static double getPathWeight(Station startStation, Station endStation){
        return shortestPath.getPathWeight(startStation, endStation);
    }




//    public ShortestPathFunction(WeightedMultigraph<Station, DefaultWeightedEdge> connections) {
//        shortestPath = new DijkstraShortestPath<>(connections);
//    }
//
//    public static List<Station> getPathList(Station station1, Station station2) {
//        return shortestPath.getPath(station1, station2).getVertexList();
//    }
//
//    public static int getPathWeight(Station station1, Station station2) {
//        return (int)shortestPath.getPathWeight(station1, station2);
//    }
}
