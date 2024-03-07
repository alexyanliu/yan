This is a sample booking application using mu-server.

You can run it locally by running Booking#main or try as a single java main application. 

The following is a collection of the sample requests & responses. 

1. Add a new booking:

Request:
http://localhost:8080/booking/name2/2/20240401/17/20

Response:
ok

2. Get all bookings:

Request:
curl --location 'http://localhost:8080/booking/list' \
--header 'token: owner'

Response:
[ {
  "customerName" : "name1",
  "tableSize" : 16,
  "startDate" : "2024-03-31 18:20",
  "endDate" : "2024-03-31 20:20"
}, {
  "customerName" : "name2",
  "tableSize" : 2,
  "startDate" : "2024-04-01 17:20",
  "endDate" : "2024-04-01 19:20"
} ]

