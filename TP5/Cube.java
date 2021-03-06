package TP5;

import org.lwjgl.opengl.GL11;

/**
 * Write a description of class Cube here.
 *
 * @author Tanguy CHALON
 * @version 20/03/2019
 */
public class Cube extends Objet
{
    public Cube(Noeud _parent)
    {
        super(_parent);
    }

    /**
     * Cette m�thode utilise une suite d'instructions OpenGL permettant d'affihcer un cube. 
     * Vous trouverez ces instructions dans la classe OpenGL en vrac du package TP2. 
     */


    public void dessine(){
        
        GL11.glBegin(GL11.GL_LINES);

        GL11.glVertex3f(-1.0f, -1.0f, 1.0f); // Bottom Left Of The Texture and Quad
        GL11.glVertex3f(1.0f, -1.0f, 1.0f); // Bottom Right Of The Texture and Quad
        GL11.glVertex3f(1.0f, -1.0f, 1.0f); // Bottom Right Of The Texture and Quad
        GL11.glVertex3f(1.0f, 1.0f, 1.0f); // Top Right Of The Texture and Quad        
        GL11.glVertex3f(1.0f, 1.0f, 1.0f); // Top Right Of The Texture and Quad
        GL11.glVertex3f(-1.0f, 1.0f, 1.0f); // Top Left Of The Texture and Quad
        GL11.glVertex3f(-1.0f, 1.0f, 1.0f); // Top Left Of The Texture and Quad
        GL11.glVertex3f(-1.0f, -1.0f, 1.0f); // Bottom Left Of The Texture and Quad        
        
        // Back Face
        GL11.glVertex3f(-1.0f, -1.0f, -1.0f); // Bottom Right Of The Texture and Quad
        GL11.glVertex3f(-1.0f, 1.0f, -1.0f); // Top Right Of The Texture and Quad
        GL11.glVertex3f(-1.0f, 1.0f, -1.0f); // Top Right Of The Texture and Quad
        GL11.glVertex3f(1.0f, 1.0f, -1.0f); // Top Left Of The Texture and Quad
        GL11.glVertex3f(1.0f, 1.0f, -1.0f); // Top Left Of The Texture and Quad
        GL11.glVertex3f(1.0f, -1.0f, -1.0f); // Bottom Left Of The Texture and Quad
        GL11.glVertex3f(1.0f, -1.0f, -1.0f); // Bottom Left Of The Texture and Quad
        GL11.glVertex3f(-1.0f, -1.0f, -1.0f); // Bottom Right Of The Texture and Quad
        // Top Face      
        GL11.glVertex3f(-1.0f, 1.0f, -1.0f); // Top Left Of The Texture and Quad
        GL11.glVertex3f(-1.0f, 1.0f, 1.0f); // Bottom Left Of The Texture and Quad
        GL11.glVertex3f(-1.0f, 1.0f, 1.0f); // Bottom Left Of The Texture and Quad
        GL11.glVertex3f(1.0f, 1.0f, 1.0f); // Bottom Right Of The Texture and Quad
        GL11.glVertex3f(1.0f, 1.0f, 1.0f); // Bottom Right Of The Texture and Quad
        GL11.glVertex3f(1.0f, 1.0f, -1.0f); // Top Right Of The Texture and Quad
        GL11.glVertex3f(1.0f, 1.0f, -1.0f); // Top Right Of The Texture and Quad
        GL11.glVertex3f(-1.0f, 1.0f, -1.0f); // Top Left Of The Texture and Quad
        // Bottom Face
        GL11.glVertex3f(-1.0f, -1.0f, -1.0f); // Top Right Of The Texture and Quad
        GL11.glVertex3f(1.0f, -1.0f, -1.0f); // Top Left Of The Texture and Quad
        GL11.glVertex3f(1.0f, -1.0f, -1.0f); // Top Left Of The Texture and Quad
        GL11.glVertex3f(1.0f, -1.0f, 1.0f); // Bottom Left Of The Texture and Quad
        GL11.glVertex3f(1.0f, -1.0f, 1.0f); // Bottom Left Of The Texture and Quad
        GL11.glVertex3f(-1.0f, -1.0f, 1.0f); // Bottom Right Of The Texture and Quad
        GL11.glVertex3f(-1.0f, -1.0f, 1.0f); // Bottom Right Of The Texture and Quad
        GL11.glVertex3f(-1.0f, -1.0f, -1.0f); // Top Right Of The Texture and Quad
        // Right face      
        GL11.glVertex3f(1.0f, -1.0f, -1.0f); // Bottom Right Of The Texture and Quad
        GL11.glVertex3f(1.0f, 1.0f, -1.0f); // Top Right Of The Texture and Quad
        GL11.glVertex3f(1.0f, 1.0f, -1.0f); // Top Right Of The Texture and Quad
        GL11.glVertex3f(1.0f, 1.0f, 1.0f); // Top Left Of The Texture and Quad
        GL11.glVertex3f(1.0f, 1.0f, 1.0f); // Top Left Of The Texture and Quad
        GL11.glVertex3f(1.0f, -1.0f, 1.0f); // Bottom Left Of The Texture and Quad
        GL11.glVertex3f(1.0f, -1.0f, 1.0f); // Bottom Left Of The Texture and Quad
        GL11.glVertex3f(1.0f, -1.0f, -1.0f); // Bottom Right Of The Texture and Quad
        // Left Face
        GL11.glVertex3f(-1.0f, -1.0f, -1.0f); // Bottom Left Of The Texture and Quad
        GL11.glVertex3f(-1.0f, -1.0f, 1.0f); // Bottom Right Of The Texture and Quad
        GL11.glVertex3f(-1.0f, -1.0f, 1.0f); // Bottom Right Of The Texture and Quad
        GL11.glVertex3f(-1.0f, 1.0f, 1.0f); // Top Right Of The Texture and Quad
        GL11.glVertex3f(-1.0f, 1.0f, 1.0f); // Top Right Of The Texture and Quad
        GL11.glVertex3f(-1.0f, 1.0f, -1.0f); // Top Left Of The Texture and Quad
        GL11.glVertex3f(-1.0f, 1.0f, -1.0f); // Top Left Of The Texture and Quad
        GL11.glVertex3f(-1.0f, -1.0f, -1.0f); // Bottom Left Of The Texture and Quad
        GL11.glEnd();
        
    }
}
