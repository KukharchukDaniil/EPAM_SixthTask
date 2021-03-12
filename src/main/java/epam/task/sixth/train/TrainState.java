package epam.task.sixth.train;

public interface TrainState {
    void next(Train train);
    void previous(Train train);
    void printStatus();
}
