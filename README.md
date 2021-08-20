# Mock microserivce Endpoints

## 1\. [POST] /mock/path/{path}

Send whatever is in path and request body. Path field is always included in the response!


### Request body
| field | description | data type | remarks |
|----------------|--------------------------------------------------------------------------------------------------------------------------|---------------------|---|
|mockStatus      | What will be sent in response success field Success/Error/Warning                                                        | String              |   | 
|mockHttpCode    | What will be sent in response httpCode. Not as json field but as actual http code                                        | Number[0,200-599]   |   | 
|mockCode        | What will be sent in response code field                                                                                 | String              |   |
|mockDescription | What will be sent in response description field                                                                          | String              |   |
|mockBody        | What will be sent in response body field. Can be a map                                                                   | Map<String, Object> |   |


```json
{
    "mockStatus": "Success",
    "mockHttpCode": 200,
    "mockCode": "MIT001",
    "mockDescription": "Sample Description",
    "mockBody": {
        "testkey1": "testvalue1",
        "testkey2": "testvalue2",
        "test":{
        	"key": "value"
        }
    }
}
```

### Response  body
```json
{
    "code": "MIT001",
    "description": "Tangina mo jepoy dizon",
    "path": "http://localhost:8080/mock/path/test",
    "status": "Success",
    "body": {
        "testkey1": "testvalue1",
        "testkey2": "testvalue2",
        "test": {
            "key": "value"
        }
    }
}
```
<br>
<br>
<br>

## 2\. [GET] /mock/config/{path}

Send whatever is in application.properties file. select the property using request path.
Path field is always included in the respones, unless it is available in application.propreties!
Format:
- Path : /mock/config/<String>
- application.properties: mock.config.<String>

### Sample Request
```http
[GET] http://localhost:8080/mock/config/sample1
[GET] http://localhost:8080/mock/config/sample2
```

### Sample Response
```json
{
    "path": "http://localhost:8080/mock/config/sample1",
    "code": "sample1",
    "description": "test",
    "status": "test",
    "body": {
        "key1": "value1",
        "key2": "value2"
    }
}
```

### application.properties snippet
```java
logging.level.org.springframework=info
mock.config.sample1={ "code": "sample1", "description": "test", "status": "test", "body": { "key1": "value1", "key2": "value2" } }
mock.config.sample2={ "code": "sample2", "description": "test", "status": "test", "body": { "key1": "value1", "key2": "value2" } }
```

### Don't include quotes at the begininng of your json!

- Check: ``mock.config.sample1={ "key": "value" }``
- EKIS:  ``mock.config.sample1='{ "key": "value" }'``

<br>
<br>
<br>

## 3. [POST] /mock/mongodb/{path}

Send whatever is in mongodb. 

<br>
<br>
<br>

# How to deploy/build

## deploy microservice
There are five different ways you can express the chart you want to install:

Assuming:
- release name: release1
- chart name: mockapi
- helm repo: https://github.com/migueltanada/helm_repo.git

1. By chart reference ``helm template release1 helm_repo/mockapi --set configmaps.env=sit,configmaps.enable=false``
1. By path to a packaged chart: ``helm install release1 ./mockapi-0.1.0.tgz``
1. By path to an unpacked chart directory: ``helm install release1 helm_repo/mockapi``
1. By absolute URL: ``helm install release1 https://github.com/migueltanada/helm_repo/blob/master/mockapi-0.1.0.tgz.sample?raw=true``
1. By chart reference and repo url: ``helm install --repo https://github.com/migueltanada/helm_repo release1 mockapi``

## Set which config to read/create config
``--set configmaps.env=sit,configmaps.enable=false``

## build
1. ``docker build -t <image-name> .``
2. ``docker push <image-name>``

## Sample quick install
```bash

# Install ingress if (optional)
helm repo add ingress-nginx https://kubernetes.github.io/ingress-nginx
helm repo update
helm install ingress-nginx ingress-nginx/ingress-nginx --create-namespace --namespace dev


# Install app
helm install latest helm_repo/mockapi --set configmaps.env=dev
```
