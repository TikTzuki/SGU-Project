#!/bin/bash
clear
read -p "Please enter a file name: " filename
newfilename=`echo $filename | tr -s '[:upper:]' '[:lower:]'`

mv $filename $newfilename

if [ $? -eq 0 ]; then
    echo "\nYour file was renamed successfully.\n"
else
    echo "\nYour file cannot be renamed.\n"
fi

ls
echo "\n"