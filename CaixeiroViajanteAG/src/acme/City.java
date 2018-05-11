/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package acme;

/**
 *
 * @author Leandro
 */
public class City {
 //Posição X da cidade no mapa
    private int _x;
    //Posição Y da cidade no mapa
    private int _y;
    //Nome da cidade (serve apenas para identificar a cidade, não é realmente útil para a lógica do algortimo genético)
    private String _name;
    
    //Construtor da classe
    public City(String name, int x, int y){
    	_name = name;
        _x = x;
        _y = y;
    }
    
    //Alguns getters uteis
    public int getX(){
        return _x;
    }
    
    public int getY(){
        return _y;
    }
    public String getName(){
    	return _name;
    }
    
    //Cálcula a distância que separa esta cidade de outra cidade passada como argumento
    public double distanceTo(City city){
        int xDif = Math.abs(this._x - city._x);
        int yDif = Math.abs(this._y - city._y);
        double distance = Math.sqrt(Math.pow(xDif, 2) + Math.pow(yDif, 2));
        return distance;
    }
    
    //Método opticional para representar a cidade em forma de string
    @Override
    public String toString(){
        return ""+_name+"("+_x+","+_y+")";
    }
}
