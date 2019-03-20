package TP5;

import java.util.Vector; 

/**
 * La classe noeud est une classe abstraite en amont de la hiérarchie 
 * de classes de notre graphe de scène. 
 * Sa fonction principale est de porter la structure d'arbre du graphe de scène. 
 * Un noeud peut avoir plusieurs enfants et un seul parent. 
 * Seul le noeud d'origine de la scène n'a pas de parent.
 *
 * @author Tanguy CHALON
 * @version 20/03/2019
 */
public abstract class Noeud
{
    // Un noeud peut avoir plusieurs enfants 
    protected Vector<Noeud> m_enfants; 

    // Un noeud à un seul parent

    protected Noeud m_parent; 

    /** 
     * Le constructeur par défaut de la classe noeud prend le noeud parent en paramètre 
     */

    public Noeud(Noeud _parent)
    {
        m_parent = _parent;
    }

    /** 
     * Méthode abstraite en charge d'appeler les instructions openGL permettant
     * d'afficherle noeud (même is on ne sais pas encore ce qu'il représente) 
     */

    public abstract void afficher();
}
