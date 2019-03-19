package TP4;

import org.lwjgl.opengl.GL11;
import org.lwjgl.BufferUtils;
import java.nio.FloatBuffer;

/**
 * La classe LumierePonctuelle repr�sente une source de lumi�re ponctuelle.
 * Elle est d�finie par un point dans l'espace � partir duquel vont irradier
 * les rayons �mis par cette source lumineuse ponctuelle
 *
 * @author Tanguy CHALON
 * @version 19/03/2019
 */
public class LumierePonctuelle extends Lumiere
{
    // Tableau de floats de dimension 4 repr�sentant l'origine de la source lumineuse (appel� m_position) 
    // La quatri�me valeur de ce vecteur vaut 1 : cela signifie que ce tableau de r�els sera interpr�t� 
    // en tant que param�tre de lumi�re ponctuelle lors de la phase d'initialisation
    
    private float[] m_position = {0.0f,0.0f,0.0f,1.0f};
    
    /**
     * Constructeur de la lumi�re directionnelle, il prend quatre arguments
     * @param _vecteurAmbient composante ambiante de la lumi�re 
     * @param _vecteurDiffus composante diffuse de la lumi�re
     * @param _vecteurSpeculaire composante speculaire de la lumi�re
     * @param _direction vecteur donnant la direction des rayons �mis 
     */
    
    public LumierePonctuelle(Vecteur3D _vecteurAmbiant, Vecteur3D _vecteurDiffus, 
                             Vecteur3D _vecteurSpeculaire, Vecteur3D _position)
    
    {
    //On appelle le constructeur de la classe parente avec ses param�tres
    super(_vecteurAmbiant, _vecteurDiffus, _vecteurSpeculaire);
    //Avec le dernier param�tre, on initialise l'attribut m_possition (il s'agit d'un tableau de r�els de 
    //dimension quatre
    
    m_position[0] = _position.getX();
    m_position[1] = _position.getY();
    m_position[2] = _position.getZ();
    m_position[3] = 0.0f; //la derni�re valeur du tableau de r�el est �gal � 0 pour indiquer 
    // qu'il s'agit d'une lumi�re ponctuelle
    //https://www.khronos.org/registry/OpenGL-Refpages/gl2.1/
    
    }
    
    /**
     * Constructeur par d�faut de la classe LumierePonctuelle, il ne prend pas l'argument. 
     * Il place une lumi�re poncutelle � l'origine du syst�me de coordonn�es (0.0f,0.0f,0.0f)
     */
    
    public LumierePonctuelle()
    {
        super();
        m_position[0] = 0.0f;
        m_position[1] = 0.0f;
        m_position[2] = 0.0f;
        m_position[3] = 1.0f;
   
    }
    /**
     * On initialise la valeur du vecteur de direction pour cette instance de classe 
     * de lumi�re directionelle apr�s avoir appel� la m�thode d'initialisation de la 
     * classe parente
     */
    public void initialise()
    {
        super.initialise();
        
        FloatBuffer buffPosition = BufferUtils.createFloatBuffer(4).put(m_position);
        buffPosition.position(0);

        GL11.glLight(m_currentLight, GL11.GL_AMBIENT, buffPosition);    
    }
    
}
