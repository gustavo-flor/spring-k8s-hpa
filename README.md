# Spring Kubernetes HPA

## Dependencies

- Docker
- Minikube (Optional)

## Usage

- Start your Minikube cluster (Optional)

```shell
minikube start
```

- Configure minikube to use local image repository (Optional)

```shell
eval $(minikube -p minikube docker-env)
```

- Build docker image

```shell
docker build . -t spring-k8s-hpa
```

- Apply manifests

```shell
kubectl apply -f k8s --recursive
```

- Create Kafka Topic

```shell
kafka-topics --create --bootstrap-server localhost:19092 --replication-factor 1 --partitions 5 --topic events.json
```

## Stop

- Delete manifest

```shell
kubectl delete -f k8s --recursive
```

- Stop minikube (if started)

```shell
minikube stop
```



