package epam.task.sixth;

import epam.task.sixth.train.state.OutOfTunnelState;
import epam.task.sixth.train.Train;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Tunnel {
    private static Tunnel instance;
    private Integer trainsCounter = 0;
    private Integer trainsProcessed = 0;
    private Integer trainsValue = 0;
    private static Lock lock = new ReentrantLock();
    private Deque<Train> tunnelDeque = new ArrayDeque<Train>();

    private Tunnel() {
    }



    public static Tunnel getInstance() {
        if (instance == null) {
            lock.lock();
            if (instance == null) {
                instance = new Tunnel();
            }
            lock.unlock();
        }
        return instance;
    }

    private boolean isBusy() {
        return tunnelDeque.size() == 3;
    }

    private void trainsToNextStage() {
        for (Train element : tunnelDeque) {
            element.nextState();
            if (element.getTrainState() instanceof OutOfTunnelState) {
                tunnelDeque.remove(element);
            }
            trainsProcessed++;
            System.out.println(element.getTrainName() + element.getStatus() + " " + element.getDirection());
        }
    }
    private void passTrain(Train train){
        Train lastTrain;
        if (!tunnelDeque.isEmpty()) {
            lastTrain = tunnelDeque.getLast();
            if (lastTrain.getDirection() == train.getDirection() && tunnelDeque.size() < 3) {
                tunnelDeque.addLast(train);
                train.nextState();
                trainsCounter++;
            }
        } else {
            tunnelDeque.addLast(train);
            train.nextState();
            trainsCounter++;
        }
    }
    public void processTrain(Train train) {
        lock.lock();
        if (trainsCounter == 3 || trainsValue-trainsProcessed <= 3) {
            trainsToNextStage();
            trainsCounter = 0;
        }
        if(!tunnelDeque.contains(train) && train.getTrainState().getClass() != OutOfTunnelState.class) {
            passTrain(train);
        }
        lock.unlock();

    }

    public void setTrainsValue(Integer trainsValue) {
        this.trainsValue = trainsValue;
    }
}
