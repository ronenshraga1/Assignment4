public class TestBinaryRep {
    public static void main(String[] args) {
        BinaryNumber bn9 = new BinaryNumber(9); // 01001 (9)
        BinaryNumber bnM9 = bn9.negate(); // 10111 (-9)
        BinaryNumber bn3 = new BinaryNumber(4); // 011 (3)
        BinaryNumber bn2 = new BinaryNumber(2); // 010 (2)
        BinaryNumber bnM3 = bnM9.divide(bn3); // 101 (-3)
        BinaryNumber bnM4 = bnM9.divide(bn2); // 1100 (-4)
        System.out.println(bnM3.toInt()); // prints -3
        System.out.println(bnM4.toInt()); // prints -4    }
    }
}
