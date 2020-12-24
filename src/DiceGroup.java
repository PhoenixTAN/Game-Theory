public class DiceGroup {
    
    private final int MAX_NUM = 6;
    private final int NUM_OF_DICES = 2;
    private int[] events;


    public DiceGroup() {
        events = new int[MAX_NUM * NUM_OF_DICES + 1];
    }

    public void combination(int currentSum, int currentDice) {
        
        if ( currentDice == 0 ) {
            return ;
        }

        for ( int i = 1; i <= MAX_NUM; i++ ) {
            events[currentSum + i]++;
            combination(currentSum + i, currentDice - 1);
        }

    }

    public int[] getEvents() {
        return events;
    }

    public float[] getProbabilities() {
        float totalNumOfEvents = 0;
        for ( int i = 1; i < events.length; i++ ) {
            totalNumOfEvents += events[i];
        }
        float[] probability = new float[events.length];
        for ( int i = 0; i < probability.length; i++ ) {
            probability[i] = events[i] / totalNumOfEvents;
        }
        return probability;
    }
    
    
    public static void main(String[] args) {

        DiceGroup dices = new DiceGroup();
        dices.combination(0, 2);
        float[] probability = dices.getProbabilities();
        for ( int i = 1; i < probability.length; i++ ) {
            System.out.println("i = " + i + ":  " + probability[i]);
        }

    }

}
