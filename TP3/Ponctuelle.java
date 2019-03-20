package TP3;

/**
 * Write a description of class Ponctuelle here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */

public class Ponctuelle extends Lumiere
{
    
    private float m_direction[] = {0.0f,0.0f,0.0f,0.0f};
    /**
     * Constructor for objects of class Ponctuelle
     */

    public Ponctuelle(Vecteur3D _vecteurAmbiant, Vecteur3D _vecteurDiffus, Vecteur3D _vecteurSpeculaire)
    {
        super(_vecteurAmbiant, _vecteurDiffus, _vecteurSpeculaire);
        m_direction[0] =  _direction.getX();
        m_direction[0] =  _direction.getY();
        m_direction[0] =  _direction.getZ();
    }
    public void initialise()
    {
        super.initialise();
        FloatBuffer buffDirection = BufferUtils.createFloatBuffer(4).put(m_direction);
        m_direction[0] =  _direction.getY();
        m_direction[0] =  _direction.getZ();
    }
    
}
