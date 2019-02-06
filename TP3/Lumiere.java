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
 * Classe lumi�re. Cette classe est abstraite, elle sert � factoriser les attributs communs � toutes 
 * les lumi�res : la composante ambiante, la composante sp�culaire et la composante diffuse. 
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
     * Ce constructeur assigne une parmi les 8 lumi�res disponibles en OpenGL 1.1. 
     * Le compteur m_currentLight est statique, c'est � dire que toutes les instances 
     * de la classe lumi�re partagent la valeur de m_currentLight.
     * Chaque instance connait donc le nombre de lumi�re instanci�es. 
     */

    public Lumiere() {
        m_currentLight = m_nextLight;
        m_nextLight ++;
    }

    /** 
     * Constructeur de la classe lumi�re prenant en param�tres 3 instances 
     * de vecteur3D pour les composantes ambiantes, diffuses et sp�culaire de la lumi�re. 
     * 
     * @param _vecteurAmbiant la composante ambiante de la lumi�re (Vecteur3D) 
     * @param _vecteurDiffus la composante ambiante de la lumi�re (Vecteur3D) 
     * @param _vecteurSpeculaire la composante ambiante de la lumi�re (Vecteur3D) 
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
     * Initialisation de la lumi�re courante. 
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
     * Active la lumi�re courante (on suppose que GL_LIGHTING) est �galement activ�
     */
    public void allumer()
    {
        GL11.glEnable(m_currentLight);
    }

    /**
     * D�sactive la lumi�re courante (on suppose que GL_LIGHTING) est �galement activ�
     */
    public void eteindre()
    {
        GL11.glDisable(m_currentLight);
    }
}
