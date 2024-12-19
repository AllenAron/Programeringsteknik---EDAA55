
public class Playground {
	public static void main(String[] args) {
	int days=daysPerMonth(6);
	System.out.println(days);
}
	public static int daysPerMonth(int monthNbr) {
		if (monthNbr==4||monthNbr==6||monthNbr==9||monthNbr==11){
			return 30;
			}
		else if (monthNbr==2) {
			return 28;
		}
		else {
			return 31;
		}
}

	public static int nbr(int number) {
		int i = 0;
		int nbr = i;
		int nbr3 = nbr % 10;
		nbr = nbr / 10;
		int nbr2 = nbr % 100;
		
		return i;
	}
	 public static int[] sum(int[][] m) {
		    int[] rowSum;
		    for (int r = 0; r < m.length; r++) {
		        for (int c = 0; c < m[r].length; c++) {
		            rowSum[r] += m[r][c];
		        }
		    }
		    return rowSum[];
		}
}
