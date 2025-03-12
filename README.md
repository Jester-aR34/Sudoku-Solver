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

