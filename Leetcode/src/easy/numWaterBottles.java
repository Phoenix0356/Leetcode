package easy;

public class numWaterBottles {
    public int numWaterBottles(int numBottles, int numExchange) {
        int emptyBottles = numBottles;
        while(emptyBottles >= numExchange){
            numBottles = numBottles + emptyBottles/numExchange;
            emptyBottles = emptyBottles/numExchange + emptyBottles%numExchange;
        }
        return numBottles;

    }
}
