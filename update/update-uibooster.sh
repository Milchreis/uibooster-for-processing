#!/bin/bash

# Get current master of UiBooster
wget https://github.com/Milchreis/UiBooster/archive/master.zip
unzip master.zip

# Download dependencies by pom.xml
apache-maven-3.6.3/bin/mvn -DskipTests install dependency:copy-dependencies -f UiBooster-master/pom.xml

# Copy non-testing libs to third-party-libs directory
rsync -avr \
	--exclude='*jupiter*' \
	--exclude='*test*' \
	--exclude='*junit*' \
	UiBooster-master/target/dependency/*.jar ../lib

# Copy the source code
rsync -avr UiBooster-master/src/main/java/de/milchreis/* ../src/

# Copy the resources
rsync -avr UiBooster-master/src/main/resources/* ../data/

# Shorten the package names in all imports
find ../src/ -type f -exec \
    sed -i 's/de.milchreis.//g' {} +

# Correct resource files paths to data/ directory
for filename in UiBooster-master/src/main/resources/*; do
    fname=`basename ${filename}`
    find ../src/ -type f -exec \
        sed -i "s/$fname/data\/$fname/g" {} +
done

# Cleanup
rm master.zip
rm -r UiBooster-master/