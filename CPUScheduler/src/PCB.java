public class PCB {
    final private int PID;
    final private int arrivalTime;
    final private int burstTime;
    final private int priority;
    private int remainingTime;
    private int waitingTime;
    private int turnaroundTime;


    public PCB(int PID, int ArrivalTime, int BurstTime, int priority) {
        this.PID = PID;
        this.arrivalTime = ArrivalTime;
        this.burstTime = BurstTime;
        this.remainingTime = BurstTime;
        this.priority = priority;
    }

    public int getPID() {
        return PID;
    }

    public int getArrivalTime() {
        return arrivalTime;
    }

    public int getBurstTime() {
        return burstTime;
    }

    public int getRemainingTime() {
        return remainingTime;
    }

    public void setRemainingTime(int remainingTime) {
        this.remainingTime = remainingTime;
    }

    public int getPriority() {
        return priority;
    }

    public int getWaitingTime() {
        return waitingTime;
    }

    public void setWaitingTime(int waitingTime) {
        this.waitingTime = waitingTime;
    }

    public int getTurnaroundTime() {
        return turnaroundTime;
    }

    public void setTurnaroundTime(int turnaroundTime) {
        this.turnaroundTime = turnaroundTime;
    }

}