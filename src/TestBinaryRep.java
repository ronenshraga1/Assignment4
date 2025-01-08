public class TestBinaryRep {
    public static void main(String[] args) {
        BinaryRepresentation b1 = new BinaryRepresentation(); // <>
        b1.addFirst(Bit.ZERO); // <0>
        b1.addFirst(Bit.ZERO); // <00>
        b1.addFirst(Bit.ONE); // <001>
        b1.padding(10); // <0000000001>
        System.out.println(b1); // prints <0000000001>    }
    }
}
