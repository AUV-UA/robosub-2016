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
rm -rf ../vision/visionservice
rm -rf ../vision/logservice
cp -r ./gen-py/visionservice ../vision/
cp -r ./gen-py/logservice ../vision/

echo "Copying generated files to ../logging/server/"
rm -rf ../logging/logservice/*
cp -r ./gen-nodejs/* ../logging/logservice

echo -e "\nDone."
