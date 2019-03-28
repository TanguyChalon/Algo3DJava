package TP5;

import org.lwjgl.opengl.GL11;
import TP4.Vecteur3D;

/**
 * Write a description of class Rotation here.
 *
 * @author Tanguy CHALON
 * @version 20/03/2019
 */
public abstract class Rotation extends Transformation
{
    private Vecteur3D m_coordonnees;
    private float m_angle; 

    public Rotation (Noeud _parent, Vecteur3D _coordonnees, float _angle)
    {
        super(_parent);
        m_coordonnees = _coordonnees; 
        m_angle = _angle; 
    }
    
    public void Rotate()
    {
        GL11.glRotatef(m_angle, m_coordonnees.getX(), m_coordonnees.getY(), m_coordonnees.getZ());
    }
}
