package epam.task.sixth.train;

import java.util.ArrayList;
import java.util.List;

public class Trains {
    private List<Train> trainList = new ArrayList<Train>();

    public Trains() {
    }

    public Trains(List<Train> trainList) {
        this.trainList = trainList;
    }

    public List<Train> getTrainList() {
        return trainList;
    }

    public void setTrainList(List<Train> trainList) {
        this.trainList = trainList;
    }
    public int size(){
        return trainList.size();
    }
}
