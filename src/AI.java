 class AI {
    private Card pokerCard[]=new Card[13];          //十三张牌
    void getCard(int hs,int sz,int ps)      //获得一张牌，hs为花色，sz为数字，ps为牌序
    {
        pokerCard[ps]=new Card();
        pokerCard[ps].colour=hs;
        pokerCard[ps].number=sz;
    }
    void sortCard()                         //将获得的牌进行排序，以便后边出牌时查找
    {
        Card k=new Card();
        int i,j;
        for (i=0;i<12;i++)
        {
            for (j=i+1;j<13;j++)
            {
                if (pokerCard[i].number>pokerCard[j].number)
                {
                    k=pokerCard[i];
                    pokerCard[i]=pokerCard[j];
                    pokerCard[j]=k;
                }
            }
        }
    }
    void playCard()                           //经过计算输出
    {
        if (maxLung())
        {
            int i;
            System.out.println("至尊清龙 花色："+pokerCard[0].colour);
            System.out.print("前墩："+pokerCard[12].number);
            for (i=0;i<2;i++)
            {
                System.out.print("  "+pokerCard[i].number);
            }
            System.out.print("  中墩："+pokerCard[2].number);
            for (i=3;i<7;i++)
            {
                System.out.print("  "+pokerCard[i].number);
            }
            System.out.print("  后墩："+pokerCard[7].number);
            for (i=8;i<12;i++)
            {
                System.out.print("  "+pokerCard[i].number);
            }
        }
        else if (oneLung())
        {
            int i;
            System.out.print("一条龙  前墩："+pokerCard[12].number+" 花色"+pokerCard[12].colour);
            for (i=0;i<2;i++)
            {
                System.out.print("  "+pokerCard[i].number+" 花色"+pokerCard[i].colour);
            }
            System.out.print("  中墩："+pokerCard[2].number+" 花色"+pokerCard[2].colour);
            for (i=3;i<7;i++)
            {
                System.out.print("  "+pokerCard[i].number+" 花色"+pokerCard[i].colour);
            }
            System.out.print("  后墩："+pokerCard[7].number+" 花色"+pokerCard[7].colour);
            for (i=8;i<12;i++)
            {
                System.out.print("  "+pokerCard[i].number+" 花色"+pokerCard[i].colour);
            }
        }
        else if (twelveRoyalty())
        {
            int i;
            if (pokerCard[12].number==13)
            {
                System.out.print("十二皇族  前墩："+pokerCard[12].number+" 花色"+pokerCard[12].colour);
                for (i=0;i<2;i++)
                {
                    System.out.print("  "+pokerCard[i].number+" 花色"+pokerCard[i].colour);
                }
                System.out.print("  中墩："+pokerCard[2].number+" 花色"+pokerCard[2].colour);
                for (i=3;i<7;i++)
                {
                    System.out.print("  "+pokerCard[i].number+" 花色"+pokerCard[i].colour);
                }
                System.out.print("  后墩："+pokerCard[7].number+" 花色"+pokerCard[7].colour);
                for (i=8;i<12;i++)
                {
                    System.out.print("  "+pokerCard[i].number+" 花色"+pokerCard[i].colour);
                }
            }
            else
            {
                System.out.print("前墩："+pokerCard[0].number+" 花色"+pokerCard[0].colour);
                for (i=1;i<3;i++)
                {
                    System.out.print("  "+pokerCard[i].number+" 花色"+pokerCard[i].colour);
                }
                System.out.print("  中墩："+pokerCard[3].number+" 花色"+pokerCard[3].colour);
                for (i=4;i<8;i++)
                {
                    System.out.print("  "+pokerCard[i].number+" 花色"+pokerCard[i].colour);
                }
                System.out.print("  后墩："+pokerCard[8].number+" 花色"+pokerCard[8].colour);
                for (i=9;i<13;i++)
                {
                    System.out.print("  "+pokerCard[i].number+" 花色"+pokerCard[i].colour);
                }
            }
        }
        else if (threeFlush())
        {
        }
        else
        {
            System.out.println("no");
        }
    }
    private boolean maxLung()                               //判断是不是至尊清龙
    {
        int i;
        int r=pokerCard[0].colour;
        for (i=0;i<13;i++)
        {
            if (pokerCard[i].colour!=r||pokerCard[i].number!=i+1)
            {
                return false;
            }
        }
        return true;
    }
    private boolean oneLung()                               //判断是不是一条龙
    {
        int i;
        for (i=0;i<13;i++)
        {
            if (pokerCard[i].number!=i+1)
            {
                return false;
            }
        }
        return true;
    }
    private boolean twelveRoyalty()                         //判断是不是十二皇族
    {
        int i;
        int n=0;
        for (i=0;i<13;i++)
        {
            if (pokerCard[i].number>12||pokerCard[i].number<10)
            {
                n++;
                if (n==2)
                {
                    return false;
                }
            }
        }
        return true;
    }
    private boolean threeFlush()                            //判断是不是三同花顺
    {
        int i,j,m=0,n=0;
        int ks[]=new int[4];                                //存放每个花色多少张牌
        int k[][]=new int[4][13];                           //存放每个花色的牌对应的序号
        for (i=0;i<13;i++) {
            k[pokerCard[i].colour][ks[pokerCard[i].colour]] = i;
            ks[pokerCard[i].colour]++;
        }
        for (i=0;i<4;i++)
        {
            if (ks[i]!=3&&ks[i]!=5&&ks[i]!=0)
            {
                return false;
            }
        }
        for (i=0;i<4;i++)
        {
            for (j=0;j<ks[i]-1;j++)
            {
                if (pokerCard[k[i][j]].number+1!=pokerCard[k[i][j+1]].number)
                {
                    return false;
                }
            }
        }
        for (i=0;i<4;i++)
        {
            if (ks[i]==3)
            {
                System.out.println("三同花顺 前墩："+pokerCard[k[i][0]].number+"  "+pokerCard[k[i][1]].number+"  "+pokerCard[k[i][2]].number+" 花色："+i);
            }
            if (ks[i]==5&&m==0)
            {
                m=i;
            }
            else if (ks[i]==5)
            {
                n=i;
            }
        }
        if (k[m][0]>k[n][0])
        {
            j=m;
            m=n;
            n=j;
        }
        System.out.println("中墩："+pokerCard[k[m][0]].number+"  "+pokerCard[k[m][1]].number+"  "+pokerCard[k[m][2]].number+"  "+pokerCard[k[m][3]].number+"  "+pokerCard[k[m][4]].number+" 花色："+m);
        System.out.println("后墩："+pokerCard[k[n][0]].number+"  "+pokerCard[k[n][1]].number+"  "+pokerCard[k[n][2]].number+"  "+pokerCard[k[n][3]].number+"  "+pokerCard[k[n][4]].number+" 花色："+n);
        return true;
    }
    private boolean threePoints()                           //判断是不是三分天下
    {
        int m=0;
        int i;
        int ns[]=new int[13];                                //存放每个数字多少张牌
        for (i=0;i<13;i++)
        {
            ns[pokerCard[i].number]++;
            if (ns[pokerCard[i].number]==1)
            {
                m++;
            }
            if (m==5)
            {
                return false;
            }
        }
        for (i=0;i<13;i++)
        {
            if (ns[i]==4)
            {

            }
        }
    }
}
