package TP3;

/**
 * Cette classe représente un vecteur à 3 dimensions 
 *
 * @author (Tanguy CHALON)
 * @version (0.0.0.1 alpha)
 */
public class Vecteur3D
{
    // composante x,y et z 
    float m_x,m_y,m_z;

    /**
     * Constructeur par défaut de la classe vecteur 3D
     */
    public Vecteur3D()
    {
        //Inistialisation des composantes à 0
        m_x = 0.0f;
        m_y = 0.0f;
        m_z = 0.0f; 
    }

    /**
     * Constructeur d'un vecteur 3D avec des valeurs prédéfinies
     */
    public Vecteur3D(float _x, float _y, float _z)
    {
        //initialisation des composantes en fonction des paramètres 
        m_x = _x;
        m_y = _y;
        m_z = _z; 
    }
    //Getteur de la composante X
    public float getX(){
        return m_x;
    }
    //Getteur de la composante Y 
    public float getY(){
        return m_y;
    }
    //Getteur de la composante Z
    public float getZ(){
        return m_z;
    }

}