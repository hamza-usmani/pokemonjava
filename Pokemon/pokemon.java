//Hamza Usmani

import javax.swing.*;
import java.applet.*;
import java.applet.Applet;
import java.awt.*;
import java.awt.event.*;

public class pokemon extends Applet implements MouseListener
{ //Global variables to be used throughout the game declared below
    int screen, choose, info, info2, info3, info4, info5;
    Image title, title2, instruct, a1, a2, a3, a4, a5, b1, b2, c1, d1, d2, d3, d4, d5, d6, d7, d8, d9, d10, d11, p1, down, up, up2, right, left, bulbdefault, bulb, bulb2, squirt, squirtdefault, squirt2, charmdefault, charm, charm2, charizard, lugia, charmevo, squirtevo, bulbevo, giratina, mewtwo;
    int px = 15, py = 10, aihp = 101, yourhp = 101, potion = 2, arrow = 1, trainer1 = 1, evolve = 0, growup = 0, found = 1, fight = 1, mew = 1;
    String yourpoke;
    Graphics g, g1, g2, g3, g4, g5;
    AudioClip song;
    //all the map arrays are declared below
    //The maps in this game are:
    //1. Intro Forest Scene
    //2. Professor Oak's Lab
    //3. Second Forest Map
    //4. Battle VS Zubat
    //5. Long Road Map
    //6. Final Buildings Map
    //7. Buildings 1,2,3 and 4
    //8,9,10,11. Battles VS Charizard, Lugia, Giratina, and Mewtwo
    //12. Thanks for playing screen

    int map1[] [] = {  // First map (forest)
     {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, },
     {1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, },
     {1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, },
     {1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, },
     {1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, },
     {1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, },
     {1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, },
     {1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, },
     {1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, },
     {1, 1, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, },
     {1, 1, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, },
     {1, 1, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, },
     {1, 1, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, },
     {1, 1, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, },
     {1, 1, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, },
     {1, 1, 0, 1, 0, 0, 1, 1, 0, 0, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, },
     {1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, },
     {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, }

 };

    int map2[] [] = {  //(Second map: Oak's House)
     {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, },
     {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, },
     {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, },
     {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, },
     {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, },
     {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, },
     {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, },
     {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, },
     {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, },
     {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, },
     {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, },
     {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, },
     {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, },
     {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, },
     {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, },
     {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, },
     {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, },
     {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, }
 };

    int map3[] [] = {  //(Third Map: Leaving Oak's house, back outside)
     {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, },
     {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, },
     {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, },
     {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, },
     {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, },
     {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, },
     {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, },
     {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, },
     {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, },
     {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, },
     {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, },
     {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, },
     {1, 0, 0, 1, 0, 0, 1, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, },
     {1, 0, 0, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, },
     {1, 0, 0, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, },
     {1, 0, 0, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, },
     {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, },
     {1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, }
 };


    int map4[] [] = {  //(Second Forest Map)
     {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, },
     {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, },
     {1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, },
     {1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, },
     {1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 1, },
     {1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 0, 0, 1, },
     {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 1, 0, 1, },
     {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, },
     {1, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, },
     {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, },
     {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, },
     {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, },
     {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, },
     {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, },
     {1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, },
     {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, },
     {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, },
     {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, }

 };

    int map5[] [] = {  //(Long Road Map)
     {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, },
     {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, },
     {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, },
     {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, },
     {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, },
     {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, },
     {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, },
     {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, },
     {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 1, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, },
     {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, },
     {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, },
     {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, },
     {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, },
     {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, },
     {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, },
     {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, },
     {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, },
     {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, }

 };

    int map6[] [] = {  //(Final Main Map with 4 buildings)
     {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, },
     {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, },
     {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, },
     {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, },
     {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, },
     {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 0, 0, 1, },
     {1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, },
     {1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, },
     {1, 1, 0, 0, 1, 1, 1, 1, 1, 1, 0, 1, 0, 0, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, },
     {1, 1, 1, 0, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 1, 1, 1, 1, 0, 0, 0, 1, 1, 0, 0, 0, 0, 1, },
     {1, 1, 1, 0, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 1, 1, 1, 1, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, },
     {1, 1, 1, 0, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, },
     {1, 1, 1, 0, 1, 1, 1, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, },
     {1, 1, 1, 0, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, },
     {1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, },
     {1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, },
     {1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, },
     {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, }

 };

    int map7[] [] = {  //(Bottom right building)
     {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, },
     {1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, },
     {1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 0, 0, 1, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, },
     {1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, },
     {1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, },
     {1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, },
     {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, },
     {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, },
     {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, },
     {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, },
     {1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, },
     {1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, },
     {1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, },
     {1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, },
     {1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, },
     {1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, },
     {1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, },
     {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, }
 };


