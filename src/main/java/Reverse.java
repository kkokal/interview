import com.kokal.three.Reverser;

public class Reverse {

    public static void main(String[] args) {
        Reverser r = new Reverser();
        if (args.length > 0){
            System.out.println(r.reverse(args[0]));
        }
    }

}
