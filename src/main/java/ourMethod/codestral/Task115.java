package ourMethod.codestral;
// Defining a class with bit fields in Java
  class BitFieldClass {
    private int field1;
    private int field2;

    public BitFieldClass(int field1, int field2) {
        this.field1 = field1 & 0b111;  // Limiting field1 to 3 bits
        this.field2 = field2 & 0b11111;  // Limiting field2 to 5 bits
    }

    // Getters and setters can be added as needed
}