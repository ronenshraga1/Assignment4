public class TestBinaryRep {
    public static void main(String[] args) {
        BinaryNumber bn1 = new BinaryNumber(68);
        BinaryNumber bn2 = new BinaryNumber(3);
        BinaryNumber bnM1 = bn1.negate();
        BinaryNumber bnM2 = bn2.negate();

        //System.out.println(bnM5);
        System.out.println(bnM2.add(bnM1));
        BinaryNumber bn8 = new BinaryNumber(8);
    }
}
