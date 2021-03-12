package epam.task.sixth;

import epam.task.sixth.train.Train;

import java.util.ArrayDeque;
import java.util.Deque;

public class Tunnel extends Thread{
    private Deque<Train> tunnelDeque = new ArrayDeque<Train>();
    private Tunnel(){};
    public Tunnel getInstance(){};
}
