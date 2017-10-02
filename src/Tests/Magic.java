package Tests;

/**
 * Created by Ross on 02.10.2017.
 */
public class Magic {
    public static void main() throws InterruptedException {
        StringBuffer text = new StringBuffer("#");
        int a = 0;
        boolean bool = true;
        while(true){
            if(bool){
                text.append("#");
                a++;
            }
            if(a==20){
                bool = false;
            }
            if(!bool){
                text.deleteCharAt(text.length()-1);
                a--;
            }
            if(a == 0){
                bool = true;
            }
            System.out.println(text);
            Thread.sleep(50);
        }
    }
}
class MagicDemo{
    public static void main(String[] args) throws InterruptedException {
        Magic.main();
    }
}
