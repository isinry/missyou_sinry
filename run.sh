#! /bin/bash

cd ./target

name=$(ls demo*.jar -1 | sort -r | head -n 1)
echo "package: $name"
echo "env: $JAVA_ENV"

java -jar $name --spring.profiles.active=$JAVA_ENV
sleep 5
