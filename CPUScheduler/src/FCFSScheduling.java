import java.util.ArrayList;

public class FCFSScheduling extends SchedulingAlgorithm {

    public FCFSScheduling(ArrayList<PCB> processes) {
        super(processes);
    }

    public void removeProcess(PCB process) {
        processes.remove(process);
    }

    @Override
    public String getAlgorithmName() {
        return "First-Come First-Served";
    }

    @Override
    public ProcessExecutionResult executeProcesses() {
        processes.sort((p1, p2) -> {
            int priorityComparison = Integer.compare(p1.getArrivalTime(), p2.getArrivalTime());
            return priorityComparison;
        });
        ProcessExecutionResult result = new ProcessExecutionResult();
        totalTime = 0;
        for (PCB process : processes){
            if (totalTime < process.getArrivalTime()) {
                totalTime = process.getArrivalTime();
            }
            result.getExecutionSpans().add(result.new ProcessExecutionSpan(process.getPID(), totalTime));
            totalTime += process.getBurstTime();
            setTurnaroundTime(process);
            setWaitingTime(process);
            result.getPCBs().add(process);
        }

        result.setTotalExecutionTime(totalTime);
        return result;
    }
}