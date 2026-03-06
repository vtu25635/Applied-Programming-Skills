class MyCircularQueue {

    int[] queue;
    int front;
    int rear;
    int size;

    public MyCircularQueue(int k) {
        size = k;
        queue = new int[k];
        front = -1;
        rear = -1;
    }

    public boolean enQueue(int value) {
        if (isFull()) {
            return false;
        }

        if (isEmpty()) {
            front = 0;
        }

        rear = (rear + 1) % size;
        queue[rear] = value;
        return true;
    }

    public boolean deQueue() {
        if (isEmpty()) {
            return false;
        }

        if (front == rear) {
            front = -1;
            rear = -1;
        } else {
            front = (front + 1) % size;
        }

        return true;
    }

    public int Front() {
        if (isEmpty()) {
            return -1;
        }
        return queue[front];
    }

    public int Rear() {
        if (isEmpty()) {
            return -1;
        }
        return queue[rear];
    }

    public boolean isEmpty() {
        return front == -1;
    }

    public boolean isFull() {
        return (rear + 1) % size == front;
    }
}