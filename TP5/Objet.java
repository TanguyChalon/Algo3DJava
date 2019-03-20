package TP5;

import org.lwjgl.opengl.GL11;

/**
 * Write a description of class Objet here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public abstract class Objet extends Noeud
{
    public Objet(Noeud _parent) {
        super(_parent);
    }
    
    public abstract void dessine(); 
        
    public void afficher(){
        //Ici on �x�cute la transformation de la classe. M�me si on ne sait pas encore
        //de quelle transformation il s'agit
        dessine();

        //Ici on fait quelque chose, on dessine le contenu de tous les �l�ments de cette classe 
        //plus le contenu des noeuds enfants 
        //il s'agit de parcourir le contenu du vecteur contenant les enfants 
        //et d'appeler la m�thode afficher() pour chaque enfant r�f�renc� dans le vecteur

        for(int i=0; i<m_enfants.size(); i++)
        {
            m_enfants.get(i).afficher();
        }
    } 
   
}
