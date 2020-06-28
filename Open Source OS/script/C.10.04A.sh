#!/bin/bash
clear
read -p "Please enter a file name: " filename

newfilename=`echo $filename | tr -s '[:upper:]' '[:lower:]'`

mv $filename $newfilename

ls