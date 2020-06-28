#!/bin/bash
clear
read -p "Please enter a number: " num

for (( i = 1; i*i <= num; i++ ))
do
    if test `expr $i \* $i` -eq $num; then
        echo "\nThis is a square number.\n"
        exit 0
    fi
done

echo "\nThis is not a square number.\n"