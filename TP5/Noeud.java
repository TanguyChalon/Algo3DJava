<<<<<<< HEAD
<<<<<<< HEAD
package TP5;


/**
 * Abstract class Noeud - write a description of the class here
 *
 * @author (your name here)
 * @version (version number or date here)
 */
public abstract class Noeud
{
    // instance variables - replace the example below with your own
    private int x;

    /**
     * An example of a method - replace this comment with your own
     *
     * @param  y  a sample parameter for a method
     * @return    the sum of x and y
     */
    public int sampleMethod(int y)
    {
        // put your code here
        return x + y;
    }
}
=======
package TP5;

import java.util.Vector; 

/**
 * La classe noeud est une classe abstraite en amont de la hi�rarchie 
 * de classes de notre graphe de sc�ne. 
 * Sa fonction principale est de porter la structure d'arbre du graphe de sc�ne. 
 * Un noeud peut avoir plusieurs enfants et un seul parent. 
 * Seul le noeud d'origine de la sc�ne n'a pas de parent.
 *
 * @author Tanguy CHALON
 * @version 20/03/2019
 */
public abstract class Noeud
{
    // Un noeud peut avoir plusieurs enfants 
    protected Vector<Noeud> m_enfants; 

    // Un noeud � un seul parent

    protected Noeud m_parent; 

    /** 
     * Le constructeur par d�faut de la classe noeud prend le noeud parent en param�tre 
     */

    public Noeud(Noeud _parent)
    {
        m_parent = _parent;
        _parent.ajouteEnfant(this); //Le parent m'ajoute � sa liste d'enfants 
    }
/**
 * Ajoute le noeud _enfant pass� en param�tre� la liste d'enfant en attribut 
 * @param _enfant le noeud enfant � rajouter � la liste d'enfants. 
 */
    public void ajouteEnfant(Noeud _enfant){
    m_enfants.add(_enfant);
    }
    /** 
     * M�thode abstraite en charge d'appeler les instructions openGL permettant
     * d'afficherle noeud (m�me is on ne sais pas encore ce qu'il repr�sente) 
     */

    public abstract void afficher();
}
>>>>>>> 7555426deb341c6f0c62d026a588f20791e499cd
=======
package TP5;

import java.util.Vector; 

/**
 * La classe noeud est une classe abstraite en amont de la hi�rarchie 
 * de classes de notre graphe de sc�ne. 
 * Sa fonction principale est de porter la structure d'arbre du graphe de sc�ne. 
 * Un noeud peut avoir plusieurs enfants et un seul parent. 
 * Seul le noeud d'origine de la sc�ne n'a pas de parent.
 *
 * @author Tanguy CHALON
 * @version 20/03/2019
 */
public abstract class Noeud
{
    // Un noeud peut avoir plusieurs enfants 
    protected Vector<Noeud> m_enfants; 

    // Un noeud � un seul parent

    protected Noeud m_parent; 

    /** 
     * Le constructeur par d�faut de la classe noeud prend le noeud parent en param�tre 
     */

    public Noeud(Noeud _parent)
    {
        m_parent = _parent;
        _parent.ajouteEnfant(this); //Le parent m'ajoute � sa liste d'enfants 
    }
/**
 * Ajoute le noeud _enfant pass� en param�tre� la liste d'enfant en attribut 
 * @param _enfant le noeud enfant � rajouter � la liste d'enfants. 
 */
    public void ajouteEnfant(Noeud _enfant){
    m_enfants.add(_enfant);
    }
    /** 
     * M�thode abstraite en charge d'appeler les instructions openGL permettant
     * d'afficherle noeud (m�me is on ne sais pas encore ce qu'il repr�sente) 
     */

    public abstract void afficher();
}
>>>>>>> eb1f081e178a1f66f94cf8bd3a78b4c9839f28b8
