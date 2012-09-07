//: generics/HijackedInterface.java
package generics; /* Added by Eclipse.py */
// {CompileTimeError} (Won't compile)

class Cat extends ComparablePet {
  // Error: Comparable cannot be inherited with
  // different arguments: <Cat> and <Pet>
  public int compareTo(Cat arg) { return 0; }
} ///:~
