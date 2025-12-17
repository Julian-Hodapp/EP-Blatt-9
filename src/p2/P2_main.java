package p2;

public class P2_main {
	public static int[][] grid = new int[3][3];
	
	public static void main(String[] args) {
		
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				grid[i][j] = 0;
			}
		}
		
		//values have to be between [0;2]
		grid[0][2] = -1;
		grid[2][2] = -1;
		grid[1][0] = -1;
		
		printGridToConsole();
	}
	
	public static void printGridToConsole() {
		for (int i = 0; i < 3; i++) {
			String arrayString = "[";
			
			for (int k = 0; k < 3; k++) {
				arrayString += grid[i][k] == -1 ? grid[i][k] : " " + grid[i][k];
				
				arrayString += k != 2 ? "," : "]";
			}
			
			System.out.println(arrayString);
		}
	}
}
