package epam.task.sixth.train;

public class InTunnelState implements TrainState {
    public void next(Train train) {
        train.setTrainState(new OutOfTunnelState());
    }

    public void previous(Train train) {
        train.setTrainState(new HeadedToTunnelState());
    }

    public void printStatus() {

    }
}
