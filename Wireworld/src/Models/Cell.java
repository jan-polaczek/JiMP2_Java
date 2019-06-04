/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

/**
 *
 * @author 01133123
 */
public class Cell {
    
    private char color;
    /*
    Kolory oznaczają stany komórki:
    b - czarny martwa komórka w GoL
    w - biały żywa komórka w GoL
    y - żółty przewodnik w Ww
    l - niebieski głowa elektronu w Ww
    r - czerwony głowa elektronu w Ww
    */
    
    public Cell(char color)
    {
        this.color = color;
    }
    
    public char getColor()
    {
        return this.color;
    }
    public void changeState(){
        switch (this.color) {
            case 'w':
                this.color = 'b';
                break;
            case 'b':
                this.color = 'w';
                break;
            case 'y':
                this.color = 'l';
                break;
            case 'l':
                this.color = 'r';
                break;
            case 'r':
                this.color = 'y';
                break;
            default:
                break;
        }
    }
}
