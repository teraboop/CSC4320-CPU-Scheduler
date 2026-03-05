
import java.util.ArrayList;

public class ProcessExecutionResult {

    private final ArrayList<PCB> pcbs = new ArrayList<>();
    private final ArrayList<ProcessExecutionSpan> processExecutionSpans = new ArrayList<>();
    private int totalExecutionTime = 0;

    public ArrayList<PCB> getPCBs() {
        return pcbs;
    }

    public ArrayList<ProcessExecutionSpan> getExecutionSpans() {
        return processExecutionSpans;
    }

    public int getTotalExecutionTime() {
        return totalExecutionTime;
    }

    public void setTotalExecutionTime(int totalExecutionTime) {
        this.totalExecutionTime = totalExecutionTime;
    }

    public int getAverageTurnaroundTime() {
        int totalTurnaroundTime = 0;
        for (PCB pcb : pcbs) {
            totalTurnaroundTime += pcb.getTurnaroundTime();
        }
        return !pcbs.isEmpty() ? totalTurnaroundTime / pcbs.size() : 0;
    }

    public int getAverageWaitingTime() {
        int totalWaitingTime = 0;
        for (PCB pcb : pcbs) {
            totalWaitingTime += pcb.getWaitingTime();
        }
        return !pcbs.isEmpty() ? totalWaitingTime / pcbs.size() : 0;
    }

    public class ProcessExecutionSpan {

        private final int pid;
        private final int startTime;

        public ProcessExecutionSpan(int pid, int startTime) {
            this.pid = pid;
            this.startTime = startTime;
        }

        public int getPID() {
            return pid;
        }

        public int getStartTime() {
            return startTime;
        }
    }
}
