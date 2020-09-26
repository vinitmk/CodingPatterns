package com.mkv.codingpatterns.twopointers;

/*Given two strings containing backspaces
(identified by the character ‘#’), check if the two strings are equal.*/

public class BackspaceCompare {

	private boolean compareString(String str1, String str2) {
		return originalString(str1).equals(originalString(str2));
	}

	private String originalString(String s) {
		char c;
		StringBuilder tempStr = new StringBuilder();
		int backspace = 0;
		for(int i = s.toCharArray().length - 1; i >= 0; i--) {
			c = s.charAt(i);
			if(c == '#')
				backspace++;
			else {
				if(backspace > 0)
					backspace--;
				else
					tempStr.append(c);
			}

		}
		System.out.println(tempStr.toString());
		return tempStr.toString();
	}

	public static void main(String[] args) {
		BackspaceCompare main = new BackspaceCompare();

		System.out.println(main.compareString("xy#z", "xzz#"));
		System.out.println(main.compareString("xy#z", "xyz#"));
		System.out.println(main.compareString("xp#", "xyz##"));
		System.out.println(main.compareString("xywrrmp", "xywrrmu#p"));
	}
}