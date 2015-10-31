#!/bin/bash

#remove old generated files
echo "Removing old files"
rm -rf ./gen-*

#generate for all files & languages
echo ""
for lang in py java js:node; do
    for file in *.thrift; do
        echo "Generating thrift $lang files for $file"
        thrift -r --gen $lang $file
    done
done

#clean up directories, then copy related files
echo ""
echo "Copying generated files to ../vision/server/"
rm -rf ../vision/server/visionservice
rm -rf ../vision/server/logservice
cp -r ./gen-py/visionservice ../vision/server/
cp -r ./gen-py/logservice ../vision/server/

echo "Copying generated files to ../logging/server/"
rm -rf ../logging/server/logservice
cp -r ./gen-py/logservice ../logging/server

echo -e "\nDone."
