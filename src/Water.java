public class Water {
    public static void main(String[] args)
    {
        int i;
        AI ai=new AI();
        int p[]=new int[13];
        int h[]=new int[13];
        p[0]=2;   h[0]=2;
        p[1]=3;   h[1]=2;
        p[2]=4;   h[2]=2;
        p[3]=4;   h[3]=3;
        p[4]=5;   h[4]=3;
        p[5]=6;   h[5]=3;
        p[6]=7;   h[6]=3;
        p[7]=8;   h[7]=3;
        p[8]=9;   h[8]=0;
        p[9]=10;   h[9]=0;
        p[10]=11;   h[10]=0;
        p[11]=12;   h[11]=0;
        p[12]=13;   h[12]=0;
        for (i=0;i<13;i++)
        {
            ai.getCard(h[i],p[i],i);
        }
        ai.sortCard();
        ai.playCard();
    }
}
