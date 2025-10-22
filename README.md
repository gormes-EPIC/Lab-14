# Lab 14

## Heat Map

In this section, you will create a class `Heatmap` which represents temperature values across a given area. The data values are stored in `.csv` files and are organized in a grid with a given number of rows and columns. Three sample 20 by 20 `Heatmap` files have been provided for you in addition to two classes, `HeatmapViewer` and `Main`.
- `Main`: Contains the main method and tester code for your `Heatmap` class.
- `HeatmapViewer`: Contains code  to visually display a given `Heatmap`.


Create the class `Heatmap` with the following private instance variable.

| Variable            | Description                              |
| ------------------- | ---------------------------------------- |
| double\[\]\[\] data | Stores the data representing the heatmap |

Create the following constructor.

| Method                                                                 | Description                                                                                                                                                           |
| ---------------------------------------------------------------------- | --------------------------------------------------------------------------------------------------------------------------------------------------------------------- |
| public Heatmap(int rows, int cols, String filename) throws IOException | Creates a new `Heatmap` of a given size(defined by `rows` and `cols`) from a given file(`filename`). This constructor should read the data in from the provided file. |

Now add the following methods. You may add additional private methods as necessary. 

| Method                           | Description                                                                  |
| -------------------------------- | ---------------------------------------------------------------------------- |
| public void printHeatmap()       | Prints the `Heatmap` in row-major order                                      |
| public double sumHeatmap()       | Sums the contents of the `Heatmap` and returns the sum                       |
| public double avgHeatmap()       | Averages the contents of the `Heatmap` and returns the average temperature   |
| public double sumColumn(int col) | Sums the contents of the `Heatmap` from the given column and returns the sum |
| public double sumRow(int row)    | Sums the contents of the `Heatmap` from the given row and returns the sum    |
| public int areCold ()            | Counts and returns the number of data points under 10 degrees                |

If your Eclipse isn't recognizing `java.swing`. 
1. Right-click on the project
2. Select properties
3. Java build path
4. Library > Add Library > Add JRE SYSTEM Library
5. Execution Environment
6. Select JavaSE-1.7 (or 1.8 or even higher)
7. Finish


## Battleship Game Board Validator

For this section, you will be creating a program to validate Battleship game boards. The game board is a 10 by 10 array of Strings(or chars). 

Here is a sample input file containing a board: 

```
0,0,0,0,0,0,0,0,0,0
0,0,0,0,0,0,0,R,0,0
0,0,0,0,0,0,0,R,0,0
0,0,0,0,0,0,0,R,0,0
0,0,0,0,0,0,0,0,0,0
C,C,C,C,C,0,0,0,0,0
B,B,B,B,0,0,0,0,0,0
0,0,0,0,0,0,0,D,0,0
S,S,S,0,0,0,0,D,0,0
0,0,0,0,0,0,0,0,0,0
```

- C is a Carrier(5 squares)
- B is a Battleship(4 squares)
- R is a Cruiser(3 squares)
- S is a Submarine(3 squares)
- D is a Destroyer (2 squares)

This is a **valid** battleship board. It is 10 by 10, has all 5 ships(which have each been represented by the correct number of squares) placed horizontally or vertically on the board.

```
0,0,0,0,0,0,0,0,0,0
0,0,0,0,0,0,0,0,0,0
C,C,C,C,C,0,0,0,0,0
B,B,B,B,0,0,0,0,0,0
0,0,0,0,0,0,0,0,0,0
0,0,0,0,0,0,0,0,0,0
R,0,0,0,0,0,0,0,0,0
R,0,0,0,0,0,0,0,0,0
S,S,S,0,0,0,0,0,0,0
0,0,0,0,0,0,0,0,0,0
```

This is an **invalid** battleship board. It is 10 by 10, but is missing the Destroyer. 

```
O,O,O,O,O,C,C,C,C,C
O,O,O,O,O,R,O,O,O,O
O,O,O,O,R,O,O,O,O,O
O,O,O,R,O,O,O,O,O,O
O,O,O,B,B,B,B,0,O,O
O,O,O,O,O,O,O,O,O,O
O,O,O,O,O,O,O,O,O,O
D,0,0,0,0,S,S,S,0,0
D,O,O,O,O,O,O,O,O,O
O,O,O,O,O,O,O,O,O,O
```

This is an **invalid** battleship board. It is 10 by 10, but the Cruiser has been placed diagonally.

```
0,0,0,0,0,0,0,0,0,0
0,0,0,0,0,0,0,0,0,0
C,C,C,C,C,0,0,0,0,0
B,B,B,B,0,0,0,0,0,0
0,0,0,0,0,0,0,0,0,0
0,0,0,0,0,0,0,0,0,0
R,R,R,0,0,0,0,0,0,0
0,0,0,0,0,0,0,0,0,R
S,0,0,0,0,0,0,0,0,R
S,0,0,0,0,0,0,0,0,R
```

This is an **invalid** battleship board. It is 10 by 10, but the Cruiser has been placed twice.

```
0,0,0,0,0,0,0,0,0
0,0,0,0,0,0,0,0,0
C,C,C,C,C,0,0,0,0
B,B,B,B,0,0,0,D,0
0,0,0,0,0,0,0,D,0
0,0,0,0,0,0,0,0,0
R,0,0,0,0,0,0,0,0
R,0,0,0,0,0,0,0,0
S,S,S,0,0,0,0,0,0
```

This is an **invalid** battleship board. It is 9 by 9, not 10 by 10.


### Step 1

Create a `ValidateRunner` and `Validate` class. The `ValidateRunner` should prompt the user for a file name and create a 2D array to represent their input. Then, create a `Validate` class with the static method `boardValidator(String[][] board)`. This should return `True` or `False` based on if the inputted board was valid. Then in your `VaildateRunner`, use the `validateBoard` method to test if the inputted board is valid and print the information to the user.  

A run of the program should look like:

```
Input: battleship_board_1.csv
This board is Valid.
```


### Step 2

Create a new static method in `Validate` called `balanced(String[][] board)`. This will return `True` if each row and column contain only 0-2 ships.

For example:
```
0,0,0,0,0,0,0,0,0
0,0,0,0,0,0,0,0,0
C,C,C,C,C,0,0,0,0
B,B,B,B,0,0,0,D,0
0,0,0,0,0,0,0,D,0
R,0,0,0,0,0,0,0,0
R,0,0,0,0,0,0,0,0
R,0,0,0,0,0,0,0,0
S,S,S,0,0,0,0,0,0
```

This is **unbalanced** because column 1 contains 4 different ships. 

```
0,0,S,S,S,0,0,0,0
0,0,0,0,0,0,0,0,0
C,C,C,C,C,0,0,0,0
0,0,0,0,0,0,0,D,0
0,0,0,0,0,0,0,D,0
R,0,0,0,0,0,0,0,0
R,0,0,0,0,B,B,B,B
R,0,0,0,0,0,0,0,0
0,0,0,0,0,0,0,0,0
```

This is **balanced** because each row and column contains 2 or fewer ships.

Update your `ValidateRunner` to use `balanced()`. A run of the program should look like:

```
Input: battleship_board_1.csv
This board is Valid.
This board is Balanced.
```
