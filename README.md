# Conway's Game of Life

A Graphical Interface Application which accepts the starting conditions and helps the user to observe the Game of Life through many generations.

## Rules of the game

-   Any live cell with two or three live neighbours survives.
-   Any dead cell with exactly three live neighbours becomes a live cell.
-   All other live cells die in the next generation. Similarly, all other dead cells stay dead.

## Features

-   Users can change the dimensions of the board at any time.
-   Users can change a live cell to dead or vice versa by giving input of the coordinates of the cell.
-   Each generation will be printed.
-   The board will automatically expand as and when it's needed to accommodate the live cells out of bounds.
-   The game will stop when the board has all dead cells or if it's encountering the same pattern.

## Screenshots

_To view the full Terminal interaction, please click [here](http://p.ip.fi/142e)._

![ss3](images/ss3.png)
![ss1](images/ss1.png)
![ss2](images/ss2.png)

## Steps to follow

-   Create a basic command line logic to recreate this game
-   Try to use Swing to create the GUI
