/**
 * Created by mr_ma on 19.10.2017.
 */
public class tst {
  private  void draw() { System.out.println("tst.draw()"); }
   private   tst(){
          draw();
    }

    public static void main(String[] args) throws ClassNotFoundException {
     //  Class.forName("A");
       // A a = A.class.newInstance();
     //   System.out.println( a instanceof A);
        System.out.print("jjjjjjjjj");
        System.out.println();
        System.out.print("jjjjjjjjj");
    }
}
  class A  {
    private A(){

      }
    static {
        System.out.println("a static()");
    }
      public  void draw() { System.out.println("a.draw()"); }


}
/*class Glyph {
  void draw() { print("Glyph.draw()"); }
  Glyph() {
    print("Glyph() before draw()");
    draw();
    print("Glyph() after draw()");
  }
}

class RoundGlyph extends Glyph {
  private int radius = 1;
  RoundGlyph(int r) {
    radius = r;
    print("RoundGlyph.RoundGlyph(), radius = " + radius);
  }
  void draw() {
    print("RoundGlyph.draw(), radius = " + radius);
  }*/