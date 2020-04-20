package TestEncryption;

public class EncryptString {

	public String encryptString(String str) {

		// A. Remove spaces from the text and write the characters in a grid of RXC
		// dimension
		String noSpace = str.replaceAll("\\s", "");
		
		System.out.println(noSpace);
		System.out.println("======================");

		// B. Say L is the length of the text after removing spaces
		int len = noSpace.length();

		int l = 0;
		// C 
		// b. Where [PRESQRT(L)] = square root of largest perfect square number less than or equals to L
		int row = (int) Math.floor(Math.sqrt(len));
		// c. Where [POSTSQRT(L)] = square root of smallest perfect square number greater than or equals to L
		int column = (int) Math.ceil(Math.sqrt(len));
		
		String result = "";
		String revMatrixString = "";
		
		// d.	Ensure that R * C >= L
		if (row * column < len) {
			row = column;
		}

		char ch[][] = new char[row][column];

		// A. write the characters in a grid of RXC dimension
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < column; j++) {
				if (l < noSpace.length())
					ch[i][j] = noSpace.charAt(l);
				l++;
				System.out.print(ch[i][j]);
			}
			System.out.println(" ");
		}

		char revMatrix[][] = new char[column][row];

		// Matrix Transpose
		// D. Now encrypted text obtained by joining the characters in each column and separated by space
		for (int i = 0; i < column; i++) {
			for (int j = 0; j < row; j++) {
				revMatrix[i][j] = ch[j][i];
				revMatrixString = revMatrixString + revMatrix[i][j];
			}
			revMatrixString = revMatrixString + " ";
		}

		result = result + revMatrixString;
		System.out.println("======================");
		System.out.println(result);
		return result;
	}

	public static void main(String[] args) {
		EncryptString es = new EncryptString();
		es.encryptString("the black cat jumped on the roof");
		//es.encryptString("chill out");
	}
}
