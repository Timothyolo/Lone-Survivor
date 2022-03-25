import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class TextParser {

    /*public static void main(String[] args) throws IOException {
        //parser should lowercase all words, remove white spaces and articles, separate the verbs and nouns
        //Ingest Text, Parse it, Identify Keywords, Process Command
        //nouns = items, locations, animals

        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        //Scanner sc = new Scanner(System.in);
        String text;

        do {
            System.out.println("Welcome");
            System.out.println("Enter a command: ");

            text = in.readLine();

            InitialInput(text);

            System.out.println("You entered " + text);
        }
        while(!text.equals("quit"));

    }*/
    List<String> validCommand = new ArrayList<>();
    String text;

    public TextParser() {}

    public TextParser(String input) {
        text = input;
    }

    public List<String> getValidCommand() {
        return validCommand;
    }

    public void InitialInput(String text) {
        List<String> command;

        String newStr = text.trim().toLowerCase();

        if (newStr == "") {
            System.out.println("Please enter a command.");
        }
        else {
            command = TokenizeCommand(newStr);
            command.forEach((str) -> System.out.println(str));
            ParseCommand(command);

        }

    }

    public List<String> TokenizeCommand(String text) {
        String delims = " \t,.:;?!\"'";
        List<String> tokenList = new ArrayList<>();
        StringTokenizer tokenizer = new StringTokenizer(text, delims);

        String x;
        while(tokenizer.hasMoreTokens()) {
            x = tokenizer.nextToken();
            tokenList.add(x);
        }

        return tokenList;
    }

    public void ParseCommand(List<String> command) {
        String verb;
        String noun;

        List<String> verbList = new ArrayList<>(Arrays.asList("go", "get", "look", "use", "quit"));
        List<String> nounList = new ArrayList<>(Arrays.asList("radio", "compass", "flare", "inflatable raft", "flashlight", "life jacket", "food", "knife", "north", "south", "west", "east"));

        if (command.size() > 2) {
            System.out.println("Valid command must contain only two words");
        }
        else if (command.get(0).equals("quit")){
            System.exit(0);
        }
        else {
            verb = command.get(0);
            if (!verbList.contains(verb)) {
                System.out.println(verb + "is not a valid action");
            }
            else{
                validCommand.add(verb);
            }
            noun = command.get(1);
            if (!nounList.contains(noun)) {
                System.out.println("There is no " + noun);
            }
            else {
                validCommand.add(noun);
            }
        }


    }

}
