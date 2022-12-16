package subway.domain.path;

import java.util.List;
import subway.domain.Station;

public class Path {
    private final List<Station> path;

    private Path(List<Station> path) {
        this.path = path;
    }

    public static Path from(List<Station> path) {
        return new Path(path);
    }

    public List<Station> getPath() {
        return path;
    }

    public int getFullDistance(){
        int sum = 0;

        for (int i = 1; i < path.size(); ++i ) {
            sum += Integer.parseInt(DistanceGraphRepository.findWeight(path.get(i - 1), path.get(i)));
        }

        return sum;
    }

    public int getFullTime() {
        int sum = 0;

        for (int i = 1; i < path.size(); ++i ) {
            sum += Integer.parseInt(TimeGraphRepository.findWeight(path.get(i - 1), path.get(i)));
        }

        return sum;
    }


}
