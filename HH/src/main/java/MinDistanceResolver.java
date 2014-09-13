import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static java.lang.Math.*;

public class MinDistanceResolver {

    private static class Point implements Comparable<Point> {
        private double x;
        private double y;

        Point(double x, double y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public int compareTo(Point p) {
            return (int) (x == p.x ? round(y - p.y) : round(x - p.x));
        }

        public double calculateDistanceTo(Point p) {
            return sqrt(pow(x - p.x, 2) + pow(y - p.y, 2));
        }
    }

    private ArrayList<Point> points = new ArrayList<>();
    private double tempMinDistance;

    public void addPoint(double x, double y) {
        points.add(new Point(x, y));
    }

    public double getMinimumDistance() {
        double minDistance = -1;
        if (points.size() > 1) {
            initMinDistance();
            Collections.sort(points);
            calculateMinDistance(0, points.size() - 1);
            minDistance = tempMinDistance;
        }
        points.clear();
        return minDistance;
    }

    private void initMinDistance() {
        tempMinDistance = points.get(0).calculateDistanceTo(points.get(1));
    }

    private void calculateMinDistance(int left, int right) {
        if (right - left <= 1) {
            if (right != left) {
                updateMinDistance(points.get(left).calculateDistanceTo(points.get(right)));
            }
            return;
        }

        int middle = (right + left) / 2;
        calculateMinDistance(left, middle);
        calculateMinDistance(middle + 1, right);

        union(middle);
    }

    private void union(int middle) {
        int left, right;
        for (left = middle - 1; left >= 0 && points.get(middle).x - points.get(left).x < tempMinDistance; left--) ;
        for (right = middle + 1; right < points.size() && points.get(middle).x - points.get(right).x < tempMinDistance; right++)
            ;

        List<Point> leftSubList = points.subList(left + 1, middle + 1);
        List<Point> rightSubList = points.subList(middle + 1, right);

        Collections.sort(leftSubList);
        Collections.sort(rightSubList);

        for (int k = 0; k < leftSubList.size(); k++) {
            for (int n = 0; n < rightSubList.size() && abs(leftSubList.get(k).y - rightSubList.get(n).y) <= tempMinDistance; n++) {
                updateMinDistance(leftSubList.get(k).calculateDistanceTo(rightSubList.get(n)));
            }
        }
    }

    private void updateMinDistance(double currentDistance) {
        if (currentDistance < tempMinDistance) {
            tempMinDistance = currentDistance;
        }
    }
}
