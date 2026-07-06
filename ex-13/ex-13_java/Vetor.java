public class Vetor
{
    private int dx, dy;

    //Construtoras
    public Vetor(int x, int y)
    {
        dx = x;
        dy = y;
    }

    public Vetor()
    {
        dx = 0;
        dy = 0;
    }

    //Set's
    public void setDx(int x)
    {
        dx = x;
    }

    public void setDy(int y)
    {
        dy = y;
    }

    //Get's
    public int getDx()
    {
        return dx;
    }

    public int getDy()
    {
        return dy;
    }

    //Soma dois vetores
    public Vetor soma(Vetor v)
    {
        return new Vetor(v.dx + dx, v.dy + dy);
    }

    //Multiplica um vetor por uma constante
    public Vetor multiplica(int i)
    {
        return new Vetor(dx * i, dy * i);
    }
}
