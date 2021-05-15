package fifthstar;

public class TaumAndBDay {

    public static long taumBday(int b, int w, int bc, int wc, int z) {
        // Write your code here
        if(bc > wc + z) {
            return (long)w * wc + (long)b * wc + (long)z * b;
        } else if (wc > bc + z) {
            return (long)bc * b + (long)w * bc + (long)z * w;
        }
        return (long)b * bc + (long)w * wc;
    }

    public static void main(String[] args) {

    }
}
