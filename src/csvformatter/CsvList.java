package csvformatter;

import java.util.ArrayList;
import java.util.List;

public class CsvList {

	List<List<String>> csvList = new ArrayList<List<String>>();

	public CsvList(int unitLength) {
		for (int i = 0; i < unitLength; i++) {
			addList();
		}
	}

	void addList() {
		List<String> list = new ArrayList<>();
		csvList.add(list);
	}

	void addElement(String content, int index) {
		List<String> list = csvList.get(index);
		list.add(content);
		csvList.set(index, list);
	}

	List<List<String>> getCsvList() {
		return csvList;
	}
}
