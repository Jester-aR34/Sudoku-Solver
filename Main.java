import java.util.*;
public class Main
{
    public static int[] SolvingMachine(int [][]a)
    {  
        int c=0;
        for(int i = 0;i<9;i++)
        {
            for(int j = 0;j<9;j++)
            {
                if(a[i][j] == 0)
                    c++;
            }
        }
        System.out.println("\nNo. of Null Values :"+ c);
        int s[] = new int[c+1] ;
        for(int i = 0;i<c;i++)
        {
            s[i] = 1;
        }

        int [][]dummy = new int[9][9];
        for(int i = 0;i<9;i++)
        {
            for(int j = 0;j<9;j++)
            {
                dummy[i][j] = a[i][j];
            }
        }

        int rl=0,cl=0;
        int i =0;
        while(i < c )
        {            
            int count =0,f1 =0; ;
            for(int k = 0;k<9;k++)
            {
                for(int l = 0;l<9;l++)
                {
                    if(dummy[k][l] == 0)
                    {
                        if(count == i)
                        {
                            rl = k;
                            cl = l;
                            f1 =1;
                            break;
                        }
                        count ++;
                    }    
                }
                if(f1 ==1)
                    break;
            }
            a[rl][cl] = 0;
            for(int j = s[i];j<=9;j++)
            {
                if(s[i]==9)
                {
                    i--;
                    if(i == -1)
                    {
                        System.out.println("\nInvalid problem !!!");
                        return s;
                    }
                    if(s[i]<9)
                        s[i]++;
                    break;
                }
                if(check(rl,cl,a,j)==0)
                {
                    if(i<c)
                        s[i+1]=1;
                    s[i] = j;
                    i++;
                    a[rl][cl] = j;
                    break;
                }

                if(j==9 && check(rl,cl,a,j)!=0)
                {
                    i--;
                    if(i == -1)
                    {
                        System.out.println("\nInvalid problem !!!");
                        return s;
                    }
                    if(s[i]<9)
                        s[i]++;
                }
            }   
        }
        System.out.println();
        return s;
    }

    public static int box_check(int rs,int re,int cs,int ce,int [][]a,int r,int c,int n)    //Box Check
    {
        for(int i = rs; i<=re; i++)
        {
            for(int j = cs; j<=ce; j++)
            {
                if(i==r && j==c)
                    continue;
                if(a[i][j] == n)
                    return 1;
            }
        }
        return 0;
    }

    public static int check(int r,int c,int [][]a,int n)
    {
        //Row Check
        for(int i = 0;i<9;i++)
        {
            if(i == c)
                continue;
            if(a[r][i] == n)
                return 1;
        }
        //Col Check
        for(int i = 0;i<9;i++)
        {
            if(i == r)
                continue;
            if(a[i][c] == n)
                return 1;
        }

        int f=0;
        //Box Checking
        if(( 0 <= r  && r <= 2 )&&( 0 <= c && c <= 2 ))         //Box1
            f=box_check(0,2,0,2,a,r,c,n);
        else if(( 0 <= r  && r <= 2 )&&( 3 <= c && c <= 5 ))    //Box2
            f=box_check(0,2,3,5,a,r,c,n);
        else if(( 0 <= r  && r <= 2 )&&( 6 <= c && c <= 8 ))    //Box3
            f=box_check(0,2,6,8,a,r,c,n);
        
        else if(( 3 <= r  && r <= 5 )&&( 0 <= c && c <= 2 ))    //Box4
            f=box_check(3,5,0,2,a,r,c,n);
        else if(( 3 <= r  && r <= 5 )&&( 3 <= c && c <= 5 ))    //Box5
            f=box_check(3,5,3,5,a,r,c,n);
        else if(( 3 <= r  && r <= 5 )&&( 6 <= c && c <= 8 ))    //Box6
            f=box_check(3,5,6,8,a,r,c,n);
        
        else if(( 6 <= r  && r <= 8 )&&( 0 <= c && c <= 2 ))    //Box7
            f=box_check(6,8,0,2,a,r,c,n);
        else if(( 6 <= r  && r <= 8 )&&( 3 <= c && c <= 5 ))    //Box8
            f=box_check(6,8,3,5,a,r,c,n);
        else if(( 6 <= r  && r <= 8 )&&( 6 <= c && c <= 8 ))    //Box9
            f=box_check(6,8,6,8,a,r,c,n);

        return f;
    }

