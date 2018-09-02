import java.util.Scanner;

public class Game
{
    private Computer comp;
    private final int SIZE=4;

    private char[] genRandomNumber()
    {
        char[] r = new char[SIZE];
        char[] digit={'0', '1', '2', '3', '4', '5', '6', '7', '8', '9'};
        int tekPos=0;

        while (tekPos<SIZE)
        {
            int digPos=(int)(Math.random()*10);
            while (digit[digPos]=='.')
            {
                digPos=(int)(Math.random()*10);
            }

            r[tekPos]=digit[digPos];
            digit[digPos]='.';
            tekPos++;
        }
        return r;
    }

    public void startGame()
    {
        comp = new Computer(genRandomNumber());
        guess();
    }

    private boolean verify (String s)
    {
        if (s.length()!=SIZE)
        {
            return false;
        }

        for (int i=0; i<SIZE; i++)
        {
            if (!('0' <= s.charAt(i) && s.charAt(i) <= '9'))
            {
                return false;
            }

            for (int j=0; j<i; j++)
            {
                if (s.charAt(i)==s.charAt(j))
                {
                    return false;
                }
            }
        }

        return true;
    }

    private char[] scanNumber()
    {
        Scanner scan=new Scanner(System.in);
        String input=scan.nextLine();

        if (verify(input))
        {
            return input.toCharArray();
        }
        System.out.println("Please try again");
        return scanNumber();
    }

    private void guess()
    {
        char[] tekNumber=new char[SIZE];
        int moves=0;

        while(true)
        {
            moves++;
            System.out.println("#"+moves+"   Waiting for number...");
            tekNumber=scanNumber();

            int tekBulls=comp.countBulls(tekNumber);
            int tekCows=comp.countCows(tekNumber);

            if (tekBulls==SIZE)
            {
                System.out.println("Congratulations, you won in "+moves+" moves!");
                return;
            }

            System.out.println("You have "+tekBulls+" bulls and "+tekCows+" cows");
        }
    }
}
