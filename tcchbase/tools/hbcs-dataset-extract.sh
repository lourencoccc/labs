#!/bin/sh

#dependencies
#dnf install p7zip p7zip-plugins

PATH_COMPRESSED_DATASET=$PRJDATASET/stackexchange
PATH_EXTRACTED_DATASET=$PRJDATASET/stackexchange-extracted
PATH_STACKOVERFLOW_DATASET=$PRJDATASET/stackoverflow-extracted/stackoverflow.com

if [ -d "$PATH_EXTRACTED_DATASET" ]; then
  echo "stackexchange extracted"
else
  mkdir -p $PATH_EXTRACTED_DATASET
  for pathFile7z in `ls $PATH_COMPRESSED_DATASET/*.7z`
  do
    filename=`basename $pathFile7z`
    fname="${filename%.*}"
    if [ -d "$PATH_EXTRACTED_DATASET/$fname" ]; then
      echo "$filename extracted"
    else
      7z x -o$PATH_EXTRACTED_DATASET/$fname $pathFile7z
    fi
  done
  echo "Join files of stackoverflow.com"
  if [ -d "$PATH_STACKOVERFLOW_DATASET" ]; then
    echo "stackoverflow.com extracted"
  else
    mkdir -p $PATH_STACKOVERFLOW_DATASET
    mv $PATH_EXTRACTED_DATASET/stackoverflow.com-*/* $PATH_STACKOVERFLOW_DATASET
    rm -fr $PATH_EXTRACTED_DATASET/stackoverflow.com-*
  fi
fi
