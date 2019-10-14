package okelloSoftwarez;

public class Stack {
    private int [] elements;
    private int size;
    public static final int DEFAULT_CAPACITY = 16;

    public Stack() {
        this(DEFAULT_CAPACITY);
    }

    public Stack(int capacity) {
        elements = new int[capacity];
    }
    /**
     * it adds a value on top of the stack
     */
    public void push(int value){
        if (size >= elements.length){
            int [] temp = new int[elements.length*2];
            System.arraycopy(elements,0,temp,0,elements.length);
            elements = temp;
        }
        elements[size++] = value ;
    }
    /**
     * Removes the top value of the stack
     */
    public int pop (){
        return elements[--size];
    }
    /**
     * Returns the top value of the stack
     */
    public int peek (){
        return elements[size-1];
    }
    /**
     * checks if the stack is empty
     */
    public boolean empty(){
        return size == 0 ;
    }

    public int getSize() {
        return size;
    }
}
