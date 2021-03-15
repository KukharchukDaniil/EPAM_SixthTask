package epam.task.sixth.train.state;

import epam.task.sixth.train.Train;

public class OutOfTunnelState implements TrainState {
    public void next(Train train) {
        train.setTrainState(new InTunnelState());
    }

    public void previous(Train train) {
        throw new IllegalStateException();
    }

    public String getStatus() {
        return " have passed the tunnel";
    }
}
