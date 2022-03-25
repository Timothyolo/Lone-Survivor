import java.util.Scanner;


//call this function everything user is prompt for an input, so it gives them the option to quit
public class QuitGame {
    public static void checkQuit(String userInput){
        if(userInput.equals("quit")){
            System.exit(0);
        }
    }


    public static void main(String[] args){
        Scanner inputObj = new Scanner(System.in);  // Create a Scanner object
        System.out.println("Please enter 'quit' to quit the game ");
        String userResponse = inputObj.nextLine();
        QuitGame.checkQuit(userResponse);

    }
}


