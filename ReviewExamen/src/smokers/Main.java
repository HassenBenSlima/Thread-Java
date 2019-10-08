package smokers;

public class Main {

    public static void main(String[] args) {
        table smokingtable = new table();

        agent controlAgent = new agent(smokingtable);

        controlAgent.start();

        for (int i = 0; i < 3; i++)
        {
            // each smoker-thread gets the controlAgent, so the thread can wake up the agent and we don't have to do notifyAll();
            smoker smokerThread = new smoker(smokingtable, i, "Smoker " + Integer.toString(i+1), controlAgent);
            smokerThread.start();
        }
    }
}
