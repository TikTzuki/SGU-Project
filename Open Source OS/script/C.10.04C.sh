#!/bin/bash
clear
for filename in `ls`
do
    if [ ! -f $filename ]; then
        continue
    fi
    
    newfilename=`echo $filename | tr '[A-Z]' '[a-z]'`

    if [ $newfilename != $filename ]; then
        mv $filename $newfilename
    fi
done

echo "\nFinish!\n"