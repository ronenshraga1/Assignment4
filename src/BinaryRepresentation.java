import java.util.Iterator;
import java.util.LinkedList;

public class BinaryRepresentation implements Iterable<Bit> {
    final private LinkedList<Bit> bits;
    private int numOfOnes;

    // Creates an empty BinaryRepresentation
    public BinaryRepresentation() {
        this.bits = new LinkedList<>();
        this.numOfOnes = 0;
    }

    // Task 1.3
    // Assumes other is a non-null BinaryRepresentation
    // Creates a copy of the other
    public BinaryRepresentation(BinaryRepresentation other) {
        this.bits = new LinkedList<>();
        if(other == null){
            throw new IllegalArgumentException("value is null");
        }
        Iterator<Bit> iterator = other.iterator();
        while (iterator.hasNext()){
            this.bits.add(iterator.next());
        }
    }

    // Task 1.1
    // Assumes bit is a non-null Bit
    // Adds the bit into the first position in this representation
    public void addFirst(Bit bit) {
        if (bit == null)
            throw new IllegalArgumentException("value is null");
        if(bit.toBoolean())
            this.numOfOnes = this.numOfOnes + 1;
        bits.addFirst(bit);
    }

    // Task 1.1
    // Assumes bit is a non-null Bit
    // Adds the bit into the last position in this representation
    public void addLast(Bit bit) {
        if (bit == null)
            throw new IllegalArgumentException("value is null");
//        Iterator<Bit> iterator = bits.iterator();
//        while (iterator.hasNext()){
//            newList.add(iterator.next());
//        }
        if(bit.toBoolean())
            this.numOfOnes = this.numOfOnes + 1;
        bits.addLast(bit);

    }

    // Task 1.1
    // Removes the first bit of the representation
    public Bit removeFirst() {
            Bit removedBit = bits.removeFirst();
            if(removedBit.toBoolean()){
                this.numOfOnes = this.numOfOnes - 1;
            }
        return  removedBit;
        }


    // Task 1.1
    // Removes the last bit of the representation
    public Bit removeLast() {
        Bit removedBit = bits.removeLast();
        if(removedBit.toBoolean()){
            this.numOfOnes = this.numOfOnes - 1;
        }
        return  removedBit;

    }

    // Task 1.4
    // Returns true if and only if the representation is a valid number, but not necessarly a minimal representation
    public boolean isLegalNumber() {
        if(this.bits.size() > 0 && (this.bits.getLast().equals(Bit.ZERO) || this.numOfOnes > 1)){
            return true;
        } else{
            return false;
        }
    }

    // Task 1.5
    // Returns true if and only if the representation is a valid minimal representation of a number
    public boolean isReduced() {
        if(isLegalNumber() && (isMinimal()||checkLastBits()||CheckIfLastBits1())){
            return true;
        } else {
            return false;
        }
    }
    //Returns true if representation if one of the special cases
    public boolean isMinimal(){
        boolean isMin = toString().equals("<11>") || toString().equals("<01>") || toString().equals("<0>") ;
        return isMin;
    }
    // returns true if size larger >= 3 and 2 last digits are 01 or 10
    public boolean checkLastBits(){
        boolean isLegal = false;
        if(this.bits.size() >=3){
             isLegal = (getLast() == Bit.ONE && this.bits.get(this.bits.size() - 2) == Bit.ZERO) ||
                    getLast() == Bit.ZERO && this.bits.get(this.bits.size() - 2) == Bit.ONE;
        }
        return isLegal;
    }
    // returns true if size larger >= 3 and 2 last digits are 01 or 10
    public boolean CheckIfLastBits1(){
        boolean isLegal = false;
        if(this.bits.size() >=3 && this.numOfOnes == 2){
            isLegal = (getLast() == Bit.ONE && this.bits.get(this.bits.size() - 2) == Bit.ONE);
        }
        return isLegal;
    }


    // Task 1.5
    // If the current representation is not a minimal representation of a number, reduces it to the minimal form
    public void reduce() {
        if(!isReduced()){
            //Iterator<Bit> iterator = this.bits.iterator();
            while (!isReduced()){
                removeLast();
            }
        }
    }

    // Task 1.6
    // Replaces each Bit in the representation with its negative
    public void complement() {
        Iterator<Bit> iterator = this.bits.iterator();
        int i =0;
        while (iterator.hasNext()){
            Bit value = iterator.next();
            this.bits.set(i,value.negate());
            i++;
        }
    }

    // Task 1.7
    // Adds a zero bit in the first position of the representation
    public void shiftLeft() {
        addFirst(Bit.ZERO);
    }

    // Task 1.7
    // Removes and returns the rightmost Bit of the representation if exists, and returns null if the representation is empty
    public Bit shiftRight() {
        if(this.bits.size() > 0){
            Bit removedBit = removeFirst();
            return removedBit;
        }else {
            return null;

        }
    }

    // Task 1.8
    // Pads this binary representation to the length newLength if it is larger than the current representation length
    // by adding the last Bit of the representation until reaching the desired length
    public void padding(int newLength) {
        Bit b = getLast();
        while (this.bits.size()<newLength){
            addLast(b);
        }
    }

    // Task 1.2
    // Returns a string of the bits of this representation surrounded by '<' and '>'
    public String toString() {
        String binaryNumber = "";
        Iterator<Bit> iterator = bits.iterator();
        while (iterator.hasNext()){
            binaryNumber = iterator.next().toString() + binaryNumber;
        }
        //binaryNumber = new StringBuilder(binaryNumber).reverse().toString();
        binaryNumber = "<" + binaryNumber + ">";
        return binaryNumber;
    }

    /*
     * =====================================================
     *                                        Do not change the following methods:
     * =====================================================
     */

     // Returns the last bit of this representation without removing it
    public Bit getLast() {
        return this.bits.get(this.bits.size() - 1);
    }

    // Returns the first bit of this representation without removing it
    public Bit getFirst() {
        return this.bits.get(0);
    }

    // Returns the number of ones in the representation
    public int getNumOfOnes() { return this.numOfOnes; }

    // Returns the number of bits in the representation
    public int length() {
        return this.bits.size();
    }

    // Returns the built-in iterator of java.util.LinkedList<T> for easier iteration over the representation
    public Iterator<Bit> iterator() {
        return this.bits.iterator();
    }
}
