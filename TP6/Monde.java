
package TP6;

import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;
import org.lwjgl.opengl.GL11;

import org.lwjgl.util.glu.GLU;

import org.lwjgl.input.Keyboard;

import org.lwjgl.BufferUtils;
import java.nio.FloatBuffer;

import TP4.*;

import java.io.*;

/**
 * La classe Monde est le noeud primordial à l'origine du graphe
 * de scène. Elle prend en charge les interactions ainsi que l'initialisation
 * du contexte OpenGL
 *
 * @author Alexis Heloir
 * @version 2019/03/21
 */
public class Monde extends Noeud
{

    private boolean m_done = false; // Est ce que l'application doit se terminer?
    private boolean m_fullscreen = false; // Est-ce que l'application doit être plein écran?
    private final String m_windowTitle = "OpenGL et Graphe de scène"; // Titre de l'application
    private boolean m_f1 = false; // A t-on appuyé sur la touche F1?
    private DisplayMode m_displayMode; // propriétés de la fenêtre d'affichage

    private boolean m_filter = false; // Est-ce  que l'on applique le mipmapping de texture 

    /**
     * Le constructuer de la classe Monde ne prend pas de parmètre : la classe Monde 
     * n'a pas de parent car son instance (souvent unique) est à l'origine du graphe de scène.
     */
    public Monde()
    {
        super(null);
    }

    /**
     * La méthode affiche vides les buffers du contexte OpenGL puis appelle de manière 
     * récursive la méthode affiche pour l'ensemble des noeuds enfants. Le graphe de scene est ainsi parcouru.
     */
    public void affiche(){
        GL11.glClear(GL11.GL_COLOR_BUFFER_BIT | GL11.GL_DEPTH_BUFFER_BIT);          // Clear The Screen And The Depth Buffer

        for (int i=0; i<m_enfants.size(); i++ )
        {
            m_enfants.get(i).affiche();
        }        
    }

