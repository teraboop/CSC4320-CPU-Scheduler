import java.util.ArrayList;

public abstract class SchedulingAlgorithm {
    protected final ArrayList<PCB> processes;
    public SchedulingAlgorithm(ArrayList<PCB> processes) {
        this.processes = processes;
    }
    protected int totalTime = 0;

    public abstract ProcessExecutionResult executeProcesses();
    public abstract String getAlgorithmName();

    protected void setTurnaroundTime(PCB current) {
        current.setTurnaroundTime(totalTime - current.getArrivalTime());
    }

    protected void setWaitingTime(PCB current) {
        current.setWaitingTime(totalTime - current.getArrivalTime() - current.getBurstTime());
    }
}
