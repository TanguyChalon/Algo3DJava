package TP5;

import org.lwjgl.opengl.GL11;
import TP4.Vecteur3D;

/**
 * La classe translation applique une translation définie par
 * l'attribut m_coordonnees 
 *
 * @author Tanguy CHALON
 * @version 20/03/2019
 */
public abstract class Translation extends Transformation 
{
    //ce vecteur stocke les coordonnees de translation 
    private Vecteur3D m_coordonnees; 
    /** 
     * Ce constructeur fixe les coordonnées de translation en même temps qu'une référence vers l'instance de noeud parent
     * @param _parent le noeud déclaré comme parent de l'instance courante (this)
     * @param _coordonnees les coordonnées de translation à appliquer
     */
    public Translation(Noeud _parent, Vecteur3D _coordonnees)
    {
        super(_parent);
        m_coordonnees = _coordonnees; 
    }

    /** 
     * Implémentation de la méthode abstraite transforme() déclarée initialement dans la classe
     * abstraite Transformation. Elle consiste à appeler l'instruction OpenGL glTranslatef
     * avec trois coordonnées (float) 
     */
    public void transforme()
    {
        GL11.glTranslatef(m_coordonnees.getX(), m_coordonnees.getY(), m_coordonnees.getZ());
    }
}
