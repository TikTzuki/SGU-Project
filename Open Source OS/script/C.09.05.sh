#!/bin/bash
echo "How many numbers do you want to enter?"
read n

sum=0

for (( i = 1; i <= n; i++ ))
do
    echo "Please enter number $i:"
    read num
    let sum+=num
    #sum=`expr $sum + $num`
done

echo "Total: $sum."