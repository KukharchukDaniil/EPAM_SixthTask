package epam.task.sixth.train.state;

import epam.task.sixth.train.Train;

public interface TrainState {
    void next(Train train);
    void previous(Train train);
    String getStatus();
}
