package algosproject;

public class LCS {

    /**
     * @param args the command line arguments
     */
  public static String find(long[] A, long[] B , long[] C) {
		long [][][] LCS = new long[A.length + 1][B.length + 1] [C.length + 1];
		String[][][] solution = new String[A.length + 1][B.length + 1][C.length + 1];
		// if A is null then LCS of A, B =0
		for (int i = 0; i <= B.length; i++) {
                    for(int j=0;j<= C.length;j++){
			LCS[0][i][j] = 0;
			solution[0][i][j] = "0";
                    }    
		}

		// if B is null then LCS of A, B =0
		for (int i = 0; i <= A.length; i++) {
                    for (int j = 0; j <= C.length; j++){
			LCS[i][0][j] = 0;
			solution[i][0][j] = "0";
                    }
		}
                
                
                
                // if C is null then LCS of A, B =0
		for (int i = 0; i <= A.length; i++) {
                    for (int j = 0; j <= B.length; j++){
			LCS[i][j][0] = 0;
			solution[i][j][0] = "0";
                    }
		}

		for (int i = 1; i <= A.length; i++) {
			for (int j = 1; j <= B.length; j++) {
                            for (int k = 1; k <= C.length; k++){
				if (B[j - 1] == C[k - 1] && A[i-1]==B[j-1] && A[i-1]==C[k-1]) {
					LCS[i][j][k] = LCS[i][j - 1][k - 1] + 1;
					solution[i][j][k] = "diagonal";
				} else {
					LCS[i][j][k] = Math.max(LCS[i - 1][j][k], LCS[i][j - 1][k]);
                                        LCS[i][j][k] = Math.max(LCS[i][j][k], LCS[i][j][k - 1]);
                                        
					if (LCS[i][j][k] == LCS[i - 1][j][k]) {
						solution[i][j][k] = "top";
					} else if(LCS[i][j][k] == LCS[i][j-1][k]) {
						solution[i][j][k] = "left";
					}
                                        else{
                                                solution[i][j][k] = "right";
                                        
                                        }
				}
                            }
			}
		}
		// below code is to just print the result
		String x = solution[A.length][B.length][C.length];
		String answer = "";
		int a = A.length;
		int b = B.length;
                int c = C.length;
                
		while (x != "0") {
			if (solution[a][b][c] == "diagonal") {
				answer = A[a - 1]+ answer;
				
				b--;
                                c--;
                                
                                
			} else if (solution[a][b][c] == "left") {
				b--;
			} else if (solution[a][b][c] == "top") {
				a--;
			} else if (solution[a][b][c] == "right"){
                        
                                c--;
                        }
                        
			x = solution[a][b][c];
		}
		//System.out.println(answer);
               
		
                   return answer;
  }

	public static void main(String[] args) {
		
	}
        
        public static String getlcs(long arr1[],long arr2[], long arr3[])
        {
           String  res= find(arr1,arr2,arr3);
           return res;
        }
    
}
