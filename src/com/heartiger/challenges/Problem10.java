/*

This problem was asked by Twitter.

You run an e-commerce website and want to record the last N order ids in a log. Implement a data structure to accomplish this, with the following API:

    record(order_id): adds the order_id to the log
    get_last(i): gets the ith last element from the log. i is guaranteed to be smaller than or equal to N.

You should be as efficient with time and space as possible.

 */
public class Problem10 {

    private int head;
    private int counter;
    private int[] nums;

    public Problem10(int capacity){
        this.nums = new int[capacity];
        this.counter = -1;
    }

    public void record(int order_id){
        this.updateInsertIndex();
        this.nums[this.counter] = order_id;
    }

    public int get_last(int index){
        if(index > this.nums.length){
            throw new IndexOutOfBoundsException();
        }
        int indexToReturn = (this.head + (this.nums.length + index - 1))%this.nums.length;
        return nums[indexToReturn];
    }

    private void updateInsertIndex() {
        this.counter++;
        if(this.counter >= this.nums.length){
            this.counter = this.counter % nums.length;
        }
        if(this.counter == this.head){
            this.head++;
        }
    }

    private void printArray(){
        for(int item: nums){
            System.out.print(item + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Problem10 logContainer = new Problem10(5);
        for(int i=1; i<= 5; i++){
            logContainer.record(i);
        }

        assert logContainer.get_last(1) == 1: "Test 1 Faield";
        assert logContainer.get_last(5) == 5: "Test 2 Failed";

        for(int i=6; i<= 10; i++){
            logContainer.record(i);
        }

        assert logContainer.get_last(1) == 6: "Test 1 Faield";
        assert logContainer.get_last(5) == 10: "Test 2 Failed";
    }
}
