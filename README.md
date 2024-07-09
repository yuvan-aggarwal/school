addBinary(String a, String b): This method performs binary addition.

Split the input strings on the decimal point.
Pad the fractional parts with trailing zeros to make them the same length.
Traverse both strings starting from the last characters.
Compute the sum of the last digits and carry.
If the current digit sum is 1 or 3, add 1 to the result.
Compute the carry and move to the next digits.
If there was a fractional part, insert the decimal point at the correct position in the result.
subtractBinary(String a, String b): This method performs binary subtraction.

Split the input strings on the decimal point.
Pad the fractional parts with trailing zeros to make them the same length.
Traverse both strings starting from the last characters.
Subtract the borrow from the current digit.
If the subtracted value is negative, add 2 to it and consider it as borrow.
Concatenate the result and move to the next digits.
If there was a fractional part, insert the decimal point at the correct position in the result.
multiplyBinary(String a, String b): This method performs binary multiplication.

Convert the binary strings to decimal, multiply them, and convert the result back to binary.
divideBinary(String dividend, String divisor): This method performs binary division.

Find the position of the decimal point in the dividend and divisor.
Remove the decimal point from the dividend and divisor.
Calculate the position of the decimal point in the result.
Perform long division.
Insert the decimal point at the correct position in the result.
Remove unnecessary leading zeros from the result.







Addition:

Start from the rightmost bit (least significant bit) of both numbers.
Perform the addition of the bits at the same position in both numbers.
If the sum is 2, write down a 0 and carry a 1 over to the next higher bit.
If the sum is 3, write down a 1 and carry a 1 over to the next higher bit.
If the sum is 1 or 0, write down the sum and carry over a 0 to the next higher bit.
Repeat this process until all bits have been added. If there is a carry left after adding the leftmost bits (most significant bits), write this carry to the left of the result.
Subtraction:

Start from the rightmost bit of both numbers.
Perform the subtraction of the bits at the same position in both numbers.
If the bit in the minuend (the number from which another number is to be subtracted) is smaller than the bit in the subtrahend (the number to be subtracted), borrow a 1 from the next higher bit in the minuend.
If the bit in the minuend is larger or equal to the bit in the subtrahend, subtract the bits.
Repeat this process until all bits have been subtracted.
Multiplication:

Start from the rightmost bit of the second number.
If the bit is 1, write down the first number. If the bit is 0, write down a row of zeros.
For the next higher bit in the second number, again write down the first number if the bit is 1, or a row of zeros if the bit is 0. This time, however, shift the number one position to the left.
Repeat this process until all bits in the second number have been processed.
Add up all the numbers written down. This sum is the result of the multiplication.
Division:

Write down the divisor and the dividend.
Compare the divisor with the leftmost bits of the dividend. The number of bits in the divisor determines how many bits in the dividend you should look at.
If the bits in the dividend are larger or equal to the divisor, write down a 1 in the quotient and subtract the divisor from the dividend.
If the bits in the dividend are smaller than the divisor, write down a 0 in the quotient.
Shift the remaining part of the dividend one bit to the left and repeat the process until all bits in the dividend have been processed.



Conversion of the Integer Part:

The integer part of the number is converted using a simple positional notation system. Each digit in the number is multiplied by the base of the number system raised to the power of its position, starting from 0 for the rightmost digit (least significant digit). The results are then summed up. This is done in the convertIntegerPart method.

Conversion of the Fractional Part:

The fractional part is converted similarly to the integer part, but the powers are negative. Each digit is divided by the base raised to the power of its position, starting from -1 for the first digit after the decimal point. The results are then summed up. This is done in the convertFractionalPart method.

Conversion to the Target Base:

After the number is converted to a decimal number (and a decimal fraction for the fractional part), it is then converted to the target base. For the integer part, this is done by repeatedly dividing the number by the target base and keeping track of the remainders. The remainders then form the digits of the number in the target base. For the fractional part, this is done by repeatedly multiplying the fraction by the target base and keeping track of the whole numbers that result. These whole numbers then form the digits of the fraction in the target base.

