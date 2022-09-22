# Prices

This is API to get product's prices. <br /> <br />
Data is saved in embedded H2 database.

### Environment setup
Make sure following software is installed on your PC.
* Java 11
* Maven

### Compile & Test
```shell
mvn clean install test
```

### Run app using maven
```shell
mvn spring-boot:run
```

### Endpoints
```GET /price``` Get product's price for given ```date``` with ```product id``` and ```brand id```
#### JSON Schema of request body
```json
{
  "type": "object",
  "properties": {
    "date": {
      "type": "string" // format must be: dd-MM-yyyy HH:mm:ss
    },
    "productId": {
      "type": "integer"
    },
    "brandId": {
      "type": "integer"
    }
  },
  "required": [
    "date",
    "productId",
    "brandId"
  ]
}
```

#### Example Request
```shell
curl --location --request GET 'http://localhost:8080/price' \
--header 'Content-Type: application/json' \
--data-raw '{
    "date": "15-06-2020 14:00:00",
    "productId": 35455,
    "brandId": 1
}'
```
#### Example Response
```json
{
    "productId": 35455,
    "brandId": 1,
    "priceList": 1,
    "price": 35.50,
    "date": "15-06-2020 14:00:00"
}
```