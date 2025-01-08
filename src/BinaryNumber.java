public class BinaryNumber implements Comparable<BinaryNumber> {
    final private BinaryRepresentation rep;

    // Task 2.1
    // Assumes n is non-negative
    // Initializes a BinaryNumber representing n
    public BinaryNumber(int n) {
        throw new UnsupportedOperationException("Delete this line and implement the method.");
    }

    // Assumes other is a non-null BinaryNumber
    // Initializes a copy of other
    public BinaryNumber(BinaryNumber other) {
        this.rep = new BinaryRepresentation(other.rep);
    }

    // Task 2.12
    // Assumes s is a string representing a valid number, either positive or negative
    // Initializes a BinaryNumber representing the number described in s
    public BinaryNumber(String s) {
        throw new UnsupportedOperationException("Delete this line and implement the method.");
    }

    // Task 2.4
    // Assumes other is non-null BinaryNumber
    // Returns a new BinaryNumber containing the result of the addition of other to this (i.e. this + other)
    public BinaryNumber add(BinaryNumber other) {
        throw new UnsupportedOperationException("Delete this line and implement the method.");
    }


    // Task 2.5
    // Returns a new BinaryNumber that represents the Additive Inverse of this, that is, if this equals X, the return value is -X
    public BinaryNumber negate() {
        throw new UnsupportedOperationException("Delete this line and implement the method.");
    }

    // Task 2.6
    // Assumes other is non-null BinaryNumber
    // Returns a new BinaryNumber containing the result of the subtraction of other from this (i.e. this - other)
    public BinaryNumber subtract(BinaryNumber other) {
        throw new UnsupportedOperationException("Delete this line and implement the method.");
    }

    // Task 2.7
    // Returns 1 if the number represented by this object is positive, -1 if it negative and 0 if it equals 0
    public int signum() {
        throw new UnsupportedOperationException("Delete this line and implement the method.");
    }

    // Task 2.10
    // Assumes other is non-null BinaryNumber which is positive
    // Returns a new BinaryNumber containing the result of the multiplication of other and this (i.e. this * other)
    private BinaryNumber multiplyPositive(BinaryNumber other) {
        throw new UnsupportedOperationException("Delete this line and implement the method.");
    }

    // Task 2.10
    // Assumes other is non-null BinaryNumber
    // Returns a new BinaryNumber containing the result of the multiplication of other and this (i.e. this * other)
    public BinaryNumber multiply(BinaryNumber other) {
        throw new UnsupportedOperationException("Delete this line and implement the method.");
    }

    // Task 2.11
    // Assumes other is non-null BinaryNumber
    // Returns a new BinaryNumber containing the result of the integer-division of other from this (i.e. this / other)
    public BinaryNumber divide(BinaryNumber other) {
        throw new UnsupportedOperationException("Delete this line and implement the method.");
    }

    // Task 2.2
    // Assumes this object represents a legal binary number
    // Returns the represention of this BinaryNumber as a binary string, that is, all the chars are either 0 or 1
    public String toString() {
        if (!isLegal()) {
            throw new IllegalArgumentException("Illegal Number");
        }

        throw new UnsupportedOperationException("Delete this line and implement the method.");
    }

    // Task 2.3
    // Returns true if and only if this and other represent the same number
    public boolean equals(Object other) {
        return super.equals(other); // This is the default implementation of equals
    }

    // Task 2.8
    // Returns a positive number if this object represents a number bigger than the one other represents,
    // 0 if they are equal, and a negative number if it is smaller.
    public int compareTo(BinaryNumber other) {
        throw new UnsupportedOperationException("Delete this line and implement the method.");
    }

    // Task 2.9
    // Assumes this current number is small enough to be represented by an int
    // Returns the int value of the number represented by this
    public int toInt() {
        throw new UnsupportedOperationException("Delete this line and implement the method.");
    }

    // Task 2.13
    // Assumes this object represents a legal binary number
    // Returns a decimal string (positive or negative) of the number represented by this
    public String toIntString() {
        if (!isLegal()) {
            throw new IllegalArgumentException("Illegal Number");
        }

        throw new UnsupportedOperationException("Delete this line and implement the method.");
    }

    /*
     * =================================================================
     *              Don't change the following functions:
     * =================================================================
     */

     // Returns true if and only if the representation of this BinaryNumber is a legal and minimal representation of a number
    public boolean isLegal() {
        return rep.isLegalNumber() && rep.isReduced();
    }

    // Returns the number of bits currently in the representation of this BinaryNumber
    public int length() {
        return this.rep.length();
    }

    // Returns a new BinaryNumber representing this * 2
    private BinaryNumber multiplyBy2() {
        BinaryNumber res = new BinaryNumber(this);
        res.rep.shiftLeft();
        return res;
    }

    // Returns a new BinaryNumber representing this / 2
    private BinaryNumber divideBy2() {
        BinaryNumber res = new BinaryNumber(this);
        res.rep.shiftRight();
        return res;
    }
}
