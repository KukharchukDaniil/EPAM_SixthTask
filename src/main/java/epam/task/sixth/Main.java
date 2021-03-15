package epam.task.sixth;
import com.fasterxml.jackson.databind.ObjectMapper;
import epam.task.sixth.train.Train;
import epam.task.sixth.train.Trains;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) throws IOException, ExecutionException, InterruptedException {
        ObjectMapper objectMapper = new ObjectMapper();
        Trains trains = objectMapper.readValue(new File("src\\input.json"), Trains.class);
        Tunnel tunnel = Tunnel.getInstance();
        tunnel.setTrainsValue(trains.size());
        ExecutorService executorService = Executors.newFixedThreadPool(trains.size());
        List<Train> trainList = trains.getTrainList();
        List<Future> futures =  trainList.stream().map(executorService::submit).collect(Collectors.toList());
        for (Future future : futures) {
            future.get();
        }
        executorService.shutdown();
    }

}
