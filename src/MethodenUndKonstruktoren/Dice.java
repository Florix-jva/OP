package MethodenUndKonstruktoren;

public class Dice {
    /*
    Goal:   creates random dice numbers
    Return: random numbers from 1 to 6 as integers
    */
    int throwDice(){
        return (int) (6 * Math.random() + 1);
    }
    /*
    Goal:   Save/print last thrown number
    Return: last number as int
     */
    int getLastValue(){
        return 0;
    }
}