    int map8[] [] = {  //(Top Right Building)
     {1, 1, 1, 1, 1, 1, 1, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, },
     {1, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, },
     {1, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, },
     {1, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, },
     {1, 1, 1, 1, 1, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 0, 0, 1, 1, 0, 1, },
     {1, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0, 1, 1, 0, 1, },
     {1, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0, 1, 1, 0, 1, },
     {1, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0, 1, 1, 0, 1, },
     {1, 1, 0, 1, 1, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0, 1, 1, 0, 0, },
     {1, 0, 0, 0, 1, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0, 1, 1, 0, 1, },
     {1, 1, 0, 1, 1, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 0, 0, 1, 1, 0, 1, },
     {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 1, },
     {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, },
     {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, },
     {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, },
     {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, },
     {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, },
     {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, }
 };

    int map9[] [] = {  // Top Left Building
     {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, },
     {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, },
     {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 1, },
     {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 1, 1, 1, },
     {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 1, 1, 1, },
     {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 1, },
     {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, },
     {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, },
     {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, },
     {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, },
     {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, },
     {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 1, },
     {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 1, },
     {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 1, },
     {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 1, },
     {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, },
     {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, },
     {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, }
 };


    int map10[] [] = {  //Bottom Left Building
     {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, },
     {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, },
     {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 0, 0, 0, 0, 1, },
     {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 0, 0, 0, 0, 1, },
     {1, 1, 1, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 0, 0, 0, 0, 1, },
     {1, 0, 1, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, },
     {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 0, 0, 0, 1, },
     {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 0, 0, 0, 1, },
     {1, 0, 1, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 0, 0, 0, 0, 1, },
     {1, 0, 1, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 0, 0, 0, 0, 1, },
     {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 0, 0, 0, 1, },
     {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, },
     {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, },
     {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, },
     {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, },
     {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, },
     {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, },
     {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, }
 };


    public void init ()

    {
 resize (690, 390);
 setBackground (Color.black);

 song = getAudioClip (getDocumentBase (), "sound.wav");
 song.loop (); // background music

 screen = 0;
 //The following is actually defining what each global image is:
 title = getImage (getDocumentBase (), "title.jpg");
 instruct = getImage (getDocumentBase (), "instruct.jpg");

 //first map (with Oak's house, starter selection)
 a1 = getImage (getDocumentBase (), "1.jpg");
 a2 = getImage (getDocumentBase (), "1-1.jpg");
 a3 = getImage (getDocumentBase (), "1-2.jpg");
 a4 = getImage (getDocumentBase (), "1-3.jpg");
 a5 = getImage (getDocumentBase (), "1-4.jpg");

 //second map (also, Pokemon gifs declared below)
 b1 = getImage (getDocumentBase (), "2.jpg");
 b2 = getImage (getDocumentBase (), "2-1.jpg");
 charm = getImage (getDocumentBase (), "charm.gif");
 charm2 = getImage (getDocumentBase (), "charm2.gif");
 charmdefault = charm;
 squirt = getImage (getDocumentBase (), "squirt.gif");
 squirt2 = getImage (getDocumentBase (), "squirt2.gif");
 squirtdefault = squirt;
 bulb = getImage (getDocumentBase (), "bulb.gif");
 bulb2 = getImage (getDocumentBase (), "bulb2.gif");
 bulbdefault = bulb;

 //third map (long road)
 c1 = getImage (getDocumentBase (), "3.jpg");

 //fourth map (final map- includes maps of all 4 buildings and battles)
 d1 = getImage (getDocumentBase (), "4.jpg");
 d2 = getImage (getDocumentBase (), "arrows.gif");
 d3 = getImage (getDocumentBase (), "4-1.jpg");
 d4 = getImage (getDocumentBase (), "4-2.jpg");
 d5 = getImage (getDocumentBase (), "4-3.jpg");
 d6 = getImage (getDocumentBase (), "4-4.jpg");
 d7 = getImage (getDocumentBase (), "4-5.jpg");
 d8 = getImage (getDocumentBase (), "4-6.jpg");
 d9 = getImage (getDocumentBase (), "4-7.jpg");
 d10 = getImage (getDocumentBase (), "4-8.jpg");
 d11 = getImage (getDocumentBase (), "end.jpg");
 // enemy gifs, as well as evolve screens below
 charizard = getImage (getDocumentBase (), "charizard.png");
 lugia = getImage (getDocumentBase (), "lugia.png");
 giratina = getImage (getDocumentBase (), "giratina.png");
 charmevo = getImage (getDocumentBase (), "charevo.jpg");
 squirtevo = getImage (getDocumentBase (), "squirtevo.jpg");
 bulbevo = getImage (getDocumentBase (), "bulbevo.jpg");

 //ash icons
 p1 = getImage (getDocumentBase (), "p1.gif");
 down = getImage (getDocumentBase (), "down.gif");
 right = getImage (getDocumentBase (), "right.gif");
 left = getImage (getDocumentBase (), "left.gif");
 up = getImage (getDocumentBase (), "up.gif");
 up2 = getImage (getDocumentBase (), "up2.gif");


 //graphics
 addMouseListener (this);
 g = getGraphics ();
 g1 = getGraphics ();
 g2 = getGraphics ();
 g3 = getGraphics ();
 g4 = getGraphics ();
 g5 = getGraphics ();
    }


