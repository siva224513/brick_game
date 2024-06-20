# Tetris Game

A console-based Tetris game implemented in Java, featuring various shapes and rotations. The game supports score tracking and row removal upon filling.

## Features

- Multiple Tetris shapes with rotation functionality.
- Row removal when a row is completely filled.
- Score tracking.
- Basic collision detection to ensure valid placements.

## Installation

1. Clone the repository:
    ```bash
    git clone https://github.com/yourusername/tetrisgame.git
    ```
2. Navigate to the project directory:
    ```bash
    cd tetrisgame
    ```
3. Compile the Java files:
    ```bash
    javac -d bin src/brick_game/*.java
    ```
4. Run the game:
    ```bash
    java -cp bin brick_game.Main
    ```

## How to Play

1. Start the game and enter the size of the board.
2. Players will be prompted to enter the shape number, number of rotations, and the starting column index for each shape placement.
3. The game will validate each move, check for row completions, and update the board accordingly.
4. The game continues until there is no space left to place a shape.

## Game Controls

- Input shapes by specifying the shape number, number of rotations, and the starting column index.
- Coordinates are in the range of 0-7, corresponding to the columns of the board.

## Example Gameplay

```plaintext
Enter row size: 10
Enter column size: 10

enter shape no: 1
enter no of rotations: 0
enter starting column index: 4

Score: 0
| | | | | | | | | | |
| | | | | | | | | | |
| | | | | | | | | | |
| | | | | | | | | | |
| | | | | | | | | | |
| | | | | | | | | | |
| | | | | | | | | | |
| | | | | | | | | | |
| | | |#|#| | | | | |
| | | |#|#| | | | | |

enter shape no: 2
enter no of rotations: 1
enter starting column index: 0

Score: 0
| | | | | | | | | | |
| | | | | | | | | | |
| | | | | | | | | | |
| | | | | | | | | | |
| | | | | | | | | | |
| | | | | | | | | | |
|#| | | | | | | | | |
|#| | | | | | | | | |
|#| | |#|#| | | | | |
|#| | |#|#| | | | | |

