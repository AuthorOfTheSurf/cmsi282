# Dynamic Programming Notes #

    n = 29 (is this prime?)
    2 3 4 5 6 7 8 9 10 11 12 13 14 ... 26 27 28 29
    strike multiples of two
    3 5 7 9 11 13 15 17 19 21 23 25 27 29
    strike multiples of three
    5 7 11 13 17 19 23 25 29
    strike multiples of five
    7 11 13 17 19 23 29
***We stop now because 7 is the first prime that is greater than the root of 29. This implies that in order to go into 29, 7 must be multiplied by a number lower than it. However as we solved we have eliminated numbers below 7 as potential 'mates'. 2, 3, 5 are prime, if they went into 29 we would have found that out already. 4 and 6 are composite so they cannot be used as 29 would not be prime then. So we stop at 7, no need cross it or proceed onto 11.

fun fact: best algorithm for determining non-compositeness is in n^12 time and potentially n^6 time. The algorithm for this got better just 10 years ago. *n is the number of digits not the base-10 number.

### Sieves  ###

sieve of Eratosthenes
sieve = eliminate things (usually non-solutions)

Sieves as a Solving tool
- useful for EGGS problems

#### Optimal Subtructure ###
Opetimal solution to "Big Problem" can be composed of optimal solutions to (some) sub-problems. Memoization means avoiding to re-solve subproblems (it solves the Overlapping Subproblems problem). This is prominent in certain recursive programs.

### Tile Puzzle ###

Some dominoes: [3, 4] [4, 12] [12, 2] [2, 7] [7, 4]
--note how adjacent tiles have the same matching number, 4 -> 4, 12 -> 12 ...

long mergeCost ([i, j], [j, k]) {
    return i * j * k;
}

tile merge ([i, j], [j, k]) {
    return [i, k];      //this costs mergeCost to do
}

+   So the puzzle is how to combine all the tiles into one single tile with the lowest possible score.
+   For n tiles, there seems to be (n-1)(n-2)(n-3)(...)(n-(n-1)) ways to combined. This comes from the logic of 5 tiles becomes 4 tiles. Now instead of having 4 potential combinations, there are 3. Hence the (n-1)! time.

*This problem is present in **Matrix Chain Multiplication** *






