    protected static ImageIcon createImageIcon (String path)
    {
 //This code is for showing pictures in a dialog box
 java.net.URL imgURL = pokemon.class.getResource (path);
 if (imgURL != null)
 {
     return new ImageIcon (imgURL);
 }
 else
 {
     System.err.println ("Couldn't find file: " + path);
     return null;
 }
    }


    public void mouseClicked (MouseEvent e)
    {
    }


    public void mouseExited (MouseEvent e)
    {
    }


    public void mouseReleased (MouseEvent e)
    {
    }


    public void mouseEntered (MouseEvent e)
    {
    }


    public void dpad (int x, int y, int array[] [])  // the method for the dpad to be functional (in moving the character)
    {
 if (x > 615 && x < 643 && y > 81 && y < 110)
 {
     if (array [py - 1] [px] == 0)
     {
  p1 = up;
  py--;
     }
 }

 else if (x > 643 && x < 666 && y > 110 && y < 138)
 {
     if (array [py] [px + 1] == 0)
     {
  p1 = right;
  px++;
     }
 }


 else if (x > 614 && x < 643 && y > 140 && y < 167)
 {
     if (array [py + 1] [px] == 0)
     {
  p1 = down;
  py++;
     }
 }


 else if (x > 587 && x < 616 && y > 110 && y < 138)
 {
     if (array [py] [px - 1] == 0)
     {
  p1 = left;
  px--;
     }
 }
    }


