public class Sudoku {
    public static void main(String[] args) {
        int[][] b={
            {5,3,0,0,7,0,0,0,0},
            {6,0,0,1,9,5,0,0,0},
            {0,9,8,0,0,0,0,6,0},
            {8,0,0,0,6,0,0,0,3},
            {4,0,0,8,0,3,0,0,1},
            {7,0,0,0,2,0,0,0,6},
            {0,6,0,0,0,0,2,8,0},
            {0,0,0,4,1,9,0,0,5},
            {0,0,0,0,8,0,0,7,9}
        };
        System.out.println("Valid? "+v(b));
    }
    static boolean v(int[][] b){
        for(int i=0;i<9;i++){
            boolean[] r=new boolean[10],c=new boolean[10],x=new boolean[10];
            for(int j=0;j<9;j++){
                if(b[i][j]!=0){
                    if(r[b[i][j]])return false;
                    r[b[i][j]]=true;
                }
                if(b[j][i]!=0){
                    if(c[b[j][i]])return false;
                    c[b[j][i]]=true;
                }
                int a=3*(i/3)+j/3,d=3*(i%3)+j%3;
                if(b[a][d]!=0){
                    if(x[b[a][d]])return false;
                    x[b[a][d]]=true;
                }
            }
        }
        return true;
    }
}
