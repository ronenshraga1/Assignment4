import java.util.Iterator;

public class BinaryNumber implements Comparable<BinaryNumber> {
    final private BinaryRepresentation rep;

    // Task 2.1
    // Assumes n is non-negative
    // Initializes a BinaryNumber representing n
    public BinaryNumber(int n) {
        if(n<0){
            throw new IllegalArgumentException("not valid number");
        }
//    BinaryRepresentation newBinary = new BinaryRepresentation();
//        int length =  calculateLog(n);
//        int number = (1 << (length - 1));
//        if(n==0){
//            length =1;
//        }
//        for(int i =0;i<length;i++){
//            if(n>=number){
//                newBinary.addFirst(Bit.ONE);
//                n = n -(int)number;
//            } else{
//                newBinary.addFirst(Bit.ZERO);
//            }
//            number = number/2;
//        }
        this.rep = buildBinary(n);
    }
    private int calculateLog(int value){
        int count = 0;
        while (value>0){
            value /= 2;
            count++;
        }
        return count + 1;
    }
    private BinaryRepresentation buildBinary(int n){
        BinaryRepresentation newBinary = new BinaryRepresentation();
        int length =  calculateLog(n);
        int number = (1 << (length - 1));
        if(n==0){
            length =1;
        }
        for(int i =0;i<length;i++){
            if(n>=number){
                newBinary.addFirst(Bit.ONE);
                n = n -(int)number;
            } else{
                newBinary.addFirst(Bit.ZERO);
            }
            number = number/2;
        }
        return  newBinary;
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
        if (s == null || s.isEmpty()) {
            throw new IllegalArgumentException("Input string is null or empty");
        }
        boolean isNegative = s.charAt(0) == '-';
        if (isNegative) {
            s = s.substring(1);
        }

        BinaryNumber result = convertStringToBinary(s);
        if(isNegative){
            this.rep = result.negate().rep;
        }else{
            this.rep = result.rep;
        }
    }
    private BinaryNumber convertStringToBinary(String s) {
        BinaryRepresentation result = new BinaryRepresentation();

        int[] digits = new int[s.length()];
        for (int i = 0; i < s.length(); i++) {
            digits[i] = s.charAt(i) - '0';
        }
        BinaryNumber binarynum = new BinaryNumber(0);
        while (!isZero(digits)) {
            binarynum.rep.addLast(divideByTwo(digits) ==1 ?Bit.ONE:Bit.ZERO);
        }
        binarynum.rep.removeFirst();
        binarynum.rep.addLast(Bit.ZERO);
        return binarynum;
    }
    // Divide the number by 2 and return the remainder
    private static int divideByTwo(int[] digits) {
        int remainder = 0;
        for (int i = 0; i < digits.length; i++) {
            int current = remainder * 10 + digits[i];
            digits[i] = current / 2;
            remainder = current % 2;
        }
        return remainder;
    }
    // Check if the number is zero
    private static boolean isZero(int[] digits) {
        for (int i=0;i<digits.length;i++) {
            if (digits[i] !=0) {
                return false;
            }
        }
        return true;
    }




    // Task 2.4
    // Assumes other is non-null BinaryNumber
    // Returns a new BinaryNumber containing the result of the addition of other to this (i.e. this + other)
    public BinaryNumber add(BinaryNumber other) {
        if(other == null){
            throw new IllegalArgumentException("not valid argument");
        }
        BinaryNumber b1 = new BinaryNumber(0);
        //b1.rep.padding(this.rep.length()+other.rep.length());
        int i =0;
        //Iterator<Bit> sumbit = b1.rep.iterator();
        Bit carry = Bit.ZERO;
        Bit sum = Bit.ZERO;
        if(this.rep.length()>other.rep.length()){
            other.rep.padding(this.rep.length());
        } else if (other.rep.length()>this.rep.length()){
            this.rep.padding(other.rep.length());
        }
        Iterator<Bit> iterator1 = this.rep.iterator();
        Iterator<Bit> iterator2 = other.rep.iterator();

        while ((iterator1.hasNext() || iterator2.hasNext())){
            Bit item1 = Bit.ZERO;
            Bit item2 = Bit.ZERO;
            if(iterator1.hasNext()){
                item1 = iterator1.next();
            }
            if(iterator2.hasNext()){
                item2 = iterator2.next();
            }
            sum = Bit.fullAdderSum(item1,item2,carry);
            carry = Bit.fullAdderCarry(item1,item2,carry);
            b1.rep.addLast(sum);
            //b1.rep.removeLast();
            i++;
        }
        b1.rep.removeFirst();
        if(this.rep.getLast() == Bit.ZERO && other.rep.getLast() == Bit.ZERO){
            b1.rep.addLast(Bit.ZERO);
        } else if (this.rep.getLast() == Bit.ONE && other.rep.getLast() == Bit.ONE) {
            b1.rep.addLast(Bit.ONE);
        }else if(sum == Bit.ONE){
            b1.rep.addLast(Bit.ONE);
        }else{
            b1.rep.addLast(Bit.ZERO);
        }
        b1.rep.reduce();
        return b1;
    }


