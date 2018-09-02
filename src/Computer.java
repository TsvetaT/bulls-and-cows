public final class Computer
{
    private char[] number;
    private final int SIZE=4;

    public Computer(char[] _number)
    {
        this.number=_number;
    }

    public int countBulls (char[] guess)
    {
        int bulls=0;

        for (int i=0; i<SIZE; i++)
        {
            if (guess[i]==number[i])
            {
                bulls++;
            }
        }

        return bulls;
    }

    public int countCows (char[] guess)
    {
        int cows=0;

        for (int i=0; i<SIZE; i++)
        {
            for (int j=0; j<SIZE; j++)
            {
                if (i!=j && guess[j]==number[i])
                {
                    cows++;
                }
            }
        }

        return cows;
    }
}
