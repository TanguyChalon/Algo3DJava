package TP4;

import org.lwjgl.opengl.GL11;
import org.lwjgl.BufferUtils;
import java.nio.FloatBuffer;

/**
 * La classe LumierePonctuelle représente une source de lumière ponctuelle.
 * Elle est définie par un point dans l'espace à partir duquel vont irradier
 * les rayons émis par cette source lumineuse ponctuelle
 *
 * @author Tanguy CHALON
 * @version 19/03/2019
 */
public class LumierePonctuelle extends Lumiere
{
    // Tableau de floats de dimension 4 représentant l'origine de la source lumineuse (appelé m_position) 
    // La quatrième valeur de ce vecteur vaut 1 : cela signifie que ce tableau de réels sera interprété 
    // en tant que paramètre de lumière ponctuelle lors de la phase d'initialisation
    
    private float[] m_position = {0.0f,0.0f,0.0f,1.0f};
    
    /**
     * Constructeur de la lumière directionnelle, il prend quatre arguments
     * @param _vecteurAmbient composante ambiante de la lumière 
     * @param _vecteurDiffus composante diffuse de la lumière
     * @param _vecteurSpeculaire composante speculaire de la lumière
     * @param _direction vecteur donnant la direction des rayons émis 
     */
    
    public LumierePonctuelle(Vecteur3D _vecteurAmbiant, Vecteur3D _vecteurDiffus, 
                             Vecteur3D _vecteurSpeculaire, Vecteur3D _position)
    
    {
    //On appelle le constructeur de la classe parente avec ses paramètres
    super(_vecteurAmbiant, _vecteurDiffus, _vecteurSpeculaire);
    //Avec le dernier paramètre, on initialise l'attribut m_possition (il s'agit d'un tableau de réels de 
    //dimension quatre
    
    m_position[0] = _position.getX();
    m_position[1] = _position.getY();
    m_position[2] = _position.getZ();
    m_position[3] = 0.0f; //la dernière valeur du tableau de réel est égal à 0 pour indiquer 
    // qu'il s'agit d'une lumière ponctuelle
    //https://www.khronos.org/registry/OpenGL-Refpages/gl2.1/
    
    }
    
    /**
     * Constructeur par défaut de la classe LumierePonctuelle, il ne prend pas l'argument. 
     * Il place une lumière poncutelle à l'origine du système de coordonnées (0.0f,0.0f,0.0f)
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
     * de lumière directionelle après avoir appelé la méthode d'initialisation de la 
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
