import java.util.Arrays;

/**
 *  The <tt>ClosestPair</tt> data type computes a closest pair of points
 *  in a set of <em>N</em> points in the plane and provides accessor methods 
 *  for getting the closest pair of points and the distance between them.
 *  The distance between two points is their Euclidean distance.
 *  <p>
 *  This implementation uses a divide-and-conquer algorithm. 
 *  It runs in O(<em>N</em> log <em>N</em>) time in the worst case and uses
 *  O(<em>N</em>) extra space.
 *  <p>
 *  See also {@link FarthestPair}.
 *  <p>
 *  For additional documentation, see <a href="http://algs4.cs.princeton.edu/99hull">Section 9.9</a> of
 *  <i>Algorithms, 4th Edition</i> by Robert Sedgewick and Kevin Wayne.
 *
 *  @author Robert Sedgewick
 *  @author Kevin Wayne
 */
public class ClosestPair {

    // closest pair of points and their Euclidean distance
    private Point2D best1, best2;
    private double bestDistance = Double.POSITIVE_INFINITY;

    /**
     * Computes the closest pair of points in the specified array of points.
     *
     * @param  points the array of points
     * @throws NullPointerException if <tt>points</tt> is <tt>null</tt> or if any
     *         entry in <tt>points[]</tt> is <tt>null</tt>
     */
    public ClosestPair(Point2D[] points) {
        int N = points.length;
        if (N <= 1) return;

        // sort by x-coordinate (breaking ties by y-coordinate)
        Point2D[] pointsByX = new Point2D[N];
        for (int i = 0; i < N; i++)
            pointsByX[i] = points[i];
        Arrays.sort(pointsByX, Point2D.X_ORDER);

        // check for coincident points
        for (int i = 0; i < N-1; i++) {
            if (pointsByX[i].equals(pointsByX[i+1])) {
                bestDistance = 0.0;
                best1 = pointsByX[i];
                best2 = pointsByX[i+1];
                return;
            }
        }

        // sort by y-coordinate (but not yet sorted) 
        Point2D[] pointsByY = new Point2D[N];
        for (int i = 0; i < N; i++)
            pointsByY[i] = pointsByX[i];

        // auxiliary array
        Point2D[] aux = new Point2D[N];

        closest(pointsByX, pointsByY, aux, 0, N-1);
    }

    // find closest pair of points in pointsByX[lo..hi]
    // precondition:  pointsByX[lo..hi] and pointsByY[lo..hi] are the same sequence of points
    // precondition:  pointsByX[lo..hi] sorted by x-coordinate
    // postcondition: pointsByY[lo..hi] sorted by y-coordinate
    private double closest(Point2D[] pointsByX, Point2D[] pointsByY, Point2D[] aux, int lo, int hi) {
        if (hi <= lo) return Double.POSITIVE_INFINITY;

        int mid = lo + (hi - lo) / 2;
        Point2D median = pointsByX[mid];

        // compute closest pair with both endpoints in left subarray or both in right subarray
        double delta1 = closest(pointsByX, pointsByY, aux, lo, mid);
        double delta2 = closest(pointsByX, pointsByY, aux, mid+1, hi);
        double delta = Math.min(delta1, delta2);

        // merge back so that pointsByY[lo..hi] are sorted by y-coordinate
        merge(pointsByY, aux, lo, mid, hi);

        // aux[0..M-1] = sequence of points closer than delta, sorted by y-coordinate
        int M = 0;
        for (int i = lo; i <= hi; i++) {
            if (Math.abs(pointsByY[i].x() - median.x()) < delta)
                aux[M++] = pointsByY[i];
        }

        // compare each point to its neighbors with y-coordinate closer than delta
        for (int i = 0; i < M; i++) {
            // a geometric packing argument shows that this loop iterates at most 7 times
            for (int j = i+1; (j < M) && (aux[j].y() - aux[i].y() < delta); j++) {
                double distance = aux[i].distanceTo(aux[j]);
                if (distance < delta) {
                    delta = distance;
                    if (distance < bestDistance) {
                        bestDistance = delta;
                        best1 = aux[i];
                        best2 = aux[j];
                        // StdOut.println("better distance = " + delta + " from " + best1 + " to " + best2);
                    }
                }
            }
        }
        return delta;
    }

    /**
     * Returns one of the points in the closest pair of points.
     *
     * @return one of the two points in the closest pair of points;
     *         <tt>null</tt> if no such point (because there are fewer than 2 points)
     */
    public Point2D either() {
        return best1;
    }

    /**
     * Returns the other point in the closest pair of points.
     *
     * @return the other point in the closest pair of points
     *         <tt>null</tt> if no such point (because there are fewer than 2 points)
     */
    public Point2D other() {
        return best2;
    }

    /**
     * Returns the Eucliden distance between the closest pair of points.
     *
     * @return the Euclidean distance between the closest pair of points
     *         <tt>Double.POSITIVE_INFINITY</tt> if no such pair of points
     *         exist (because there are fewer than 2 points)
     */
    public double distance() {
        return bestDistance;
    }

    // is v < w ?
    private static boolean less(Comparable v, Comparable w) {
        return v.compareTo(w) < 0;
    }

    // stably merge a[lo .. mid] with a[mid+1 ..hi] using aux[lo .. hi]
    // precondition: a[lo .. mid] and a[mid+1 .. hi] are sorted subarrays
    private static void merge(Comparable[] a, Comparable[] aux, int lo, int mid, int hi) {
        // copy to aux[]
        for (int k = lo; k <= hi; k++) {
            aux[k] = a[k];
        }
    
        // merge back to a[] 
        int i = lo, j = mid+1;
        for (int k = lo; k <= hi; k++) {
            if      (i > mid)              a[k] = aux[j++];
            else if (j > hi)               a[k] = aux[i++];
            else if (less(aux[j], aux[i])) a[k] = aux[j++];
            else                           a[k] = aux[i++];
        }
    }



   /**
     * Unit tests the <tt>ClosestPair</tt> data type.
     * Reads in an integer <tt>N</tt> and <tt>N</tt> points (specified by
     * their <em>x</em>- and <em>y</em>-coordinates) from standard input;
     * computes a closest pair of points; and prints the pair to standard
     * output.
     */
    public static void main(String[] args) {
        int N = StdIn.readInt();
        Point2D[] points = new Point2D[N];
        for (int i = 0; i < N; i++) {
            double x = StdIn.readDouble();
            double y = StdIn.readDouble();
            points[i] = new Point2D(x, y);
        }
        ClosestPair closest = new ClosestPair(points);
        StdOut.println(closest.distance() + " from " + closest.either() + " to " + closest.other());
    }

}