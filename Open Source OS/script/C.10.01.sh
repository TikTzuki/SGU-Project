#!/bin/bash
clear
read -p "How many numbers do you want to enter? " n

read -p "\nPlease enter number 1: " num
max=$num

for (( i = 2; i <= n; i++ ))
do
    read -p "Please enter number $i: " num

    if [ $num -gt $max ]; then
        max=$num
    fi
done

echo "Max: $max.\n"