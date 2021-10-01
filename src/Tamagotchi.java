import java.util.Random;

public class Tamagotchi {
    
    public Random rand = new Random();
    
    private int maxEnergie;
    private int energie;
    private String nom;
    private String forme;

    public int getMaxEnergie()
    {
        return maxEnergie;
    }
    
    
    public int getEnergie()
    {
        return energie;
    }

    public String getNom()
    {
        return nom;
    }

    public String getForme()
    {
        return forme;
    }

    public void setForme()
    {
        if(energie < 5)
        {
            forme = "affame";
        }
        else
        {
            forme = "heureux";
        }
    }

    public void parler()
    {
        System.out.printf("Bonjour, je m'appelle %s\n",nom);
        System.out.printf("Mon état de forme est : %s\n",forme);
    }

    public void manger()
    {
        if(energie == maxEnergie)
        {
            System.out.printf("%s : Je n'ai pas faim ! >:(\n",nom);
        }
        else if(maxEnergie - energie == 1)
        {
            energie += 1;
            System.out.printf("%s : Merci ! :D\n",nom);
        }
        else
        {
            energie += rand.nextInt(2) + 1;
            System.out.printf("%s : Merci ! :D\n",nom);
        }
    }

    public boolean vivre()
    {
        if(energie <= 0)
        {
            System.out.printf("%s : je meurs !!!\n",nom);
            return false;
        }
        energie--;
        return true;
    }

    public Tamagotchi(String nom)
    {
        this.nom = nom;
        this.maxEnergie = rand.nextInt(4) + 6;
        this.energie = rand.nextInt(3) + 3;
        setForme();
    }
}
