package epam.task.sixth.train.state;

import epam.task.sixth.train.Train;

public class InTunnelState implements TrainState {
    public void next(Train train) {
        train.setTrainState(new OutOfTunnelState());
    }

    public void previous(Train train) {
        train.setTrainState(new HeadedToTunnelState());
    }

    public String getStatus() {
        return " is in the tunnel";
    }
}
