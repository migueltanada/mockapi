# Mock microserivce Endpoints

## 1\. [GET] /mock/path/{path}

Send whatever is in path / request body


### Request body
| field | description | data type | remarks |
|-------|-------------|-----------|---------|
|desired.status                       | What will be sent in response success field Success/Error/Warning                                                        | String[Success/Error/Warning] | | 
|desired.httpCode                     | What will be sent in response httpCode. Not as json field but as actual http code                                        | Number[0,200-599]             | | 
|desired.code                         | What will be sent in response code field                                                                                 | String                        | |
|desired.json.response.body.string    | What will be sent in response body field. Should this be a string containing json?<br> or can i actually use json fields | String                        | |

```json
{
    "desired.status": "Success",
    "desired.httpCode": 200,
    "desired.code": "",
    "desired.json.response.body.string": {
        "testkey1": "testvalue1",
        "testkey2": "testvalue2"
    }
}
```

### reponse body
```json
{
    "status": "Success",
    "code": "",
    "description": "mock api",
    "body": {
        "testkey1": "testvalue1",
        "testkey2": "testvalue2"
    },
    "path": "path/url where request was sent sample: /mock/path/sample",
}
```


## 2\. [GET] /mock/config/{path}

Send whatever is in config. select the property using request body.
property will reside in applicaiton.properties

```json
{
    "config.property": "test.mock"
}
```

## 3. [GET] /mock/mongodb/{path}

Send whatever is in mongodb. 



# How to deploy build

## deploy microservice
1. ``helm template <release name> mockapi-helm | kubectl apply -f -`` or
1. ``helm install <release name> mockapi-helm``

## deploy conifg
1. lmoa i dont know how to yet

## build
1. ``docker build -t <image-name> .``
2. ``docker push <image-name>``