    public void mousePressed (MouseEvent e)  //mousepressed method, where most of the code is written
    {
 //get the x and y co-ordinates of the mouse
 int x = e.getX ();
 int y = e.getY ();

 //TITLE Screen
 if (screen == 0)
 {
     resize (690, 390);
     if (x > 345 && y > 319 && x < 416 && y < 344)
  screen = 2;

     if (x > 201 && y > 319 && x < 295 && y < 342)
  screen = 1;

 }

 // Instructions
 if (screen == 1)
     if (x > 77 && y > 184 && x < 139 && y < 261)
  screen = 0;


 //FIRST LEVEL- FOREST

 if (screen == 2)
 {
     dpad (x, y, map1);

     if (px == 17 && py == 11 && x > 580 && y > 225 && x < 678 && y < 262)
     {
  JOptionPane.showMessageDialog (null, "Hello Trainer\n \n" //talk to boy
   + "Please visit Professor Oak's home in  \n"
   + "the bottom left section of the screen. \n"
   + "Once you do so, you can continue past that clearing at the top. \n \n"
   + "Instructions will be provided at the top of the screen\nMake sure you explore maps to find potions!\nYou have started off with 2 Potions", "Welcome Pokemon Trainer", JOptionPane.INFORMATION_MESSAGE);
     }

     if (px == 9 && (py == 15 || py == 16) && x > 580 && y > 225 && x < 678 && y < 262) // going in Prof. Oak's house
     {
  screen = 3;
     }
 }


 //PROF OAK'S HOME (inside)
 if (screen == 3)

     {
  dpad (x, y, map2);

  if (((px == 10 && py == 4) || (px == 11 && py == 3)) && x > 580 && y > 225 && x < 678 && y < 262)
  {
      JOptionPane.showMessageDialog (null, "Welcome Trainer\n \n" //talk to oak
       + "I am Professor Oak! \n"
       + "I will help you to begin your quest, by allowing you to choose 1 Pokemon \n"
       + "Please go stand on the red mat, and press 'Interact'.", "It is-a me! Mario- I mean, Professor Oak.", JOptionPane.INFORMATION_MESSAGE);
  }

  if ((px == 26 || px == 25) && py == 7 && x > 580 && y > 225 && x < 678 && y < 262) // standing on red mat
  {
      screen = 4;
  }

  if (px == 11 && py == 14 && found == 1) // a random potion lying around
  {
      JOptionPane.showMessageDialog (null, "You found 1 Potion!", "A Potion! Nice!", JOptionPane.WARNING_MESSAGE);
      potion++;
      found = 0;
  }

     }


 if (screen == 4) //choosing your starter
 {

     if (x > 415 && y > 65 && x < 565 && y < 364)
     {
  choose = 1;
  yourpoke = "Charmander";
     }

     if (x > 226 && y > 65 && x < 399 && y < 364)
     {
  choose = 2;
  yourpoke = "Bulbasaur";
     }

     if (x > 59 && y > 65 && x < 210 && y < 364)
     {
  choose = 3;
  yourpoke = "Squirtle";
     }

     if (choose == 1 || choose == 2 || choose == 3) //leaving oaks house
     {
  dpad (x, y, map3);

  if ((py == 17 || py == 16) && px > 7 && px < 11)
  {
      choose = 4; //go to next map
  }
     }

     if (choose == 4) // Second (forest) map
     {
  dpad (x, y, map1);
  if (px > 13 && px < 19 && py == 1)
  {
      screen = 5; // go to forest map (with boy & his Zubat)
      px = 15;
      py = 17;
  }
     }

 }


 if (screen == 5) //second level- forest map
 {
     dpad (x, y, map4);

     if (px > 23 && px < 27 && py > 4 && py < 9 && x > 580 && y > 225 && x < 678 && y < 262) // fighting the trainer and his Zubat
     {
  JOptionPane.showMessageDialog (null, "My Zubat is a beast! Don't believe me just watch!", "Fight Me!",
   JOptionPane.ERROR_MESSAGE);

  screen = 6;
     }

     if (((px == 5) || (px == 6) && py == 9) && x > 580 && y > 225 && x < 678 && y < 262) // reading the sign on the left side of the map
     {
  JOptionPane.showMessageDialog (null, "The sign reads:\nReaching Challenge Town.\nYes, it is actually called Challenge Town", "A random sign",
   JOptionPane.INFORMATION_MESSAGE);
     }
 }


 if (screen == 6) //first battle screen- VS Zubat
 {

     info = 0;

     if ((x > 345 && y > 283 && x < 411 && y < 304) || (x > 461 && y > 282 && x < 548 && y < 303) || (x > 345 && y > 321 && x < 433 && y < 340)) // pressing the fighting buttons
     {
  info = (int) (Math.random () * 3 + 1); //the fighting, and how effective it is depending on if info= 1,2 or 3

     }
 }

 if (screen == 7) // after you beat the boy & his Zubat
 {
     dpad (x, y, map4);
     info = 5; //means you can now move on- you MUST beat the boy to move on

     if (px > 18 && px < 25 && py == 1)
     {
  screen = 8; // move on to long road map
  px = 14;
  py = 16;
     }
 }

 if (screen == 8) //Third map- long road
 {
     dpad (x, y, map5);
     if (px > 11 && px < 17 && py == 1)
     {
  screen = 9; // final main map with all 4 buildings
  px = 16;
  py = 17;
     }
 }

 if (screen == 9) // the Final MAIN Map, with all 4 buildings
 {
     dpad (x, y, map6);

     if (px == 16 && (py == 11 || py == 12) && x > 580 && y > 225 && x < 678 && y < 262) //going to the tree in the middle (Tree of Riddles)
     {
  String answer = JOptionPane.showInputDialog ("They call this the Tree of Challenges\nYour Challenge is a riddle: \nWhat is the answer to all of life's problems?");
  if (answer.equals ("math") || answer.equals ("Math") || answer.equals ("MATH"))  //Getting the answer to the riddle correct
  {
      JOptionPane.showMessageDialog (null, "Congratulations on guessing correctly!\nMath is pretty awesome, right?! ", "SUCCESS!",  //getting riddle right
       JOptionPane.INFORMATION_MESSAGE);
      screen = 19; // Congrats screen- the end

  }
  else //getting riddle wrong
  {
      JOptionPane.showMessageDialog (null, "That's not right at all!\nDid you get all the clues?\nGo and get them from the buildings around you!", "NO...",
       JOptionPane.WARNING_MESSAGE);
      arrow = 0; // arrows go away around the tree of riddles
  }
     }

     if ((px == 21 && py == 16) && x > 580 && y > 225 && x < 678 && y < 262) //talking to the lady in bottom right corner
     {
  JOptionPane.showMessageDialog (null, "Hey, it's me? You don't remember me? \nWell anyways, go inside each building and get a clue\nYou'll get 4 letters, to solve the riddle\nThe riddle is a word, 4 letters long.", "Hello!",
   JOptionPane.WARNING_MESSAGE);
     }
     // The following IF statements are the 4 buildings on this last main map
     if ((px == 23 && py == 16) && x > 580 && y > 225 && x < 678 && y < 262 && trainer1 == 1) //entering house in bottom right
     {
  screen = 10;
  px = 16;
  py = 16;
     }

     if ((px > 19 && px < 23) && py == 6 && x > 580 && y > 225 && x < 678 && y < 262) //top right blue building
     {
  dpad (x, y, map8);
  screen = 12;
  px = 16;
  py = 16;
     }

     if ((px == 6 || px == 7) && py == 6 && x > 580 && y > 225 && x < 678 && y < 262) //top left building
     {
  screen = 15;
  px = 16;
  py = 16;
     }

     if ((px == 7 || px == 8) && py == 14 && x > 580 && y > 225 && x < 678 && y < 262) //bottom left building- final
     {
  screen = 17;
  px = 16;
  py = 16;
     }
 }

 if (screen == 10) //Entering the house in the bottom right
 {
     arrow = 0;
     dpad (x, y, map7);

     if (px > 10 && px < 14 && py > 1 && py < 4 && x > 580 && y > 225 && x < 678 && y < 262 && trainer1 == 1) //initialize Battle
     {
  aihp = 174; // reset all stats
  yourhp = 101;
  info = -1;
  info2 = -1;
  info3 = -1;
  info4 = -1;
  info5 = -1;
  screen = 11; // go to battle screen
     }
     if (px > 14 && px < 17 && py > 15 && py < 18 && trainer1 == 0) //exit the house, go back outside to map with all 4 buildings
     {
  screen = 9;
  px = 23;
  py = 16;
     }

 }

 if (screen == 11) // Battle VS Charizard
 {
     if ((x > 345 && y > 283 && x < 411 && y < 304) || (x > 461 && y > 282 && x < 548 && y < 303) || (x > 345 && y > 321 && x < 433 && y < 340)) //fighting buttons
     {
  info2 = (int) (Math.random () * 3 + 1); //the fighting, and how effective it is if info= 1,2 or 3
     }
 }

 if (screen == 12) //Entering the house in the top right
 {
     dpad (x, y, map8);

     if ((px == 14 || px == 15) && py == 12 && x > 580 && y > 225 && x < 678 && y < 262) //initialize battle
     {
  screen = 13; // go to battle screen vs Lugia
  info = -1;
  info2 = -1;
  info3 = -1;
  info4 = -1;
  info4 = -1; //reset stats
  yourhp = 101;
  aihp = 174;
     }

     if (evolve == 1 && (px > 4 || px < 8) && (py > 0 && py < 4) && x > 580 && y > 225 && x < 678 && y < 262) //standing on evolve mat in top right building
     {
  screen = 14; //evolve screen
     }

     if (evolve == 1 && (py == 17 || py == 16) && px > 13 && px < 16) // You MUST evolve to move on, and go back outside
     {
  screen = 9;
  px = 20;
  py = 6;
     }
 }

 if (screen == 13) // Battle VS Lugia
 {
     if ((x > 345 && y > 283 && x < 411 && y < 304) || (x > 461 && y > 282 && x < 548 && y < 303) || (x > 345 && y > 321 && x < 433 && y < 340)) //fighting buttons
     {
  info = -1;
  info2 = -1;
  info3 = (int) (Math.random () * 3 + 1); //the fighting, and how effective it is if info= 1,2 or 3
     }
 }


 if (screen == 14) //evolving screen
 {
     if (x > 58 && y > 29 && x < 565 && y < 370)
     {
  screen = 12;
     }
 }

 if (screen == 15) //top left house
 {
     dpad (x, y, map9);

     if ((px == 5 || px == 4) && py == 1 && x > 580 && y > 225 && x < 678 && y < 262 && fight == 1) // talking to trainer
     {
  JOptionPane.showMessageDialog (null, "So you wanna dance? I was first in my jazz clas- oh you meant Pokebattle?\nRight, I knew that!", "Come at me bro...",
   JOptionPane.INFORMATION_MESSAGE);
  screen = 16; //go to battle screen vs Giratina
  aihp = 174; //reset all other states
  yourhp = 101;
  info = -1;
  info2 = -1;
  info3 = -1;
  info4 = -1;
     }

     if (fight == 0 && py == 16 && (px > 3 && px < 6)) // exiting after winning the battle
     {
  screen = 9;
  px = 6;
  py = 6;
     }
 }

 if (screen == 16) //Battle against giratina
 {
     if ((x > 345 && y > 283 && x < 411 && y < 304) || (x > 461 && y > 282 && x < 548 && y < 303) || (x > 345 && y > 321 && x < 433 && y < 340))
     {
  info4 = (int) (Math.random () * 3 + 1); // generate a random number to dictate effectiveness of attack
     }
 }

 if (screen == 17) // Inside the bottom left building
 {
     dpad (x, y, map10);

     if (px == 19 && py == 5 && x > 580 && y > 225 && x < 678 && y < 262) //Speaking to Opponent
     {
  JOptionPane.showMessageDialog (null, "WELL LOOK WHO IT IS! My brother, Professor Oak's little Poke-trainer!\nMy brother always was a better scientist than me!\n And for that I will destroy YOU (to get back at him)! ", "YOU CANNOT DEFEAT ME.I HAVE THE BEST POKEMON EVER",
   JOptionPane.WARNING_MESSAGE);

  screen = 18; // go to battle screen VS Mewtwo
  yourhp = 101;
  aihp = 174;
     }


     if (px > 9 && px < 13 && py == 16 && mew == 0) //exiting the building
     {
  screen = 9;
     }
 }

 if (screen == 18) //Battle VS mewtwo
 {
     info = -1; //reset all other battle variables
     info2 = -1;
     info3 = -1;
     info4 = -1;

     if ((x > 345 && y > 283 && x < 411 && y < 304) || (x > 461 && y > 282 && x < 548 && y < 303) || (x > 345 && y > 321 && x < 433 && y < 340))
     {
  info5 = (int) (Math.random () * 3 + 1);
     }
 }

 //all the battle stuff= seperator here
 if (screen == 6 || screen == 11 || screen == 13 || screen == 16 || screen == 18)
 { //this is the battle sequence
     // Inside this if statement, the effectiveness of moves is stated

     if (x > 464 && y > 324 && x < 522 && y < 342) //using a Potion
     {
  if (potion > 0)
  {
      info = -1;
      info2 = -1;
      info3 = -1;
      info4 = -1;
      info5 = -1;
      yourhp = 101;
      potion--;
  }
  else if (potion < 1) //If you have no potions left
  {
      JOptionPane.showMessageDialog (null, "You have no more Potions. HAHAHA!", "You're gonna die!",
       JOptionPane.WARNING_MESSAGE);
  }
     }

     if (info == 1 || info2 == 1 && (screen == 6 || screen == 11)) //if info (2) is 1 in the battles against Zubat and Charizard
     {
  JOptionPane.showMessageDialog (null, "It is not very effective. . . \nYour Opponent Loses 10 HP \nYou lose 20 HP ", "Not Effective",
   JOptionPane.WARNING_MESSAGE);
  aihp -= 10;
  yourhp -= 20;

     }

     else if (info == 2 || info2 == 2 && (screen == 6 || screen == 11)) //if info (2) is 2 in the battles against Zubat and Charizard
     {
  JOptionPane.showMessageDialog (null, "It is mildly effective. . . \nYour Opponent Loses 20 HP \nYou lose 10 HP ", "Mildly Effective",
   JOptionPane.INFORMATION_MESSAGE);
  aihp -= 20;
  yourhp -= 10;
     }

     else if (info == 3 || info2 == 3 && (screen == 6 || screen == 11)) //if info (2) is 3 in the battles against Zubat and Charizard
     {
  JOptionPane.showMessageDialog (null, "It is SUPER EFFECTIVE !!! \nYour Opponent Loses 40 HP \nYou lose 10 HP ", "SUPER Effective",
   JOptionPane.INFORMATION_MESSAGE);
  aihp -= 40;
  yourhp -= 10;

     }


     if (info3 == 1 || info4 == 1 && (screen == 13 || screen == 16)) //if info3 and info4 is 1 in battle against Lugia & Giratina
     {
  JOptionPane.showMessageDialog (null, "It is not very effective. . . \nYour Opponent Loses 10 HP \nYou lose 30 HP ", "Not Effective",
   JOptionPane.WARNING_MESSAGE);
  aihp -= 10;
  yourhp -= 30;

     }


     else if (info3 == 2 || info4 == 2 && (screen == 13 || screen == 16))  //if info3 and info4 is 2 in battle against Lugia & Giratina
     {
  JOptionPane.showMessageDialog (null, "It is mildly effective. . . \nYour Opponent Loses 30 HP \nYou lose 15 HP ", "Mildly Effective",
   JOptionPane.INFORMATION_MESSAGE);
  aihp -= 30;
  yourhp -= 15;
     }

     else if (info3 == 3 || info4 == 3 && (screen == 13 || screen == 16))  //if info and info4 is 3 in battle against Lugia & Giratina
     {
  JOptionPane.showMessageDialog (null, "It is SUPER effective. . . \nYour Opponent Loses 50 HP \nYou lose 10 HP ", "SUPER Effective",
   JOptionPane.INFORMATION_MESSAGE);
  aihp -= 50;
  yourhp -= 10;
     }

     if (info5 == 1 && screen == 18)  // Battle VS mewtwo - Not effective
     {
  JOptionPane.showMessageDialog (null, "It is not very effective. . . \nMEWTWO Loses 10 HP \nYou lose 25 HP ", "Not Effective",
   JOptionPane.WARNING_MESSAGE);
  aihp -= 10;
  yourhp -= 25;
     }

     else if (info5 == 2 && screen == 18) // Battle VS mewtwo- Mildly effective
     {
  JOptionPane.showMessageDialog (null, "It is mildly effective. . . \nMEWTWO Loses 40 HP \nYou lose 20 HP ", "Mildly Effective",
   JOptionPane.INFORMATION_MESSAGE);
  aihp -= 40;
  yourhp -= 20;
     }

     else if (info5 == 3 && screen == 18) //Battle VS mewtwo - Very effective
     {
  JOptionPane.showMessageDialog (null, "It is SUPER DUPER ULTRA effective. . . \nMEWTWO Loses 50 HP \nYou lose 5 HP ", "SUPER DUPER Effective",
   JOptionPane.INFORMATION_MESSAGE);
  aihp -= 50;
  yourhp -= 5;
     }

     if (aihp < 1 && screen == 6) // what happens if you defeat Zubat
     {
  JOptionPane.showMessageDialog (null, "You have defeated the trainer and his Pokemon.\nCongratulations! ", "YOU HAVE WON!",
   JOptionPane.INFORMATION_MESSAGE);
  screen = 7;
     }

     else if (aihp < 1 && screen == 11) //Clue after defeating Charizard
     {
  JOptionPane.showMessageDialog (null, "You get your clue! ", "YOU HAVE WON!",
   JOptionPane.INFORMATION_MESSAGE);
  JOptionPane.showMessageDialog (null, createImageIcon ("m.jpg"), "The Letter M", JOptionPane.INFORMATION_MESSAGE);
  yourhp = 101;
  trainer1 = 0;
  screen = 10;
     }

     else if (aihp < 1 && screen == 13) //Clue after defeating lugia
     {
  JOptionPane.showMessageDialog (null, "You get your  clue. You can also now evlove your Pokemon:\nGo to the EVOLVE mat, and press interact! ", "YOU HAVE WON!",
   JOptionPane.INFORMATION_MESSAGE);
  JOptionPane.showMessageDialog (null, createImageIcon ("a.jpg"), "The Letter A", JOptionPane.INFORMATION_MESSAGE);
  evolve = 1;
  screen = 12;
     }

     else if (aihp < 1 && screen == 16) //Clue after defeating giratina
     {
  JOptionPane.showMessageDialog (null, "You get your  clue.", "YOU HAVE WON!",
   JOptionPane.INFORMATION_MESSAGE);
  JOptionPane.showMessageDialog (null, createImageIcon ("t.jpg"), "The Letter T", JOptionPane.INFORMATION_MESSAGE);
  fight = 0;
  screen = 15;
     }

     else if (aihp < 1 && screen == 18) //Clue after defeating mewtwo
     {
  mew = 0;
  JOptionPane.showMessageDialog (null, "You get your  clue.", "YOU HAVE WON!",
   JOptionPane.INFORMATION_MESSAGE);
  JOptionPane.showMessageDialog (null, createImageIcon ("h.jpg"), "The Letter H", JOptionPane.INFORMATION_MESSAGE);
  screen = 17;

     }


     if (aihp > yourhp && yourhp < 1)  //what happens if you lose any of the battles
     {
  JOptionPane.showMessageDialog (null, "HAHA! You lost, game over.", "QUITTING NOW!", JOptionPane.INFORMATION_MESSAGE);
  System.exit (0);

     }
 }


 repaint (); //repaint at the end
    }


