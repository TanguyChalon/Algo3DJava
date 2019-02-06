package TP3;

import java.awt.image.BufferedImage;
import org.lwjgl.LWJGLException;
import org.lwjgl.Sys;
import org.lwjgl.input.Keyboard;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;
import org.lwjgl.opengl.GL11;

import org.lwjgl.BufferUtils;
import java.nio.FloatBuffer;

import org.lwjgl.util.glu.GLU;  

import java.io.*;
/**
 * Classe lumière. Cette classe est abstraite, elle sert à factoriser les attributs communs à toutes 
 * les lumières : la composante ambiante, la composante spéculaire et la composante diffuse. 
 *
 * @author (Tanguy CHALON)
 * @version (06/02/2019)
 */
public abstract class Lumiere
{
    private float[] m_ambiantComponent = {0.0f, 0.0f, 0.0f, 0.0f};
    private float[] m_diffuseComponent = {0.0f, 0.0f, 0.0f, 0.0f};
    private float[] m_specularComponent = {0.0f, 0.0f, 0.0f, 0.0f};

    protected int m_currentLight = -1;

    private static int m_nextLight = GL11.GL_LIGHT0;

    /**
     * Ce constructeur assigne une parmi les 8 lumières disponibles en OpenGL 1.1. 
     * Le compteur m_currentLight est statique, c'est à dire que toutes les instances 
     * de la classe lumière partagent la valeur de m_currentLight.
     * Chaque instance connait donc le nombre de lumière instanciées. 
     */

    public Lumiere() {
        m_currentLight = m_nextLight;
        m_nextLight ++;
    }

    /** 
     * Constructeur de la classe lumière prenant en paramètres 3 instances 
     * de vecteur3D pour les composantes ambiantes, diffuses et spéculaire de la lumière. 
     * 
     * @param _vecteurAmbiant la composante ambiante de la lumière (Vecteur3D) 
     * @param _vecteurDiffus la composante ambiante de la lumière (Vecteur3D) 
     * @param _vecteurSpeculaire la composante ambiante de la lumière (Vecteur3D) 
     */
    
    public Lumiere(Vecteur3D _vecteurAmbiant, Vecteur3D _vecteurDiffus, Vecteur3D _vecteurSpeculaire)
    {
        m_ambiantComponent [0] = _vecteurAmbiant.getX();
        m_ambiantComponent [0] = _vecteurAmbiant.getY();
        m_ambiantComponent [0] = _vecteurAmbiant.getZ();
        m_ambiantComponent [0] = 1.0f;
        
        m_diffuseComponent [0] = _vecteurDiffus.getX();
        m_diffuseComponent [0] = _vecteurDiffus.getY();
        m_diffuseComponent [0] = _vecteurDiffus.getZ();
        m_diffuseComponent [0] = 1.0f;
     
        m_specularComponent [0] = _vecteurSpeculaire.getX();
        m_specularComponent [0] = _vecteurSpeculaire.getY();
        m_specularComponent [0] = _vecteurSpeculaire.getZ();
        m_specularComponent [0] = 1.0f;
    }
    
    /** 
     * Initialisation de la lumière courante. 
     */
    
    public void initialise()
    { 
        FloatBuffer buffAmbient = BufferUtils.createFloatBuffer(4).put(m_ambiantComponent);
        buffAmbient.position(0);
                
        FloatBuffer buffDiffuse = BufferUtils.createFloatBuffer(4).put(m_diffuseComponent);
        buffDiffuse.position(0);
        
        FloatBuffer buffSpecular = BufferUtils.createFloatBuffer(4).put(m_specularComponent);
        buffSpecular.position(0);
    
        GL11.glLight(GL11.GL_LIGHT1, GL11.GL_AMBIENT, buffAmbient);
        GL11.glLight(GL11.GL_LIGHT1, GL11.GL_DIFFUSE, buffDiffuse);
        GL11.glLight(GL11.GL_LIGHT1, GL11.GL_SPECULAR, buffSpecular);
    }
    
    /**
     * Active la lumière courante (on suppose que GL_LIGHTING) est également activé
     */
    public void allumer()
    {
        GL11.glEnable(m_currentLight);
    }

    /**
     * Désactive la lumière courante (on suppose que GL_LIGHTING) est également activé
     */
    public void eteindre()
    {
        GL11.glDisable(m_currentLight);
    }
}
