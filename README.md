Sample Scala
------------

Run Locally (with Java 8+ installed):
```
./sbt run
```

Build Docker Container:
```
./sbt docker:publishLocal
```

Run Locally with Docker:
```
docker run -it -ePORT=8080 -p8080:8080 scala-webapp:docker
```

Run on Cloud Run (with two clicks):

[![Run on Google Cloud](https://deploy.cloud.run/button.svg)](https://deploy.cloud.run)
