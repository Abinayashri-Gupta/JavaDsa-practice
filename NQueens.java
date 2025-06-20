import java.util.*;
public class NQueens {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter the value of N (size of board): ");
        int n=sc.nextInt();
        char[][] b=new char[n][n];
        for(int i=0;i<n;i++)
           for(int j=0;j<n;j++)
                b[i][j]='.';
        System.out.println("\nSolutions:");
        f(b,0);
    }
    static void f(char[][] b,int r){
        int n=b.length;
        if(r==n){
            p(b);
            System.out.println();
            return;
        }
        for(int c=0;c<n;c++){
            if(s(b,r,c)){
                b[r][c]='Q';
                f(b,r+1);
                b[r][c]='.';
            }
        }
    }
    static boolean s(char[][] b,int r,int c){
        for(int i=0;i<r;i++)if(b[i][c]=='Q')return false;
        for(int i=r-1,j=c-1;i>=0&&j>=0;i--,j--)if(b[i][j]=='Q')return false;
        for(int i=r-1,j=c+1;i>=0&&j<b.length;i--,j++)if(b[i][j]=='Q')return false;
        return true;
    }
    static void p(char[][] b){
        for(char[] r:b){
            for(char ch:r)System.out.print(ch+" ");
            System.out.println();
        }
    }
}
