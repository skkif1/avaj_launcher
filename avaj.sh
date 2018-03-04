#!/bin/bash
find . -name '*.java' > sources.txt
mkdir out
javac -d out -sourcepath ./com.omotyliu.avaj_launcher/src @sources.txt
rm sources.txt
