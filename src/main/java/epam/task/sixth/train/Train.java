package epam.task.sixth.train;

public class Train extends Thread{
    private TrainState state = new HeadedToTunnelState();

    public TrainState getTrainState() {
        return state;
    }

    public void setTrainState(TrainState state) {
        this.state = state;
    }

    public void previousState(){
        state.previous(this);
    }
    public void nextState(){
        state.next(this);
    }
    public void printStatus(){
        state.printStatus();
    }
}
