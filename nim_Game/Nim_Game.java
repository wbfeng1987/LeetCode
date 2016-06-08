package nim_Game;

import java.util.Scanner;

public class Nim_Game {
    public static boolean canWinNim(int n) {
        return n % 4 != 0;
    }
    
    public static void main(String[] args) {
    	System.out.println("number of stones in the heap: ");
    	Scanner scan = new Scanner(System.in);
    	String s = scan.nextLine();
    	System.out.println("I can win Nim: " + canWinNim(Integer.parseInt(s)));
    	scan.close();
	}
}