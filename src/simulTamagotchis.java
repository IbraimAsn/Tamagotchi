import java.util.Scanner;

public class simulTamagotchis
{
    static Scanner in = new Scanner(System.in);
    
    public static void initializeAllGotchis(Tamagotchi gotchiArr[])
    {
        String gotchiName;
        for(int i = 0; i < gotchiArr.length; i++)
        {
            System.out.printf("Quel nom pour le nouveau tamagotchi : ");
            gotchiName = in.nextLine();
            gotchiArr[i] = new Tamagotchi(gotchiName);  
        }
    }

    public static void displayAllGotchis(Tamagotchi gotchiArr[])
    {
        for(int i = 0; i < gotchiArr.length; i++)
        {
            System.out.printf("\tnom : %s\n",gotchiArr[i].getNom());
            //gotchiArr[i].parler();
            displayStats(gotchiArr[i]);
            if(i != gotchiArr.length - 1)
            {
                System.out.printf("\n--------------------\n\n");
            }
        }
    }

    public static void displayStats(Tamagotchi currentGotchi)
    {
        System.out.printf("\tforme : %s\n",currentGotchi.getForme());
        System.out.printf("\tenergie : %s\n",currentGotchi.getEnergie());
        System.out.printf("\tmaxEnergie : %s\n",currentGotchi.getMaxEnergie());    
    }

    public static void displayCycleInfo(Tamagotchi gotchiArr[], int cycleNumber, int quiEstMort)
    {
        System.out.printf("\n--------Cycle no %d--------\n",cycleNumber);
        if(quiEstMort != -1)
        {
        	System.out.printf("%s : je meurs... Arrrggh !\n",gotchiArr[quiEstMort].getNom());
        }
        else
        {
        	for(int i = 0; i < gotchiArr.length; i++)
            {
                System.out.printf("-%s\n",gotchiArr[i].getNom());
                displayStats(gotchiArr[i]);
            }
            System.out.println();
            for(int i = 0; i < gotchiArr.length; i++)
            {
                System.out.printf("(%d) %s\t",i,gotchiArr[i].getNom());
            }
            System.out.println();
        }
    }

    public static void nourrir(Tamagotchi gotchiArr[], int quiNourrir)
    {
        gotchiArr[quiNourrir].manger();
        gotchiArr[quiNourrir].setForme();
    }

    public static void faireVivreEveryone(Tamagotchi gotchiArr[])
    {
        for(int i = 0; i < gotchiArr.length; i++)
        {
            gotchiArr[i].vivre();
        }
    }

    public static int quelqunEstMort(Tamagotchi gotchiArr[])
    {
        for(int i = 0; i < gotchiArr.length; i++)
        {
            if(gotchiArr[i].getEnergie() <= 0)
            {
                return i;
            }
        }
        return -1;
    }
    
    public static void main(String[] args)
    {
        System.out.print("Nombre de Tamagotchis : ");
        int nbrGotchis = 0, quiNourrir = 0, cycleNumber = 0, quiEstMort = -1;
        try {
            nbrGotchis = Integer.parseInt(in.nextLine());
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
        System.out.println();
        Tamagotchi gotchiArr[] = new Tamagotchi[nbrGotchis];
        initializeAllGotchis(gotchiArr);
        System.out.printf("\n--------------------\n\n");
        displayAllGotchis(gotchiArr);
        while((quiEstMort = quelqunEstMort(gotchiArr)) == -1)
        {
            displayCycleInfo(gotchiArr, cycleNumber, quiEstMort);
            faireVivreEveryone(gotchiArr);
            System.out.print("Nourrir quel Tamagotchi ? ");
            quiNourrir = in.nextInt();
            nourrir(gotchiArr, quiNourrir);
            cycleNumber++;
        }
        displayCycleInfo(gotchiArr, cycleNumber, quiEstMort);
        in.close(); 
    }
}