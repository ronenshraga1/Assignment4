public class TestBinaryRep {
    public static void main(String[] args) {
        BinaryNumber bn1 = new BinaryNumber(68);
       // BinaryNumber bn2 = new BinaryNumber(3);
//        BinaryNumber bnM1 = bn1.negate();
//        BinaryNumber bnM2 = bn2.negate();
        BinaryNumber bn5 = new BinaryNumber(5); // 0101 (5)
        BinaryNumber bn4 = new BinaryNumber(4); // 0100 (4)
        BinaryNumber bn4a = new BinaryNumber(4); // 0100 (4)
        System.out.println(bn5.compareTo(bn4)); // prints 1
        System.out.println(bn4.compareTo(bn4a)); // prints 0
        System.out.println(bn4.compareTo(bn5)); // print -1//        BinaryNumber bn8 = new BinaryNumber(8);
    }
}
