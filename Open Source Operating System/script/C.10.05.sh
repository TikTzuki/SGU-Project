#!/bin/bash
clear
for (( i=1; i <= 10; i++ ))
do
    useradd "user$i"
    passwd "user$i" "abc"
done

echo "\nFinish!\n"