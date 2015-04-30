package test;

public final class FinalDemo {
    private int temp = 5;

    private void setTemp(int t) {
        this.temp = t;
    }

    public static void main(String[] args) {
        FinalDemo fDemo = new FinalDemo();
        fDemo.setTemp(0);
        System.out.println(fDemo.temp);
    }
}
