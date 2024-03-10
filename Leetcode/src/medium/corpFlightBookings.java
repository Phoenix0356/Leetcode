package medium;

public class corpFlightBookings {
    public int[] corpFlightBookings(int[][] bookings, int n) {
        int[] flights = new int[n];
        for (int[] booking : bookings) {
            flights[booking[0]-1]+=booking[2];
            if (booking[1]<n) {
                flights[booking[1]] -= booking[2];
            }
        }

        for (int i=1;i<n;i++){
            flights[i]+=flights[i-1];
        }
        return flights;
    }
}
