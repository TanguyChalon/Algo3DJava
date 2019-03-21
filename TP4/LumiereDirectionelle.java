package TP4;

import org.lwjgl.opengl.GL11;
import org.lwjgl.BufferUtils;
import java.nio.FloatBuffer;

/**
 * Une lumi�re directionelle repr�sente une source de lumi�re
 * situ�e � l'infiini : tous les rayons �mis par cette lumi�re sont parrall�les 
 * et leur direction est donn�e par un vecteur de dimension trois. 
 *
 * @author Tanguy CHALON
 * @version 19/03/2019
 */
public class LumiereDirectionelle extends Lumiere
{

    private float[] m_direction = {0.0f,0.0f,0.0f,0.0f};
    
    /**
     * Constructeur de la lumi�re directionnelle, il prend quatre arguments
     * @param _vecteurAmbient composante ambiante de la lumi�re 
     * @param _vecteurDiffus composante diffuse de la lumi�re
     * @param _vecteurSpeculaire composante speculaire de la lumi�re
     * @param _direction vecteur donnant la direction des rayons �mis 
     */
    public LumiereDirectionelle(Vecteur3D _vecteurAmbiant, Vecteur3D _vecteurDiffus, 
                             Vecteur3D _vecteurSpeculaire, Vecteur3D _direction)
    {
        super(_vecteurAmbiant, _vecteurDiffus, _vecteurSpeculaire);
        m_direction[0] = _direction.getX();
        m_direction[1] = _direction.getY();
        m_direction[2] = _direction.getZ();
        m_direction[3] = 1.0f;      
        
        //https://www.khronos.org/registry/OpenGL-Refpages/gl2.1/
        
    }
        
        /**
     * Constructeur par d�faut de la classe LumierePonctuelle, il ne prend pas l'argument. 
     * Il place une lumi�re poncutelle � l'origine du syst�me de coordonn�es (0.0f,0.0f,0.0f)
     */
    
    public LumiereDirectionelle()
    {
        super();
        m_direction[0] = 0.0f;
        m_direction[1] = -1.0f;//les rayons "tombent" verticalement 
        m_direction[2] = 0.0f;
        m_direction[3] = 0.0f;
    }
    
    /**
     * On initialise la valeur du vecteur de direction pour cette instance de classe 
     * de lumi�re directionelle apr�s avoir appel� la m�thode d'initialisation de la 
     * classe parente
     */
    public void initialise()
    {
        super.initialise();
        
        FloatBuffer buffDirection = BufferUtils.createFloatBuffer(4).put(m_direction);
        buffDirection.position(0);

        GL11.glLight(m_currentLight, GL11.GL_AMBIENT, buffDirection);
        
    }

}
