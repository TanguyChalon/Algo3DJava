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
    }

    /** 
     * M�thode abstraite en charge d'appeler les instructions openGL permettant
     * d'afficherle noeud (m�me is on ne sais pas encore ce qu'il repr�sente) 
     */

    public abstract void afficher();
}
