#!/bin/bash
clear

read -p "How many numbers do you want to enter? " length

for (( i = 0; i < length; i++ ))
do
    read -p "Number $i: " num
    numArray[$i]=$num
done

for (( i = 0; i < length; i++ ))
do
    for (( j = i + 1; j < length; j++ ))
    do
        if test ${numArray[$i]} -gt ${numArray[$j]}; then
            let temp=${numArray[$i]}
            let numArray[i]=${numArray[$j]}
            let numArray[j]=temp
        fi
    done
done

printf "\nSorted Array: ${numArray[*]}.\n\n"