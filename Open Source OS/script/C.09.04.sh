#!/bin/bash
echo "Pleae enter a:"
read a
echo "Please enter b:"
read b
echo "Please enter c:"
read c

echo "Your equation is: $a * x + $b = $c."

# For integer only.
echo "x = `expr $c - $b / $a`."

# For decimal.
x=`echo "scale=2;$c-$b/$a" | bc`
echo "x = $x."