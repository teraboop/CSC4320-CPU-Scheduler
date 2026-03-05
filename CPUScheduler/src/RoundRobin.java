
import java.util.ArrayDeque;
import java.util.ArrayList;

public class RoundRobin extends SchedulingAlgorithm {

    private final int timeQuantum;

    public RoundRobin(ArrayList<PCB> processes, int timeQuantum) {
        super(processes);
        this.timeQuantum = timeQuantum;
    }

    @Override
    public String getAlgorithmName() {
        return "Round Robin (Quantum: " + timeQuantum + ")";
    }

    @Override
    public ProcessExecutionResult executeProcesses() {
        ProcessExecutionResult result = new ProcessExecutionResult();
        totalTime = 0;
        processes.sort((p1, p2) -> Integer.compare(p1.getArrivalTime(), p2.getArrivalTime()));

        ArrayDeque<PCB> readyQueue = new ArrayDeque<>();
        int index = 0;

        while (index < processes.size() || !readyQueue.isEmpty()) {
            if (readyQueue.isEmpty()) {
                PCB next = processes.get(index);
                if (totalTime < next.getArrivalTime()) {
                    totalTime = next.getArrivalTime();
                }
                readyQueue.addLast(next);
                index++;
            }

            while (index < processes.size() && processes.get(index).getArrivalTime() <= totalTime) {
                readyQueue.addLast(processes.get(index));
                index++;
            }

            PCB process = readyQueue.removeFirst();
            int startTime = totalTime;
            int runTime = Math.min(timeQuantum, process.getRemainingTime());

            result.getExecutionSpans().add(result.new ProcessExecutionSpan(process.getPID(), startTime));
            process.setRemainingTime(process.getRemainingTime() - runTime);
            totalTime += runTime;

            while (index < processes.size() && processes.get(index).getArrivalTime() <= totalTime) {
                readyQueue.addLast(processes.get(index));
                index++;
            }

            if (process.getRemainingTime() > 0) {
                readyQueue.addLast(process);
            } else {
                setTurnaroundTime(process);
                setWaitingTime(process);
                result.getPCBs().add(process);
            }
        }

        result.setTotalExecutionTime(totalTime);
        return result;
    }

}
