class MyCircularQueue {

  /** Initialize your data structure here. Set the size of the queue to be k. */
  int[] queue;
  int start;
  int end;
  int k;
  public MyCircularQueue(int k) {
    this.k = k;
    queue = new int[k];
    start = 0;
    end = 0;
    Arrays.fill(queue, -1);
  }

  /** Insert an element into the circular queue. Return true if the operation is successful. */
  public boolean enQueue(int value) {
    if (end == start && queue[end] != -1) {
      return false;
    }
    queue[end++] = value;
    if (end == k) {
      end = 0;
    }
    return true;
  }

  /** Delete an element from the circular queue. Return true if the operation is successful. */
  public boolean deQueue() {
    if (queue[start] == -1) {
      return false;
    }
    queue[start++] = -1;
    if (start == k) {
      start = 0;
    }
    return true;
  }

  /** Get the front item from the queue. */
  public int Front() {
    return queue[start];
  }

  /** Get the last item from the queue. */
  public int Rear() {
    return end == 0 ? queue[k - 1] : queue[end - 1];
  }

  /** Checks whether the circular queue is empty or not. */
  public boolean isEmpty() {
    return start == end && queue[end] == -1;
  }

  /** Checks whether the circular queue is full or not. */
  public boolean isFull() {
    return start == end && queue[end] != -1;
  }
}