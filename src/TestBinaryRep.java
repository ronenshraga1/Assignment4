public class TestBinaryRep {
    public static void main(String[] args) {
        BinaryNumber bn5 = new BinaryNumber(5); // 0101 (5)
        BinaryNumber bnM5 = bn5.negate(); // 1011 (-5)
        BinaryNumber bn4 = new BinaryNumber(4); // 0100 (4)
        BinaryNumber bnM20 = bnM5.multiply(bn4); // 101100 (-20)
        System.out.println(bnM20.toInt()); // prints -20
    }
}
