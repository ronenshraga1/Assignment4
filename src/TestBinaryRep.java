public class TestBinaryRep {
    public static void main(String[] args) {
        BinaryNumber bn9 = new BinaryNumber("-9"); // 01001
        System.out.println(bn9.toInt()); // prints 9
        BinaryNumber fib100 = new BinaryNumber("-354224848179261915075");
//0100110011001111011011011101101010011111000101100101001011111111000011
        System.out.println(fib100.toIntString());    }
}
