#!/bin/sh
# Execute the main class of the Java code
LEINCP=`lein classpath`
lein javac
java -cp $LEINCP flexiana_platform.core.FlexianaPlatform
