import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
class Solution {
    public String[] solution(String[] strArr) {
		List<String> arr = new ArrayList<>();

		for (int i = 0; i < strArr.length; i++) {
			if (strArr[i].contains("ad")) {
				continue;
			} else {
				arr.add(strArr[i]);
			}
		}

		String[] answer = new String[arr.size()];
		for (int i = 0; i < arr.size(); i++) {
			answer[i] = arr.get(i);
		}
        return answer;
    }
}