package applications;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class ValidParentheses {

	public boolean isValidParentheses(String a) {

		if (a == null || a.length() == 0)
			return true;

		Map<Character, Character> hm = new HashMap<>();
		hm.put(')', '(');
		hm.put(']', '[');
		hm.put('}', '{');

		Stack<Character> s = new Stack<>();

		for (int i = 0; i < a.length(); i++) {
			char tmp = a.charAt(i);
			if (!hm.containsKey(tmp))
				s.push(tmp);
			else if (s.isEmpty() || s.pop() != hm.get(tmp))
				return false;
		}
		return s.isEmpty();

	}

}
