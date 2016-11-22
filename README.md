# JSinopia

My running attempt to get Sinopia up and running on the jvm


## Set-up

`jsinopia` uses a bundled sinopia that has to be built locally before you can run it

```sh
npm i -g noderify
git clone https://github.com/doug-wade/sinopia
cd sinopia
npm i
noderify index.js > /path/to/jsinopia/bundle.js
```


## Running locally

Intellij generated a jsinopia.xml rather than a build.xml, so you have to provide the
path to the file as an argument

```sh
ant -buildfile jsinopia.xml run-jar
```