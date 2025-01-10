public class TestBinaryRep {
    public static void main(String[] args) {
        BinaryNumber bn25 = new BinaryNumber("25"); // 011001 (25)
        BinaryNumber bnM25 = new BinaryNumber("-25"); // 100111 (-25)
        System.out.println(bn25.toInt()); // prints 25
        System.out.println(bnM25.toInt()); // prints -25
    }
}
