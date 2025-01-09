public class TestBinaryRep {
    public static void main(String[] args) {
        BinaryNumber bn1 = new BinaryNumber(68);
       // BinaryNumber bn2 = new BinaryNumber(3);
//        BinaryNumber bnM1 = bn1.negate();
//        BinaryNumber bnM2 = bn2.negate();
        BinaryNumber bn5 = new BinaryNumber (5); // 0101 (5)
        BinaryNumber bn3 = new BinaryNumber (3); // 011 (3)
        BinaryNumber bnM2 = bn3.subtract(bn5); // 110 (-2)
        BinaryNumber bn2 = bn5.subtract(bn3); // 010 (2)
        System.out.println(bn2); // prints 010
        System.out.println(bnM2.subtract(bn2)); // prints 1100
        //System.out.println(bnM5);
//        System.out.println(bnM2.add(bnM1));
//        BinaryNumber bn8 = new BinaryNumber(8);
    }
}
