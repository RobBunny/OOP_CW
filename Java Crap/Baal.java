class Baal {
    static int a;
    static int b;
    static {
        System.out.println("a: " + a + ", b: " + b);
    }
    {

        b++;
        System.out.println("b in block: " + b);
    }

    public Baal() {

        System.out.println("constructor");
    }

    public static void main(String[] args) {

        System.out.println("Some text.");
        Baal ob = new Baal();
        Baal ob2 = new Baal();

    }

}