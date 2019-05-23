package TP6;
import TP4.*;

/**
 * D�crivez votre classe pioche ici.
 *
 * @author (votre nom)
 * @version (un num�ro de version ou une date)
 */
public class pioche extends Objet
{
    // variables d'instance - remplacez l'exemple qui suit par le v�tre
    private int x;

    /**
     * Constructeur d'objets de classe pioche
     */
    public pioche(Noeud _parent)
    {
       super(_parent);
        // initialisation des variables d'instance
        x = 0;
        Vecteur3D monVecteur = new Vecteur3D(0.0f,0.0f,-25.0f);

        // � partir d'ici, on construit le graphe de sc�ne 
        Transformation maTranslation = new Translation(_parent, monVecteur);
   
        int i = 0;
      
        while(i < 20)
        {
                 //car�  droite
        Vecteur3D decaleGauche1 = new Vecteur3D(-8.0f+i,-8.0f+i,-15.0f);
        Transformation aGauche1 = new Translation(maTranslation, decaleGauche1);
        CubeTexture monCubeTex1= new CubeTexture(aGauche1,"/TP6/res/normale.png");
        i=i+2;    
        
        }
        int n =4;
         while(n < 24)
        {
                 //car�  droite
        Vecteur3D decaleGauche3 = new Vecteur3D(-10.0f+n,-14.0f+n,-15.0f);
        Transformation aGauche3 = new Translation(maTranslation, decaleGauche3);
        CubeTexture monCubeTex3= new CubeTexture(aGauche3,"/TP6/res/foncer.png");
        n=n+2;    
        
        }
        
        int v = 2;
         while(v < 24)
        {
                 //car�  droite
        Vecteur3D decaleGauche2 = new Vecteur3D(-10.0f+v,-12.0f+v,-15.0f);
        Transformation aGauche2 = new Translation(maTranslation, decaleGauche2);
        CubeTexture monCubeTex2= new CubeTexture(aGauche2,"/TP6/res/claire.png");
       v=v+4;    
        
        }
        
         int g = 4;
         while(g < 24)
        {
                 //car�  droite
        Vecteur3D decaleGauche4 = new Vecteur3D(-10.0f+g,-12.0f+g,-15.0f);
        Transformation aGauche4 = new Translation(maTranslation, decaleGauche4);
        CubeTexture monCubeTex4= new CubeTexture(aGauche4,"/TP6/res/moyen.png");
       g=g+4;    
        
        }
        
        // Partie gris
        
        // gris fonce
        Vecteur3D decaleGauche4 = new Vecteur3D(8.0f,10f,-15.0f);
        Transformation aGauche4 = new Translation(maTranslation, decaleGauche4);
        CubeTexture monCubeTex4= new CubeTexture(aGauche4,"/TP6/res/grisfoncer.png");
        
        
        Vecteur3D decaleGauche5 = new Vecteur3D(12.0f,6f,-15.0f);
        Transformation aGauche5 = new Translation(maTranslation, decaleGauche5);
        CubeTexture monCubeTex5= new CubeTexture(aGauche5,"/TP6/res/grisfoncer.png");
        
        Vecteur3D decaleGauche6 = new Vecteur3D(-4f,10f,-15.0f);
        Transformation aGauche6 = new Translation(maTranslation, decaleGauche6);
        CubeTexture monCubeTex6= new CubeTexture(aGauche6,"/TP6/res/grisfoncer.png");
        
         Vecteur3D decaleGauche7 = new Vecteur3D(12.0f,-6f,-15.0f);
        Transformation aGauche7 = new Translation(maTranslation, decaleGauche7);
        CubeTexture monCubeTex7= new CubeTexture(aGauche7,"/TP6/res/grisfoncer.png");
        
         int y = 4;
         while(y < 14)
        {
                 //car�  droite
        Vecteur3D decaleGauche8 = new Vecteur3D(10.0f-y,12f,-15.0f);
        Transformation aGauche8 = new Translation(maTranslation, decaleGauche8);
        CubeTexture monCubeTex8= new CubeTexture(aGauche8,"/TP6/res/grisfoncer.png");
       y=y+2;    
        
        }
           int u = 4;
         while(u < 12)
        {
                 //car�  droite
        Vecteur3D decaleGauche9 = new Vecteur3D(8.0f-u,8f,-15.0f);
        Transformation aGauche9 = new Translation(maTranslation, decaleGauche9);
        CubeTexture monCubeTex9= new CubeTexture(aGauche9,"/TP6/res/grisfoncer.png");
       u=u+2;    
        
        }
           int o = 4;
         while(o < 12)
        {
                 //car�  droite
        Vecteur3D decaleGauche8 = new Vecteur3D(10.0f,6f-o,-15.0f);
        Transformation aGauche8 = new Translation(maTranslation, decaleGauche8);
        CubeTexture monCubeTex8= new CubeTexture(aGauche8,"/TP6/res/grisfoncer.png");
       o=o+2;    
        
        }
           int p = 4;
         while(p < 14)
        {
                 //car�  droite
        Vecteur3D decaleGauche8 = new Vecteur3D(14.0f,8f-p,-15.0f);
        Transformation aGauche8 = new Translation(maTranslation, decaleGauche8);
        CubeTexture monCubeTex8= new CubeTexture(aGauche8,"/TP6/res/grisfoncer.png");
       p=p+2;    
        
        }
        
        //gris claire
          
        Vecteur3D decaleGauche8 = new Vecteur3D(8.0f,6f,-15.0f);
        Transformation aGauche8 = new Translation(maTranslation, decaleGauche8);
        CubeTexture monCubeTex8 = new CubeTexture(aGauche8,"/TP6/res/grisclaire.png");
        
         Vecteur3D decaleGauche10 = new Vecteur3D(-2.0f,10f,-15.0f);
        Transformation aGauche10 = new Translation(maTranslation, decaleGauche10);
        CubeTexture monCubeTex10 = new CubeTexture(aGauche10,"/TP6/res/grisclaire.png");
        
        Vecteur3D decaleGauche11 = new Vecteur3D(6f,10f,-15.0f);
        Transformation aGauche11 = new Translation(maTranslation, decaleGauche11);
        CubeTexture monCubeTex11 = new CubeTexture(aGauche11,"/TP6/res/grisclaire.png");
        
        Vecteur3D decaleGauche12 = new Vecteur3D(12.0f,4f,-15.0f);
        Transformation aGauche12 = new Translation(maTranslation, decaleGauche12);
        CubeTexture monCubeTex12 = new CubeTexture(aGauche12,"/TP6/res/grisclaire.png");
        
        Vecteur3D decaleGauche13 = new Vecteur3D(12.0f,-4f,-15.0f);
        Transformation aGauche13 = new Translation(maTranslation, decaleGauche13);
        CubeTexture monCubeTex13 = new CubeTexture(aGauche13,"/TP6/res/grisclaire.png");
        
        // Gris moyen
        
             int b = 4;
         while(b < 10)
        {
                 //car�  droite
        Vecteur3D decaleGauche14 = new Vecteur3D(12.0f,6f-b,-15.0f);
        Transformation aGauche14 = new Translation(maTranslation, decaleGauche14);
        CubeTexture monCubeTex14= new CubeTexture(aGauche14,"/TP6/res/grismoyen.png");
       b=b+2;    
        
        }
        
              int m = 4;
         while(m < 10)
        {
                 //car�  droite
        Vecteur3D decaleGauche14 = new Vecteur3D(8.0f-m,10f,-15.0f);
        Transformation aGauche14 = new Translation(maTranslation, decaleGauche14);
        CubeTexture monCubeTex14= new CubeTexture(aGauche14,"/TP6/res/grismoyen.png");
       m=m+2;    
        
        }
        
        Vecteur3D decaleGauche14 = new Vecteur3D(8.0f,8f,-15.0f);
        Transformation aGauche14 = new Translation(maTranslation, decaleGauche14);
        CubeTexture monCubeTex14= new CubeTexture(aGauche14,"/TP6/res/grismoyen.png");
        
        Vecteur3D decaleGauche15 = new Vecteur3D(6.0f,8f,-15.0f);
        Transformation aGauche15 = new Translation(maTranslation, decaleGauche15);
        CubeTexture monCubeTex15= new CubeTexture(aGauche15,"/TP6/res/grismoyen.png");
        
           Vecteur3D decaleGauche16 = new Vecteur3D(10.0f,6f,-15.0f);
        Transformation aGauche16 = new Translation(maTranslation, decaleGauche16);
        CubeTexture monCubeTex16= new CubeTexture(aGauche16,"/TP6/res/grismoyen.png");
        
        Vecteur3D decaleGauche17 = new Vecteur3D(10.0f,4f,-15.0f);
        Transformation aGauche17 = new Translation(maTranslation, decaleGauche17);
        CubeTexture monCubeTex17= new CubeTexture(aGauche17,"/TP6/res/grismoyen.png");
        
        
        // Vecteur3D decaleHauttt = new Vecteur3D(-1.0f,6.0f,0.0f);
        // Vecteur3D echelle9 = new Vecteur3D(0.5f,0.5f,0.5f);
        // Transformation hauttt = new Translation(maTranslation, decaleHauttt);
        // Echelle echelle9 = new Echelle(hauttt, vecteurEchelle);
        // CubeTexture monCubeLine9 = new CubeTexture(echelle9,"/TP6/res/bob1.png");
        
        // int j=5;
        // for (int i = 1; i <= 3; i++) {
            // if (j>0)
            // {
                // Transformation aDroite = new Translation(maTranslation, decaleDroite);
                // CubeTexture monCubeTex = new CubeTexture(aGauche,"/TP6/res/bob2.png");
                // j = j-2;
            // } 
        // }

        
    }

    /**
     * Un exemple de m�thode - remplacez ce commentaire par le v�tre
     *
     * @param  y   le param�tre de la m�thode
     * @return     la somme de x et de y
     */
    public int sampleMethod(int y)
    {
        // Ins�rez votre code ici
        return x + y;
    }
   
    public void dessine()
    {
        //affiche();
    }
}
