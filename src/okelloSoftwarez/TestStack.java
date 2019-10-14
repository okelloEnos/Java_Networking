package okelloSoftwarez;

public class TestStack {
    public static void main(String[] args) {
        Stack reverseNum = new Stack();
        for (int i = 0; i<10;i++){
            reverseNum.push(i);
        }
        while (!reverseNum.empty()){
            System.out.print(reverseNum.pop() + " ");
        }
    }
}
