package GuessGame;
//TODO добавить сортировку и сделать код по правилам ООП
/**
 * Created by Ross on 23.09.2017.
 */
public class GuessGame {
    static int answer;
    int userGuess;
    int rightUserGuess;

    public static void main(String[] args) {
        GuessGame[] user = new GuessGame[3];
        for (int i = 0; i < 3; i++) {
            user[i] = new GuessGame();
        }
        for (int x = 0; x < 100; x++) {
            answer = 1 + (int) (Math.random() * 10);
            for (int i = 0; i < 3; i++) {
                user[i].userGuess = 1 + (int) (Math.random() * 10);
            }
            for (int i = 0; i < 3; i++) {
                if (answer == user[i].userGuess) {
                    user[i].rightUserGuess += 1;
                }
            }
        }
        System.out.println("игрок 1 угадал " + user[0].rightUserGuess + " раз.");
        System.out.println("игрок 2 угадал " + user[1].rightUserGuess + " раз.");
        System.out.println("игрок 3 угадал " + user[2].rightUserGuess + " раз.");
    }
}
