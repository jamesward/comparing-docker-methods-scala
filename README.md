Sample Scala
-----------------

Run Locally (with Java 8+ installed):
```
./sbt run
```

Build Docker Container:
```
pack build --builder=heroku/buildpacks scala-webapp:buildpacks
```

Run Locally with Docker:
```
docker run -it -ePORT=8080 -p8080:8080 scala-webapp:buildpacks
```

Run on Cloud Run (with two clicks):

[![Run on Google Cloud](https://deploy.cloud.run/button.svg)](https://deploy.cloud.run)