    public static void s_box(int [][]a) //Fn to Display the box
    { 
        for(int i = 0;i<9;i++)
        {
            if(i%3 == 0)
                System.out.println("  X =========== X =========== X =========== X ");
            for(int j = 0;j<9;j++)
            {
                if(j%3 == 0)
                    System.out.print(" ||| ");
                else
                    System.out.print(" | ");
                if(a[i][j] == 0)
                    System.out.print(" ");
                else if (a[i][j] < 0 ) 
                    System.out.print(".");
                else
                    System.out.print(a[i][j]);
            }
            System.out.print(" ||| ");
            System.out.println();
        }
        System.out.println("  X =========== X =========== X =========== X \n");
    }
    
    public static void main(String [] args )
    {
        Scanner sc = new Scanner(System.in);
        //Initializing the value for empty box
        int s[][] = new int[9][9];
        for(int i = 0;i<9;i++)
        {
            for(int j = 0;j<9;j++)
            {
                s[i][j] = -1;
            }
        }
        //Instructions
        System.out.println("\nSudoku Solver !!!\n");
        System.out.println("Instructions :");
        System.out.println("-> Sudoku is played on a 9x9 grid divided into nine 3x3 subgrids.");
        System.out.println("-> Each row must contain the digits 1 through 9 exactly once.");
        System.out.println("-> Each column must contain the digits 1 through 9 exactly once.");
        System.out.println("-> Each 3x3 box must contain the digits 1 through 9 exactly once. \n");

        System.out.println("Enter a valid problem to the Sudoku algo !!\n");
        //Initializing values of the sudoku problem
        System.out.println("Range of Values is (1-9) and 0 is considerd as Null input !!");
        System.out.println("Enter the value of position :");
        for(int i = 0;i<9;i++)
        {
            for(int j = 0;j<9;j++)
            {
                while(true){
                    System.out.print("R:"+(i+1)+" C:"+(j+1)+" =>");
                    int x = sc.nextInt();
                    if(0 > x || x > 9)
                        System.out.println("Enter a no. in range (0-9) where 0 is for Null input: ");
                    else
                    {
                        s[i][j] = x;
                        break;
                    }
                }
                s_box(s);
            }
        }

        //Changes after input!!
        System.out.print("Do u want any changes in sudoku Problem (Yes/No): ");
        String ch = sc.next();
        ch = ch.toLowerCase();
        while(ch.charAt(0)=='y')
        {
            int r,c;
            System.out.println("Enter the position of the box < r c > value (1-9): ");
            System.out.print("R: ");
            while(true){
                int x = sc.nextInt() - 1;
                if(0 > x || x > 8)
                    System.out.println("Enter a no. in range (1-9) : ");
                else
                {
                    r = x;
                    break;
                }
            }
            System.out.print("C: ");
            while(true){
                int x = sc.nextInt() - 1;
                if(0 > x || x > 8)
                    System.out.println("Enter a no. in range (1-9) : ");
                else
                {
                    c = x;
                    break;
                }
            }
            while(true)
            {
                System.out.println("Enter the value :");
                System.out.print("R:"+(r+1)+" C:"+(c+1)+" =>");
                int x = sc.nextInt();
                if(0 > x || x > 9)
                    System.out.println("Enter a no. in range (0-9) where 0 is for Null input: ");
                else
                {
                    s[r][c] = x;
                    break;
                }
            }
            s_box(s);
            System.out.print("Any other changes ? (Yes/No): ");
            ch = sc.next();
            System.out.println();
        }
        //Checking validation !!
        for(int i = 0;i<9;i++)
        {
            int f = 0;
            for(int j = 0;j<9;j++)
            {
                if(s[i][j] != 0)
                {
                    if(check(i,j,s,s[i][j]) == 1)
                    {
                        f = 1;
                        break;
                    }
                }
            }
            if(f == 1)
            {
                System.err.println("This Sudoku is Invalid !!!");
                break;
            }
        }
        
        int[] solarr = SolvingMachine(s);
        
        if(solarr[solarr.length-1] == 0)    //The given problem is not Valid
        {
            System.err.println("This Sudoku is Invalid !!!\n");
        }

        else
        {
            System.out.println("length of Solution Array: "+ solarr.length+"\n");
            System.out.println("The last element of the array indicates the status: \n0 : Not Solved \n1 : Solved\n");
            System.out.print("Solution Array : [ ");
            for (int i = 0; i < solarr.length; i++)
            {
                System.out.print(solarr[i]+" ");
            }
            System.out.println("]");

            System.out.println("\nSolved Sudoku :");
            s_box(s);
        }
        sc.close();
    }
}