    // Task 2.5
    // Returns a new BinaryNumber that represents the Additive Inverse of this, that is, if this equals X, the return value is -X
    public BinaryNumber negate() {
        BinaryNumber complement = new BinaryNumber(this);
        complement.rep.complement();
        Iterator<Bit> iterator = complement.rep.iterator();
        Bit carry = Bit.ONE;
        BinaryNumber newNumber = new BinaryNumber(0);
        while (iterator.hasNext()){
            Bit bit = iterator.next();
            Bit sum = Bit.fullAdderSum(bit,Bit.ZERO,carry);
            carry = Bit.fullAdderCarry(bit,Bit.ZERO,carry);
            newNumber.rep.addLast(sum);
        }
        newNumber.rep.removeFirst();
        return newNumber;
    }

    // Task 2.6
    // Assumes other is non-null BinaryNumber
    // Returns a new BinaryNumber containing the result of the subtraction of other from this (i.e. this - other)
    public BinaryNumber subtract(BinaryNumber other) {
        BinaryNumber copy = new BinaryNumber(other);
        //copy.negate();
        return add(copy.negate());
    }

    // Task 2.7
    // Returns 1 if the number represented by this object is positive, -1 if it negative and 0 if it equals 0
    public int signum() {
        if(this.rep.getLast() == Bit.ONE){
            return -1;
        } else if (this.rep.getLast() == Bit.ZERO && this.rep.length() == 1) {
            return 0;
        } else{
            return 1;
        }
    }

    // Task 2.10
    // Assumes other is non-null BinaryNumber which is positive
    // Returns a new BinaryNumber containing the result of the multiplication of other and this (i.e. this * other)
    private BinaryNumber multiplyPositive(BinaryNumber other){
        if (other.toInt() == 0) {
            return new BinaryNumber(0);
        }
        if (other.toInt() == 1) {
            return this;
        }
        BinaryNumber halfMultiply = new BinaryNumber(other.toInt() / 2);
        BinaryNumber halfValue = this.multiplyPositive(halfMultiply);
        if (other.toInt() % 2 == 0) {
            return halfValue.add(halfValue);
        } else {
            return halfValue.add(halfValue).add(this);
        }

    }

    // Task 2.10
    // Assumes other is non-null BinaryNumber
    // Returns a new BinaryNumber containing the result of the multiplication of other and this (i.e. this * other)
    public BinaryNumber multiply(BinaryNumber other) {
        if(other.rep.getLast() == Bit.ONE || other == null){
            throw new IllegalArgumentException("number is not positive");
        }
        boolean isNegative = this.signum() * other.signum() < 0;
        BinaryNumber positiveCurrent = this;
        BinaryNumber positiveOther = other;
        if(this.signum() < 0){
            positiveCurrent = this.negate();
        }
        if(other.signum() < 0){
            positiveOther = other.negate();
        }
        BinaryNumber result = positiveCurrent.multiplyPositive(positiveOther);

        if(isNegative){
            return result.negate();
        } else{
            return result;
        }

    }
    // assumes other and this are positive numbers
    //Returns a new BinaryNumber containing the result of the division of other and this (i.e. this / other)
    private BinaryNumber dividePositive(BinaryNumber divisor){
        int number1 = this.toInt() > 0? this.toInt() : this.negate().toInt();
        int convert = divisor.toInt() > 0? divisor.toInt() : divisor.negate().toInt();
        return new BinaryNumber(number1 / convert);
    }

