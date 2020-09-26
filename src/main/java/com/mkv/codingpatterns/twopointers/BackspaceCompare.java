package com.mkv.codingpatterns.twopointers;

/*Given two strings containing backspaces
(identified by the character ‘#’), check if the two strings are equal.

Time complexity #
The time complexity of the above algorithm will be O(M+N) where ‘M’ and ‘N’ are the lengths of the two input strings respectively.

Space complexity #
The algorithm runs in constant space O(1).

*/

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
		return tempStr.toString();
	}

	private boolean compareStringTwoPointer(String str1, String str2) {
		int i1, i2;
		int index1 = str1.length() - 1, index2 = str2.length() - 1;

		while(index1 >= 0|| index2 >= 0) {
			System.out.println();
			i1 = getNextValidCharacter(str1, index1);
			System.out.println();
			i2 = getNextValidCharacter(str2, index2);

			if(i1 < 0 && i2 < 0)
				return true;
			if(i1 < 0 || i2 < 0)
				return false;
			if(str1.charAt(i1) != str2.charAt(i2))
				return false;
			index1 = i1-1;
			index2 = i2-1;
		}
		return true;
	}

	private int getNextValidCharacter(String str, int index) {
		int backspace = 0;
		while(index > 0) {
			if(str.charAt(index) == '#')
				backspace++;
			else {
				if(backspace > 0)
					backspace--;
				else
					break;
			}
			index--;
		}
		System.out.print(str +"  "+index + " ");
		return index;
	}

	public static void main(String[] args) {
		BackspaceCompare main = new BackspaceCompare();

/*		System.out.println(main.compareString("xy#z", "xzz#"));
		System.out.println(main.compareString("xy#z", "xyz#"));
		System.out.println(main.compareString("xp#", "xyz##"));
		System.out.println(main.compareString("xywrrmp", "xywrrmu#p"));
*/

		System.out.println(main.compareStringTwoPointer("xy#z", "xzz#"));
		System.out.println(main.compareStringTwoPointer("xy#z", "xyz#"));
		System.out.println(main.compareStringTwoPointer("xp#", "xyz##"));
		System.out.println(main.compareStringTwoPointer("xywrrmp", "xywrrmu#p"));

	}
}