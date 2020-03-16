//To list accounts
curl -X GET "http://localhost:8080/api/account/findAll"

//To add new account
curl -X POST 'http://localhost:8080/api/account/save' \
--header 'Content-Type: application/json' \
--data-raw '{
"id":1,
"accountTypeCurrency":"USD",
"accountTypeDescription":"Dollars"
}'

//To get an account
curl -X GET 'http://localhost:8080/api/account/get/1'

//To delete an account

//With movements
curl -X POST 'http://localhost:8080/api/account/delete' \
--header 'Content-Type: application/json' \
--data-raw '{
"id":1,
"accountType":{"id":1,"accountTypeCurrency":"USD","accountTypeDescription":"Dollars"},
"accountNumber":130444,
"accountBalance":"100,00"}'

//Out of movements
curl -X POST 'http://localhost:8080/api/account/delete' \
--header 'Content-Type: application/json' \
--data-raw '{
"id":2,
"accountType":{"id":2,"accountTypeCurrency":"€","accountTypeDescription":"Euros"},
"accountNumber":240159,
"accountBalance":"250,00"}'


//To list movement of account
curl -X GET 'http://localhost:8080/api/movement/findAllByAccount/1'


//To add new movement

//With allowed amount
curl -X POST 'http://localhost:8080/api/movement/save' \
--header 'Content-Type: application/json' \
--data-raw '{
        "account": {
            "id": 1,
            "accountType": {
                "id": 1,
                "accountTypeCurrency": "USD",
                "accountTypeDescription": "Dollars"
            },
            "accountNumber": 130444,
            "accountBalance": "100.0"
        },
        "movementType": "Credit",
        "movementDescription": "Varios",
        "movementAmount": 100.0
}'

//With amount exceeded
curl -X POST 'http://localhost:8080/api/movement/save' \
--header 'Content-Type: application/json' \
--data-raw '{
        "account": {
            "id": 1,
            "accountType": {
                "id": 1,
                "accountTypeCurrency": "USD",
                "accountTypeDescription": "Dollars"
            },
            "accountNumber": 130444,
            "accountBalance": "100.0"
        },
        "movementType": "Debit",
        "movementDescription": "Otros",
        "movementAmount": 1200.0
}'