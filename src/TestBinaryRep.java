public class TestBinaryRep {
    public static void main(String[] args) {
        BinaryNumber bn3 = new BinaryNumber(3); // 011 (3)
        BinaryNumber bn5 = new BinaryNumber(5); // 0101 (5)
        BinaryNumber bn8 = new BinaryNumber(8); // 01000 (8)
       // System.out.println(bn3.add(bn5)); // prints 01000 which is the
        // minimal binary representation
// of 8.
        System.out.println(bn8.add(bn3)); // prints 01011 which is the
    }
}
