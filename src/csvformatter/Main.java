package csvformatter;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Main {
	public static void main(String[] args) {
		Path inputPath = Paths.get(args[0]);
		Path outputPath = Paths.get(args[0].replace(".txt", ".csv"));
		int skipLine = Integer.parseInt(args[1]);
		int unitLength = Integer.parseInt(args[2]);
		CsvList cl = new CsvList(unitLength);

		FileIO fi = new FileIO();
		try {
			fi.fileInput(inputPath, skipLine, unitLength, cl);
			fi.fileOutput(outputPath, cl);
			System.out.println("SUCCESS!");
		} catch (IOException e) {
			System.out.println("FAILURE!");
			e.printStackTrace();
		}
	}
}
