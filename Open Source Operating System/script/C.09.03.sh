#!/bin/bash
echo "Pleae enter 1st number:"
read num_1
echo "Please enter 2nd number:"
read num_2

echo "Your two numbers are: $num_1 and $num_2."

echo "Sum: $num_1 + $num_2 = `expr $num_1 + $num_2`"
echo "Minus: $num_1 - $num_2 = `expr $num_1 - $num_2`"
echo "Multiply: $num_1 * $num_2 = `expr $num_1 \* $num_2`"
echo "Divide: $num_1 / $num_2 = `expr $num_1 / $num_2`"
echo "Mod: $num_1 % $num_2 = `expr $num_1 % $num_2`"