public class RoundRobin {
    private class Node{
        PCB process;
        Node next;

    }
    int timeQuantum;
    Node head;
    Node tail;
    public RoundRobin(int timeQuantum) {
        this.timeQuantum = timeQuantum;
        this.head = null;
        this.tail = null;
    }
    public void removeNode(Node nodeToRemove) {
        if (head == null) {
            return;
        }
        if (head == nodeToRemove) {
            head = head.next;
            tail.next = head;
            return;
        }
        Node current = head;
        while (current.next != nodeToRemove) {
            current = current.next;
        }
        if (current.next == nodeToRemove) {
            current.next = nodeToRemove.next;
            if (nodeToRemove == tail) {
                tail = current;
            }
        }
    }
    public void setTimeQuantum() {
        int newTimeQuantum = 0;
        int totalBurstTime = 0;
        int processCount = 0;
        Node current = head;
        if(current == null) {
            this.timeQuantum = 1;
            return;
        }
        while (current != tail) {
            totalBurstTime += current.process.getBurstTime();
            processCount++;
            current = current.next;
        }
        if(processCount > 0) {
            newTimeQuantum = totalBurstTime / processCount;
        }
        this.timeQuantum = newTimeQuantum;
    }
    public void addProcess(PCB process){
        Node newNode = new Node();
        newNode.process = process;
        newNode.next = null;
        if(head == null){
            head = newNode;
            tail = newNode;
        }else{
            tail.next = newNode;
            tail = newNode;
        }
        tail.next = head;
    }
    public void executeProcesses(){
        setTimeQuantum();
        Node current = head;
        while(current != null){
            PCB process = current.process;
            if(process.getRemainingTime() > 0){
                if(process.getRemainingTime() > timeQuantum){
                    process.setRemainingTime(process.getRemainingTime() - timeQuantum);
                }else{
                    process.setRemainingTime(0);
                    System.out.println("Process " + process.getPID() + " completed.");
                    removeNode(current);
                }
            }
            current = current.next;
            if(current == head) {
                break;
            }
        }
    }

}