    // Task 2.11
    // Assumes other is non-null BinaryNumber
    // Returns a new BinaryNumber containing the result of the integer-division of other from this (i.e. this / other)
    public BinaryNumber divide(BinaryNumber other) {
        if(other == null){
            throw new IllegalArgumentException("not valid value");
        }
        boolean isPositive = (this.toInt() / other.toInt()) > 0 ? true :false;
        if(isPositive){
            return dividePositive(other);
        } else{
            BinaryNumber negative = dividePositive(other);
            return negative.negate();
        }
    }

    // Task 2.2
    // Assumes this object represents a legal binary number
    // Returns the represention of this BinaryNumber as a binary string, that is, all the chars are either 0 or 1
    public String toString() {
        if (!isLegal()) {
            throw new IllegalArgumentException("not legal.");
        }
        String binaryNumber = "";
        Iterator<Bit> iterator = rep.iterator();
        while (iterator.hasNext()){
            binaryNumber = iterator.next().toString() + binaryNumber;
        }
        return binaryNumber;
    }

    // Task 2.3
    // Returns true if and only if this and other represent the same number
    public boolean equals(Object other) {
        boolean isEqual = false;
        if(other instanceof BinaryNumber){
            isEqual = true;
            Iterator iterator1 = this.rep.iterator();

            Iterator iterator2 = ((BinaryNumber) other).rep.iterator();
            if(this.rep.length() != ((BinaryNumber) other).rep.length()){
                isEqual = false;
            }
            while (iterator1.hasNext() && iterator2.hasNext() && isEqual){
                if(!iterator1.next().equals(iterator2.next())){
                    isEqual = false;
                }
            }
        }
        return  isEqual;
        //return super.equals(other); // This is the default implementation of equals
    }

    // Task 2.8
    // Returns a positive number if this object represents a number bigger than the one other represents,
    // 0 if they are equal, and a negative number if it is smaller.
    public int compareTo(BinaryNumber other) {
        if(other == null){
            throw new IllegalArgumentException("NOT VALID VALUE");
        }
        BinaryNumber copy1 = new BinaryNumber(this);
        BinaryNumber copy2 = new BinaryNumber(other);
        
        Iterator<Bit> iterator1 = copy1.rep.iterator();
        Iterator<Bit> iterator2 = copy2.rep.iterator();
        if(this.rep.length()>other.rep.length()){
            other.rep.padding(this.rep.length());
        } else if (other.rep.length()>this.rep.length()){
            this.rep.padding(other.rep.length());
        }
        if(this.rep.getLast().toInt() <other.rep.getLast().toInt()){
            return 1;
        } else if (this.rep.getLast().toInt() >other.rep.getLast().toInt()){
            return -1;
        }
        while (copy1.length() > 0){
            if(copy1.rep.getLast().toInt() > copy2.rep.getLast().toInt()){
                return 1;
            } else if (copy2.rep.getLast().toInt() > copy1.rep.getLast().toInt()) {
                return -1;
            } else{
                copy1.rep.removeLast();
                copy2.rep.removeLast();
            }
        }
        return 0;
    }

    // Task 2.9
    // Assumes this current number is small enough to be represented by an int
    // Returns the int value of the number represented by this
    public int toInt() {
        int multiplicationBy2 = 1;
        BinaryNumber positiveBinary = new BinaryNumber(this);
        int sum = 0;
        int sign = signum();
        if(sign == -1){
            positiveBinary = negate();
        } else if (sign == 0) {
            return 0;
        }
        Iterator<Bit> iterator = positiveBinary.rep.iterator();
        while (iterator.hasNext()){
            Bit value = iterator.next();
            if(value.equals(Bit.ONE)){
                sum = sum + multiplicationBy2;
            }
            multiplicationBy2 = multiplicationBy2 * 2;
        }
        if(sum < 0){
            throw new RuntimeException("number bigger than int");
        } else if (sign == -1) {
            sum = sum * -1;
        }

        return sum;
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
