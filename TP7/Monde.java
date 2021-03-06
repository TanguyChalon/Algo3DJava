package TP7;

import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;
import org.lwjgl.opengl.GL11;

import org.lwjgl.util.glu.GLU;

import org.lwjgl.input.Keyboard;

import org.lwjgl.BufferUtils;
import java.nio.FloatBuffer;

import TP4.*;
import TP6.*;

import java.io.*;


/**
 * La classe Monde est le noeud primordial � l'origine du graphe
 * de sc�ne. Elle prend en charge les interactions ainsi que l'initialisation
 * du contexte OpenGL
 *
 * @author Alexis Heloir
 * @version 2019/03/21
 */
public class Monde extends Noeud
{
    static final int MS_ENTRE_DEUX_AFFICHAGES = 40; // 25 affichages par secondes

    private boolean m_done = false; // Est ce que l'application doit se terminer?
    private boolean m_fullscreen = false; // Est-ce que l'application doit �tre plein �cran?
    private final String m_windowTitle = "OpenGL et Graphe de sc�ne"; // Titre de l'application
    private boolean m_f1 = false; // A t-on appuy� sur la touche F1?
    private DisplayMode m_displayMode; // propri�t�s de la fen�tre d'affichage

    private boolean m_filter = false; // Est-ce  que l'on applique le mipmapping de texture 

    
    /**
     * Le constructuer de la classe Monde ne prend pas de parm�tre : la classe Monde 
     * n'a pas de parent car son instance (souvent unique) est � l'origine du graphe de sc�ne.
     */
    public Monde()
    {
        super(null);
    }
    
    /**
     * La m�thode affiche vides les buffers du contexte OpenGL puis appelle de mani�re 
     * r�cursive la m�thode affiche pour l'ensemble des noeuds enfants. Le graphe de scene est ainsi parcouru.
     */
    public void affiche(){
        GL11.glClear(GL11.GL_COLOR_BUFFER_BIT | GL11.GL_DEPTH_BUFFER_BIT);          // Clear The Screen And The Depth Buffer

        for (int i=0; i<m_enfants.size(); i++ )
        {
            m_enfants.get(i).affiche();
        }        
    }

    /**
     * M�thode responsable de la gestion des interactions avec l'utilisateur --
     * elle g�re principalement les interruptions clavier
     */
    private void interactionManagement() {
        if(Keyboard.isKeyDown(Keyboard.KEY_ESCAPE)) {       // Exit if Escape is pressed
            m_done = true;
        }
        if(Display.isCloseRequested()) {                     // Exit if window is closed
            m_done = true;
        }
        if(Keyboard.isKeyDown(Keyboard.KEY_F1) && !m_f1) {    // Is F1 Being Pressed?
            m_f1 = true;                                      // Tell Program F1 Is Being Held
            switchMode();                                   // Toggle Fullscreen / Windowed Mode
        }
        if(!Keyboard.isKeyDown(Keyboard.KEY_F1)) {          // Is F1 Being Pressed?
            m_f1 = false;
        }
        if(!Keyboard.isKeyDown(Keyboard.KEY_F)) {          // Is F Being Pressed?
            m_filter = true;
        }        
        if(!Keyboard.isKeyDown(Keyboard.KEY_D)) {          // Is F Being Pressed?
            m_filter = false;
        }        

    }

    /**
     *  Appel� par la m�thode interactionManagement() en charge de capturer les
     *  �v�nments clavier. Cette m�thode g�re l'attribut sanctionnant le mode plein
     *  �cran
     */
    private void switchMode() {
        m_fullscreen = !m_fullscreen;
        try {
            Display.setFullscreen(m_fullscreen);
        }
        catch(Exception e) {
            e.printStackTrace();
        }
    }
    
    
    public void start(boolean fullscreen) {
        this.m_fullscreen = fullscreen;
        try {
            initGL();
            prepareScene();
            while (!m_done) {
                Thread.sleep(MS_ENTRE_DEUX_AFFICHAGES);
                interactionManagement();
                affiche();
                Display.update();
            }
            cleanup();
        }
        catch (Exception e) {
            e.printStackTrace();
            System.exit(0);
        }
    }
        
