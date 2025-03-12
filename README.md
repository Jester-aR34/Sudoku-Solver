# Sudoku Solving Algorithm
Sudoku is a logic-based number-placement puzzle. The objective is to fill a 9x9 grid with digits so that each column, each row, and each of the nine 3x3 subgrids (also called "boxes" or "regions") contain all of the digits from 1 to 9 exactly once. The puzzle starts with some cells already filled in, and the player must deduce the remaining digits according to the rules.
<br>
<br>
The rules of Sudoku are simple but require logical deduction:
<ol>
    <li>Each row must contain the digits 1 through 9 exactly once. No repetition is allowed within a row.</li>
    <li>Each column must contain the digits 1 through 9 exactly once. No repetition is allowed within a column.</li>
    <li>Each of the nine 3x3 boxes (or regions) must contain the digits 1 through 9 exactly once. No repetition is allowed within a box.</li>
</ol>
<br>
This algorithm takes a Sudoku puzzle as input and returns its solution as output. If the input puzzle is invalid (i.e., it violates Sudoku rules) or unsolvable, the algorithm indicates that the puzzle is invalid.
<br>

### Description:

This sudoku-solving algorithm uses the backtracking method to find a solution. It looks for an empty spot on the Sudoku board and places a number (from 1 to 9) in it. For each valid placement (following Sudoku rules), it moves on to the next empty spot and tries again to solve the remaining puzzle. If a dead end is reached (no valid number can be placed), the algorithm backtracks, resetting the cell and trying a different number. This process continues until either a complete and valid solution is found, or all possibilities are exhausted, indicating an unsolvable puzzle.

### Input method: 

This program asks for an input for every individual element. 

<u>Example :</u>

![alt text](image.png)

After entering a value for the cell, the program displays the current state of the Sudoku grid. A dot ('.') represents a cell that requires input. If the entered value is 0, the cell remains empty and will be filled by the algorithm’s solution. If the entered value is between 1 and 9, it is fixed in the cell and will be used to complete the Sudoku grid. As shown below, the user entered 5 for cell R1C1 and 0 for cell R1C2

![alt text](image-1.png)

After providing a valid input for the algorithm, the program prompts the user for any changes to the Sudoku grid. It accepts 'yes' or 'no' as input. If you enter 'yes,' the program asks for the position of the cell you want to modify and the new value to update it. If you enter 'no,' the algorithm proceeds to solve the Sudoku grid.

![alt text](image-2.png)

### Output:

If the given Sudoku problem violates any rules, the algorithm will not run, and the program will stop, indicating that the problem is invalid. However, if the Sudoku problem follows the rules but is logically unsolvable, the algorithm will return an incomplete array where the last element is 0, signifying that the Sudoku puzzle cannot be solved.
<br>
The bellow example shows the output for a given Sudoku problem that violated some rules or the Sudoku problem that follows the rules but logically unsolvable:

![alt text](image-3.png)

It shows 55 as null values as the given sudoku problem consists of 51 empty cells that would be solved by the algorithm.
If the given sudoku problem is valid and doesn’t violates any rule or logically solvable then the algorithm solves the sudoku problem and displays the solution array and solved sudoku grid.


