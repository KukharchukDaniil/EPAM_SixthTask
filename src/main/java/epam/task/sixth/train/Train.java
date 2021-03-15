package epam.task.sixth.train;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import epam.task.sixth.Tunnel;
import epam.task.sixth.train.state.HeadedToTunnelState;
import epam.task.sixth.train.state.OutOfTunnelState;
import epam.task.sixth.train.state.TrainState;

@JsonIgnoreProperties({"trainState"})
@JsonPropertyOrder({ "direction", "trainName" })
public class Train extends Thread{
    @JsonIgnore
    private TrainState state = new HeadedToTunnelState();
    private String trainName;
    private TrainDirection direction;
    public Train() {
    }

    public Train(String trainName, TrainDirection direction) {
        this.trainName = trainName;
        this.direction = direction;
    }

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
    public String getStatus(){
        return state.getStatus();
    }

    public TrainDirection getDirection() {
        return direction;
    }

    @Override
    public void run() {
        super.run();
        Tunnel tunnel = Tunnel.getInstance();
        while(state.getClass() != OutOfTunnelState.class){
            tunnel.processTrain(this);
        }
    }

    public String getTrainName() {
        return trainName;
    }

    public void setTrainName(String trainName) {
        this.trainName = trainName;
    }
}
