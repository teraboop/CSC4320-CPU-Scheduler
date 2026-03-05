public class GanttChart {
    private String ganttTop = "";
    private String ganttBottom = "";
    private final ProcessExecutionResult result;
    public GanttChart(ProcessExecutionResult result){
        this.result = result;
        for (ProcessExecutionResult.ProcessExecutionSpan span : result.getExecutionSpans()) {
            makeGanttChartSegment(span.getPID(), span.getStartTime());
        }
    }

    private void makeGanttChartSegment(int pid, int startTime) {
        ganttTop += "| P" + pid + " ";
        ganttBottom += String.format("%-5d", startTime);       
    }

    public void printGanttChart() {
        System.out.println(ganttTop + "|");
        System.out.println(ganttBottom + result.getTotalExecutionTime());
        for (PCB pcb : result.getPCBs()) {
            System.out.println("Process " + pcb.getPID() + ": Waiting Time = " + pcb.getWaitingTime() + ", Turnaround Time = " + pcb.getTurnaroundTime());
        }
        System.out.println("Average Waiting Time: " + result.getAverageWaitingTime());
        System.out.println("Average Turnaround Time: " + result.getAverageTurnaroundTime());
    }
}
