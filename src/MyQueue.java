import java.util.ArrayList;

public class MyQueue<T> {

    private static int count = 0;

    public ArrayList<T> list;

    /***
     * Constructs a new queue
     */
    public MyQueue() {
        list = (ArrayList<T>) new ArrayList<T>();
    }

    /***
     * Checks if the queue is empty
     * @return - returns true or false
     */
    public final boolean isEmpty() {

        // TODO Auto-generated method stub
        //Check if the Queue is empty
        if (count == 0) {
            return true;
        }

        return false;
    }

    /***
     * Return item at the beginning of the queue
     * @return - returns the item removed
     */
    public final T dequeue() {

        // TODO Auto-generated method stub
        T itemRemoved = null;

        if (count != 0) {
            //if not empty decrement count and get removed item
            itemRemoved = this.list.remove(0);

            count--;
        } else {

            System.out.println("Cannot dequeue while MyQueue is empty");
        }

        return itemRemoved;
    }

    /***
     * Adds value to the end of our queue
     * @param item - item to add to our queue
     */
    public final void enqueue(final T item) {
        //if not add it to end
        //array[count] = item;
        this.list.add(item);
        count++;
    }

    /***
     * Create a string representation for queue
     */
    public final String toString() {
        String output = "";

        //Create a string representation for queue
        for (int i = 0; i < this.list.size(); i++) {
            output += this.list.get(i) + " ";
        }

        return output;
    }
}