    public void update (Graphics g)
    { //Overide the regular update method so it doesn't clear the screen before it draws (Gets rid of annoying white flicker)
 paint (g);
    }


    public void paint (Graphics g)  //Method where screens/images are actually painted
    {
 if (screen == 0) //menu screen
 {
     g.drawImage (title, 0, 0, this);
 }


 if (screen == 1) //instructions
 {
     g.drawImage (instruct, 0, 0, this);
     showStatus ("Copyright Hamza Usmani (not really)");
 }


 if (screen == 2) //First forest map
 {
     g.drawImage (a1, 0, 0, this);
     showStatus ("Talk to the Boy standing outside...");
     g.drawImage (p1, px * 17 + 60, py * 18 + 31, this);
 }


 if (screen == 3) //Professor Oak's House
 {
     g.drawImage (a2, 0, 0, this);
     showStatus ("Proffessor Oak's House");
     g.drawImage (p1, px * 17 + 60, py * 18 + 31, this);
 }


 if (screen == 4) //Choosing a starter screen
 {
     g.drawImage (a3, 0, 0, this);
     showStatus ("The Ultimate Choice...");
 }


 if (choose == 1 || choose == 2 || choose == 3) //After having chosen a pokemon
 {
     g.drawImage (a4, 0, 0, this);
     g.drawString (" " + yourpoke, 391, 287);
     g.drawImage (p1, px * 17 + 60, py * 18 + 31, this);
 }


 if (choose == 4) // Leaving oaks house, back outside
 {
     g.drawImage (a5, 0, 0, this);
     showStatus ("Up we go!");
     g.drawImage (p1, px * 17 + 60, py * 18 + 31, this);
 }


 if (screen == 5) //Second forest level with Zubat fight
 {
     g.drawImage (b1, 0, 0, this);
     g.drawImage (p1, px * 17 + 60, py * 18 + 31, this);
     showStatus ("Who's that guy?");
 }


 if (screen == 6 || screen == 11 || screen == 13 || screen == 16 || screen == 18) //battle scenes
 {
     if (screen == 6) //tutorial battle VS Zubat
     {
  g.drawImage (b2, 0, 0, this);
  showStatus ("FIGHT! (This should be easy...)");
     }
     if (screen == 11) //Battle VS Charizard
     {
  g.drawImage (d4, 0, 0, this);
  g.drawImage (charizard, 380, 69, this);
  showStatus ("The Easy Battle");
     }
     if (screen == 13) // Battle VS Lugia
     {
  g.drawImage (d6, 0, 0, this);
  g.drawImage (lugia, 380, 69, this);
  showStatus ("The Medium Battle");
     }

     if (screen == 16) //Battle VS Giratina
     {
  g.drawImage (d8, 0, 0, this);
  g.drawImage (giratina, 380, 69, this);
  showStatus ("The HARD Battle");
     }

     if (screen == 18) // Battle VS Mewtwo
     {
  g.drawImage (d10, 0, 0, this);
  showStatus ("The VERY ULTRA HARD Battle");
     }

     //The following are the if statements used to draw which ever Pokemon user chooses (in battles)

     if (yourpoke.equals ("Charmander")) //if you choose Charmander
     {
  if (growup == 1)
  {
      charmdefault = charm2; //if you have evolved

  }
  g.drawImage (charmdefault, 148, 183, this);
     }

     else if (yourpoke.equals ("Bulbasaur")) //if you choose Bulbasaur
     {
  if (growup == 2)
  {
      bulbdefault = bulb2; //if you have evolved
  }
  g.drawImage (bulbdefault, 148, 204, this);
     }

     else if (yourpoke.equals ("Squirtle")) //if you choose Squirtle
     {
  if (growup == 3)
  {
      squirtdefault = squirt2; //if you have evolved

  }
  g.drawImage (squirtdefault, 148, 173, this);
     }


     g1.fillRect (169, 102, aihp, 5); //health bars in battles
     g1.setColor (Color.green);

     if (growup == 1 && yourpoke.equals ("Charmander"))
     {
  g2.drawString ("Charmeleon", 370, 212); //Your Pokemon name
     }
     else if (growup == 3 && yourpoke.equals ("Squirtle"))
     {
  g2.drawString ("Wartortle", 370, 212); //Your Pokemon name
     }
     else if (growup == 2 && yourpoke.equals ("Bulbasaur"))
     {
  g2.drawString ("Ivysaur", 370, 212); //Your Pokemon name
     }

     else
  g2.drawString (" " + yourpoke, 370, 212);      //Your Pokemon name

     g2.setFont (new Font ("Arial", Font.BOLD, 20));

     g3.fillRect (428, 222, yourhp, 5);
     g3.setColor (Color.green);

     if (aihp < 69) //health bar colours
     {
  g1.setColor (Color.yellow);
     }
     if (aihp < 39)
     {
  g1.setColor (Color.red);
     }

     if (yourhp < 69)
     {
  g3.setColor (Color.yellow);
     }
     if (yourhp < 39)
     {
  g3.setColor (Color.red);
     }
 }


 if (screen == 7) //After getting out of Prof. Oak's house
 {
     g.drawImage (b1, 0, 0, this);
     g.drawImage (p1, px * 17 + 60, py * 18 + 31, this);
     showStatus ("Keep going up!");
 }


 if (screen == 8) //Long road map
 {
     g.drawImage (c1, 0, 0, this);
     g.drawImage (p1, px * 17 + 60, py * 18 + 31, this);
     showStatus ("Keep going (1/South");
 }


 if (screen == 9) //FINAL MAIN map with four buildings
 {
     g.drawImage (d1, 0, 0, this);
     g.drawImage (p1, px * 17 + 60, py * 18 + 31, this);
     showStatus ("The Final Level");
     if (arrow == 1)
  g.drawImage (d2, 285, 238, this);
 }


 if (screen == 10) //Bottom right building
 {
     g.drawImage (d3, 0, 0, this);
     g.drawImage (p1, px * 17 + 60, py * 18 + 31, this);
     showStatus ("The Easy Battle");
 }


 if (screen == 12) //Top right building
 {
     g.drawImage (d5, 0, 0, this);
     g.drawImage (p1, px * 17 + 60, py * 18 + 31, this);
     showStatus ("The Kind-of Challenging Battle");
 }


 if (screen == 14) //Evolving your Pokemon
 {
     showStatus ("Click anywhere to continue");

     if (yourpoke.equals ("Charmander")) //if your pokemon is charmander
     {
  g.drawImage (charmevo, 0, 0, this);
  growup = 1;
     }

     else if (yourpoke.equals ("Bulbasaur")) //if your pokemon is bulbasoar
     {
  g.drawImage (bulbevo, 0, 0, this);
  growup = 2;
     }

     else if (yourpoke.equals ("Squirtle")) //if your pokemon is squirtle
     {
  g.drawImage (squirtevo, 0, 0, this);
  growup = 3;
     }
 }


 if (screen == 15) // Top Left building inside
 {
     g.drawImage (d7, 0, 0, this);
     g.drawImage (p1, px * 17 + 60, py * 18 + 31, this);
 }


 if (screen == 17) // Bottom Left building inside
 {
     g.drawImage (d9, 0, 0, this);
     g.drawImage (p1, px * 17 + 60, py * 18 + 31, this);
 }


 if (screen == 19) // Congratulations screen- The end of the Game
 {
     g.drawImage (d11, 0, 0, this);
     showStatus ("You WIN THE GAME!");

 }
    }
}





