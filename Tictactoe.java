import java.util.Scanner;



public class Tictactoe{
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int size = in.nextInt();
        int[][] board = new int[size][size];
        boolean gotResult = false;
        int numOfX=0;
        int numOfO=0;

        for (int i=0;i<size;i++)
        {
            for (int j=0;j<size;j++)
            {
                board[i][j]=in.nextInt();
            }
        }

        for (int i=0;i<size;i++)
        {
            numOfX=0;
            numOfO=0;
            for (int j=0;j<size;j++)
            {
                if(board[i][j]==1)
                {
                    numOfX++;
                }
                else
                {
                    numOfO++;
                }
            }
            if(numOfX==size||numOfO==size)
            {
                gotResult=true;
                break;
            }
        }

        if(!gotResult)
        {
            for(int i=0;i<size;i++)
            {
                numOfX=0;
                numOfO=0;
                for (int j=0;j<size;j++)
                {
                    if(board[j][i]==1)
                    {
                        numOfX++;
                    }
                    else
                    {
                        numOfO++;
                    }
                }
                if (numOfX==size||numOfO==size)
                {
                    gotResult=true;
                    break;
                }
            }
        }
       if (!gotResult)
       {
           numOfX=0;
           numOfO=0;
           for (int i=0;i<size;i++)
           {
               if (board[i][i]==1)
               {
                   numOfX++;
               }
               else
               {
                   numOfO++;
               }
           }
           if (numOfX==size||numOfO==size)
           {
               gotResult=true;
           }
       }
        if (!gotResult)
        {
            numOfX=0;
            numOfO=0;
            for (int i=0;i<size;i++)
            {
                if (board[i][size-i-1]==1)
                {
                    numOfX++;
                }
                else
                {
                    numOfO++;
                }
            }
            if (numOfX==size||numOfO==size)
            {
                gotResult=true;
            }
        }
        if (gotResult)
        {
            if(numOfX==size)
            {
                System.out.print("X");
            }
            else
            {
                System.out.print("O");
            }
        }else
        {
        	System.out.print("NIL");
        }
    }

}