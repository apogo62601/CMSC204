import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class MorseCodeConverter {
	
	private static MorseCodeTree morseCode = new MorseCodeTree();

	public static String printTree(){
		ArrayList<String> tree = morseCode.toArrayList();
		String print = "";
		for(String letter: tree) {
			print += letter + " ";
		}
		return print.trim();
	}

	
	public static String convertToEnglish(String code){
		
		String[] letters;
		String[] word = code.split(" / ");
		String decryptedWord = "";

		for(String temp: word) {
			letters = temp.split(" ");
			for(String tempLetter: letters) {
				decryptedWord +=morseCode.fetch(tempLetter);
			}

			decryptedWord += " ";
			
		}
		return decryptedWord.trim();
	}
	
	public static String convertToEnglish(File codeFile) throws FileNotFoundException{
		
		Scanner scanner = new Scanner(codeFile);
		String fileString = "";
		
		while(scanner.hasNextLine())
			fileString += scanner.nextLine() + "\n"; 
		scanner.close();
		return convertToEnglish(fileString.trim());
	}	
	
}
