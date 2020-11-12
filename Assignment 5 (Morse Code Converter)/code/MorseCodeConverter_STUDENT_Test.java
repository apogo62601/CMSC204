import static org.junit.jupiter.api.Assertions.*;

import java.io.File;
import java.io.FileNotFoundException;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class MorseCodeConverter_STUDENT_Test {
	
	File inputFile;

	@BeforeEach
	void setUp() throws Exception {
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void testConvertToEnglish() {
		
		assertEquals("hello my name is aelina", MorseCodeConverter.convertToEnglish(".... . .-.. .-.. --- / -- -.-- / -. .- -- . / .. ... / .- . .-.. .. -. .-"));
		
	}

	@Test
	void testConvertToEnglishFile() throws FileNotFoundException {
		
		getFile("Daisy.txt");
		
		assertEquals("give me your answer do", MorseCodeConverter.convertToEnglish(inputFile));
		
	}
	public void getFile(String in) throws FileNotFoundException {		
		JFileChooser chooser = new JFileChooser();
		int status;

		chooser.setDialogTitle("Select Input File - " + in);
		status = chooser.showOpenDialog(null);

		if(status == JFileChooser.APPROVE_OPTION)
		{
			try
			{
				inputFile = chooser.getSelectedFile();
				// readFile();
			}
			catch (Exception e) {
				// TODO Auto-generated catch block
				//e.printStackTrace();
				JOptionPane.showMessageDialog(null, "There is a problem with this file", "Error", JOptionPane.ERROR_MESSAGE);
			}
		}
	}
}