    private void initGL() throws Exception {
        
        createWindow();
      
        if (m_filter){
            GL11.glTexParameteri(GL11.GL_TEXTURE_2D,GL11.GL_TEXTURE_MAG_FILTER,GL11.GL_LINEAR); // contre l'aliasage proche
            GL11.glTexParameteri(GL11.GL_TEXTURE_2D,GL11.GL_TEXTURE_MIN_FILTER,GL11.GL_LINEAR); // contre l'aliasage lointain
        }else{
            GL11.glTexParameteri(GL11.GL_TEXTURE_2D,GL11.GL_TEXTURE_MAG_FILTER,GL11.GL_NEAREST); // contre l'aliasage proche
            GL11.glTexParameteri(GL11.GL_TEXTURE_2D,GL11.GL_TEXTURE_MIN_FILTER,GL11.GL_NEAREST); // contre l'aliasage lointain
        }
        
        GL11.glEnable(GL11.GL_TEXTURE_2D); // Enable Texture Mapping
        GL11.glShadeModel(GL11.GL_SMOOTH); // Enable Smooth Shading
        GL11.glClearColor(1.0f, 0.0f, 0.0f, 0.0f); // Black Background
        GL11.glClearDepth(1.0); // Depth Buffer Setup
        GL11.glEnable(GL11.GL_DEPTH_TEST); // Enables Depth Testing
        GL11.glDepthFunc(GL11.GL_LEQUAL); // The Type Of Depth Testing To Do

        GL11.glEnable(GL11.GL_CULL_FACE); // Back face culling 
        
        GL11.glMatrixMode(GL11.GL_PROJECTION); // Select The Projection Matrix
        GL11.glLoadIdentity(); // Reset The Projection Matrix

        // Calculate The Aspect Ratio Of The Window
        GLU.gluPerspective(
          45.0f,
          (float) m_displayMode.getWidth() / (float) m_displayMode.getHeight(),
          0.1f,
          100.0f);

        GL11.glMatrixMode(GL11.GL_MODELVIEW); // Select The Modelview Matrix
        
        GL11.glEnable(GL11.GL_LIGHTING);
        
        LumiereDirectionelle maLumiere = new LumiereDirectionelle();
        maLumiere.allumer();
        
    }

    private void prepareScene(){
        Vecteur3D vecteur0 = new Vecteur3D(0.0f,-20.0f,-80.0f);
        Transformation translation0 = new Translation(this, vecteur0);

        Vecteur3D vecteur11 = new Vecteur3D(-15.0f,8.0f,0.0f);
        Transformation translation11 = new Translation(translation0, vecteur11);        
        RotationAnimee rotation11 = new RotationAnimee(translation11, new Vecteur3D(0.0f,1.0f,0.0f), 90.0f, 5000);
        
        Vecteur3D vecteur12 = new Vecteur3D(25.0f,8.0f,0.0f);
        Transformation translation12 = new Translation(translation0, vecteur12);   
        RotationAnimee rotation12 = new RotationAnimee(translation12, new Vecteur3D(0.0f,1.0f,0.0f), 90.0f, 5000);
        
        Vecteur3D vecteur13 = new Vecteur3D(50.0f,8.0f,0.0f);
        Transformation translation13 = new Translation(translation0, vecteur13);   
        RotationAnimee rotation13 = new RotationAnimee(translation13, new Vecteur3D(0.0f,1.0f,0.0f), 90.0f, 5000);
        
        Vecteur3D vecteur14 = new Vecteur3D(-30.0f,8.0f,0.0f);
        Transformation translation14 = new Translation(translation0, vecteur14);   
        RotationAnimee rotation14 = new RotationAnimee(translation14, new Vecteur3D(0.0f,1.0f,0.0f), 90.0f, 5000);
        
        // CubeTextureParFace cube11 = new CubeTextureParFace(rotation11); 
        
        Bouclier monBouclier = new Bouclier(rotation11);
        
        Epee monEpee = new Epee(rotation12);
        
        Torche maTorche = new Torche(rotation13);
        
        Fleche mafleche = new Fleche(rotation14);
    }
    
    private void createWindow() throws Exception {
        Display.setFullscreen(m_fullscreen);
        DisplayMode d[] = Display.getAvailableDisplayModes();
        for (int i = 0; i < d.length; i++) {
            if (d[i].getWidth() == 1920
                && d[i].getHeight() == 1080
                && d[i].getBitsPerPixel() == 32) {
                m_displayMode = d[i];
                break;
            }
        }
        Display.setDisplayMode(m_displayMode);
        Display.setTitle(m_windowTitle);
        Display.create();
    }

    
    private static void cleanup() {
        Display.destroy();
    }    

    /**
     * M�thode statique permettant de lancer l'application depuis la ligne de commande
     */
    public static void main(String[] argv) {
        String OS = System.getProperty("os.name").toLowerCase();
        String path = "";
        try{
            if(OS.indexOf("win") >= 0){
                path = Monde.class.getResource("../native/windows").getPath();
                path = java.net.URLDecoder.decode(path, "UTF-8");
            }
            if(OS.indexOf("linux") >= 0){
                path = Monde.class.getResource("../native/linux").getPath();
                path = java.net.URLDecoder.decode(path, "UTF-8");                
            }
            if(OS.indexOf("mac") >= 0){
                path = Monde.class.getResource("../native/macosx").getPath();
                path = java.net.URLDecoder.decode(path, "UTF-8");
            }
            System.setProperty("org.lwjgl.librarypath", path);
        }catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

        // il est possible de passer l'argument "fullscreen" lors de l'invocation de la fonction 
        //<b>main()</b> pour que la fen�tre soit affich�e en mode plein �cran
        boolean fullscreen = false;
        if(argv.length>0) {
            if(argv[0].equalsIgnoreCase("fullscreen")) {
                fullscreen = true;
            }
        }
        
        Monde monMonde = new Monde();
        monMonde.start(fullscreen);
    }
    
}


