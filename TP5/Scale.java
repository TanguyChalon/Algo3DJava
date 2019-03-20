package TP5;

import org.lwjgl.opengl.GL11;
import TP4.Vecteur3D;

/**
 * La classe echelle applqiue une 
 *
 * @author Tanguy CHALON
 * @version 20/03/2019
 */
public abstract class Scale extends Transformation
{
    private Vecteur3D m_vecteurEchelle;

    public Scale (Noeud _parent, Vecteur3D _vecteurEchelle)
    {
        super(_parent);
        m_vecteurEchelle = _vecteurEchelle; 
      
    }
    
    public void Scaling()
    {
        GL11.glScalef(m_vecteurEchelle.getX(), m_vecteurEchelle.getY(), m_vecteurEchelle.getZ());
    }
}
