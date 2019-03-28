package TP5;

import org.lwjgl.opengl.GL11; 
/**
 * La classe transformation permet de factoriser le code comun aux classes
 * filles Translation, Rotation et Echelle. 
 * Les fonctions communes à ses transformations sont principalement l'empilement 
 * et le dépilement de matrices. 
 *
 * @author Tanguy CHALON
 * @version 20/03/2019
 */
public abstract class Transformation extends Noeud
{

    public Transformation(Noeud _parent){
        super(_parent);
    }

    public abstract void transforme(); 
    public abstract void rotation();
    public abstract void scale (); 
    
    public void afficher(){
        //On empile la matrice de transformation sur la matrice courante
        GL11.glPushMatrix();
        
        //Ici on éxécute la transformation de la classe. Même si on ne sait pas encore
        //de quelle transformation il s'agit
        transforme();

        //Ici on fait quelque chose, on dessine le contenu de tous les éléments de cette classe 
        //plus le contenu des noeuds enfants 
        //il s'agit de parcourir le contenu du vecteur contenant les enfants 
        //et d'appeler la méthode afficher() pour chaque enfant référencé dans le vecteur

        for(int i=0; i<m_enfants.size(); i++)
        {
            m_enfants.get(i).afficher();
        }

        //On dépile la matrice de transformation pour revenir à la matrice courante
        GL11.glPopMatrix();
    }
}
