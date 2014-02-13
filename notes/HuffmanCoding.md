# Huffman Coding Notes #

English letter frequency:

e 		~ 21%		000		
t 		~ 19%		001
a 		~ 17%		010
i 		~ 16%		011
o 		~ 11%		100
u 		~ 10%		101
s 		~ 6%		110
total	~ 100%

### Question is what kind of encoding to use ###
can assign 000 -> 110

We can make this better by allowing e to use less bits than s. The main thing we need to consider is that the encoding must not be ambiguous. So we are looking for a **variable length encoding** that satisfies the **prefix property** -- where no codes are the prefix of another code.

### How to get codes that have the Prefix Property && What is the best one? ###
Binary trees work well for this because all 'prefix nodes' are contained *before* the terminal node.

e 		~ 21%		0 		21		
t 		~ 19%		1110    76
a 		~ 17%		110     51
i 		~ 16%		1111    64
o 		~ 11%		1001    44
u 		~ 10%		1000    50
s 		~ 6%		101     18
total	~ 100%              314 bits/100 char message

##### Note that we can swap around letters while maintaining the same encoding set to lower the bits.

There is however a beautiful algorithm (Huffman's Algorithm) for figuring out the optimal settings.