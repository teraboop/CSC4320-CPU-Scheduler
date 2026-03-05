
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class App {

    public static void main(String[] args) throws Exception {
        SchedulingAlgorithm[] algorithms = {
            new RoundRobin(readFile("processes.txt"), 2),
            new FCFSScheduling(readFile("processes.txt"))
        };
        for (SchedulingAlgorithm algorithm : algorithms) {
            ProcessExecutionResult results = algorithm.executeProcesses();
            System.out.println("Algorithm: " + algorithm.getAlgorithmName());
            GanttChart chart = new GanttChart(results);
            chart.printGanttChart();
            System.out.println("================================");
        }
    }

    private static ArrayList<PCB> readFile(String fileName) throws IOException {
        ArrayList<PCB> processes = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] split = line.split("\\s+");
                if (split.length == 4) {
                    String pidString = split[0];
                    String arrivalTimeString = split[1];
                    String burstTimeString = split[2];
                    String priorityString = split[3];
                    if (isNumeric(pidString) && isNumeric(arrivalTimeString) && isNumeric(burstTimeString)
                            && isNumeric(priorityString)) {
                        processes.add(new PCB(Integer.parseInt(pidString), Integer.parseInt(arrivalTimeString),
                                Integer.parseInt(burstTimeString), Integer.parseInt(priorityString)));
                    }
                }
            }
        }
        return processes;
    }

    private static boolean isNumeric(String str) {
        return str.matches("\\d+");
    }
}
