package InterviewCake;

import java.util.HashSet;
import java.util.Set;

public class SetProblems {

    public boolean getTwoMoviesToFillFlight(int[] movieLengths, int flightLength) {

        // movie lengths we've seen so far
        Set<Integer> movieLengthsSeen = new HashSet<Integer>();

        for (int firstMovieLength : movieLengths) {

            int matchingSecondMovieLength = flightLength - firstMovieLength;
            if (movieLengthsSeen.contains(matchingSecondMovieLength)) {
                return true;
            }

            movieLengthsSeen.add(firstMovieLength);
        }

        // we never found a match, so return false
        return false;
    }
}
