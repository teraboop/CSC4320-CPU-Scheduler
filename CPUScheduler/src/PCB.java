public class PCB {
    private int PID;
    private int arrivalTime;
    private int burstTime;
    private int remainingTime;
    private int priority;

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
    
}