package csvformatter;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;

public class FileIO {
	public void fileInput(Path inputPath, int skipLine, int unitLength, CsvList cl) throws IOException {
		List<String> lines = Files.readAllLines(inputPath, StandardCharsets.UTF_8);
		int totalLength = skipLine + unitLength;
		for (int i = 0; i < lines.size() / totalLength; i++) {
			for (int j = skipLine; j < totalLength; j++) {
				cl.addElement(lines.get(i * totalLength + j), j - skipLine);
			}
		}
	}

	public void fileOutput(Path outputPath, CsvList cl) throws IOException {
		List<List<String>> list = cl.getCsvList();
		List<String> outputList = new ArrayList<>();
		for (List<String> li : list) {
			outputList.add(String.join(",", li.toArray(new String[li.size()])));
		}

		if (Files.exists(outputPath)) {
			Files.delete(outputPath);

		}
		Files.createFile(outputPath);
		Files.write(outputPath, outputList, Charset.forName("UTF-8"), StandardOpenOption.APPEND);
	}
}