    /**
     * Méthode responsable de la gestion des interactions avec l'utilisateur --
     * elle gère principalement les interruptions clavier
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
     *  Appelé par la méthode interactionManagement() en charge de capturer les
     *  évènments clavier. Cette méthode gère l'attribut sanctionnant le mode plein
     *  écran
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
            while (!m_done) {
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
        GL11.glClearColor(0.0f, 0.0f, 0.0f, 0.0f); // Black Background
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

        Vecteur3D monVecteur = new Vecteur3D(0.0f,0.0f,-25.0f);
        
        
        
        
        
        
        
        
        
        
        


        // à partir d'ici, on construit le graphe de scène 
        Transformation maTranslation = new Translation(this, monVecteur);
        
        Vecteur3D decaleGauche = new Vecteur3D(1.0f,0.0f,0.0f);
        Transformation aGauche = new Translation(maTranslation, decaleGauche);
        CubeTexture monCubeTex1= new CubeTexture(aGauche,"/TP6/res/bob1.png");
        
        Vecteur3D decaleGauche2 = new Vecteur3D(3.0f,0.0f,0.0f);
        Transformation aGauche2 = new Translation(maTranslation, decaleGauche2);
        CubeTexture monCubeTex2 = new CubeTexture(aGauche2,"/TP6/res/bob1.png");
        
        Vecteur3D decaleDroite = new Vecteur3D(-1.0f,0.0f,0.0f);
        Transformation aDroite = new Translation(maTranslation, decaleDroite);
        CubeTexture monCubeTex3 = new CubeTexture(aDroite,"/TP6/res/bob1.png");
        
        Vecteur3D decaleDroite2 = new Vecteur3D(-3.0f,0.0f,0.0f);
        Transformation aDroite2 = new Translation(maTranslation, decaleDroite2);
        CubeTexture monCubeTex4 = new CubeTexture(aDroite2,"/TP6/res/bob1.png");
        
        Vecteur3D decaleDroite3 = new Vecteur3D(-5.0f,0.0f,0.0f);
        Transformation aDroite3 = new Translation(maTranslation, decaleDroite3);
        CubeTexture monCubeTex5 = new CubeTexture(aDroite3,"/TP6/res/bob1.png");
        
        Vecteur3D decaleHaut = new Vecteur3D(-1.0f,2.0f,0.0f);
        Transformation haut = new Translation(maTranslation, decaleHaut);
        CubeTexture monCubeTex6 = new CubeTexture(haut,"/TP6/res/bob1.png");
        
        Vecteur3D decaleHaut2 = new Vecteur3D(-3.0f,2.0f,0.0f);
        Transformation haut2 = new Translation(maTranslation, decaleHaut2);
        CubeTexture monTex7 = new CubeTexture(haut2,"/TP6/res/bob1.png");
        
        Vecteur3D decaleHaut3 = new Vecteur3D(1.0f,2.0f,0.0f);
        Transformation haut3 = new Translation(maTranslation, decaleHaut3);
        CubeTexture monCubeTex8 = new CubeTexture(haut3,"/TP6/res/bob1.png");
        
        Vecteur3D decaleHautt = new Vecteur3D(-1.0f,4.0f,0.0f);
        Transformation hautt = new Translation(maTranslation, decaleHautt);
        CubeTexture monCubeTex9 = new CubeTexture(hautt,"/TP6/res/bob1.png");
        
        Vecteur3D decaleGauche3 = new Vecteur3D(1.0f,-2.0f,0.0f);
        Transformation aGauche3 = new Translation(maTranslation, decaleGauche3);
        CubeTexture monCubeTex10= new CubeTexture(aGauche3,"/TP6/res/bob1.png");
        
        Vecteur3D decaleGauche4 = new Vecteur3D(-1.0f,-2.0f,0.0f);
        Transformation aGauche4 = new Translation(maTranslation, decaleGauche4);
        CubeTexture monCubeTex11= new CubeTexture(aGauche4,"/TP6/res/bob1.png");
        
        Vecteur3D decaleGauche5 = new Vecteur3D(-3.0f,-2.0f,0.0f);
        Transformation aGauche5 = new Translation(maTranslation, decaleGauche5);
        CubeTexture monCubeTex12= new CubeTexture(aGauche5,"/TP6/res/bob1.png");
        
        Vecteur3D decaleGauche6 = new Vecteur3D(-1.0f,-4.0f,0.0f);
        Transformation aGauche6 = new Translation(maTranslation, decaleGauche6);
        CubeTexture monCubeTex13= new CubeTexture(aGauche6,"/TP6/res/bob1.png");
        
        // Vecteur3D decaleHauttt = new Vecteur3D(-1.0f,6.0f,0.0f);
        // Vecteur3D echelle9 = new Vecteur3D(0.5f,0.5f,0.5f);
        // Transformation hauttt = new Translation(maTranslation, decaleHauttt);
        // Echelle echelle9 = new Echelle(hauttt, vecteurEchelle);
        // CubeTexture monCubeLine9 = new CubeTexture(echelle9,"/TP6/res/bob1.png");
        
        // int j=5;
        // for (int i = 1; i <= 3; i++) {
            // if (j>0)
            // {
                // Transformation aDroite = new Translation(maTranslation, decaleDroite);
                // CubeTexture monCubeTex = new CubeTexture(aGauche,"/TP6/res/bob2.png");
                // j = j-2;
            // } 
        // }

        
    }
    private void createWindow() throws Exception {
        Display.setFullscreen(m_fullscreen);
        DisplayMode d[] = Display.getAvailableDisplayModes();
        for (int i = 0; i < d.length; i++) {
            if (d[i].getWidth() == 640
            && d[i].getHeight() == 480
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
     * Méthode statique permettant de lancer l'application depuis la ligne de commande
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
        //<b>main()</b> pour que la fenètre soit affichée en mode plein écran
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

