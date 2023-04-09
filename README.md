inugami-springboot-demo
===============================================================================

Tools :
-------------------------------------------------------------------------------

* H2 console : http://localhost:8080/h2-console (jdbc:h2:mem:testdb | sa | sa)
* Swagger : http://localhost:8080/doc/swagger-ui/index.html



Features :
-------------------------------------------------------------------------------
### Controller Advice
Inugami controller advice will intercept all exceptions and produce Zalando problem like :

```
{
  "cause": {
    "cause": null,
    "stackTrace": [],
    "type": "about:blank",
    "title": "can't create user",
    "status": null,
    "detail": null,
    "instance": null,
    "parameters": {},
    "message": "can't create user",
    "suppressed": [],
    "localizedMessage": "can't create user"
  },
  "stackTrace": [],
  "type": "about:blank",
  "title": "can't create user",
  "status": "INTERNAL_SERVER_ERROR",
  "detail": "",
  "instance": null,
  "parameters": {
    "errorCode": "USER-1_4",
    "fields": [],
    "application": "inugami-demo-user",
    "version": "2.3.0-SNAPSHOT",
    "errorType": "technical",
    "errorCategory": "user"
  },
  "message": "can't create user: ",
  "suppressed": [],
  "localizedMessage": "can't create user: "
}
```


### IOLOG :

```
2023-04-09 22:21:58.205 ERROR 568565 --- [nio-8080-exec-2] IOLOG                                    : [POST] /user
headers :
x-device-identifier: 7b9e8385-d857-4f07-ac32-e778cef99673
content-type: application/json
user-agent: PostmanRuntime/7.29.2
accept: */*
postman-token: 4eaa7bb5-6918-42d6-a6e9-40db7c739e6d
host: localhost:8080
accept-encoding: gzip, deflate, br
connection: keep-alive
content-length: 87
payload :
{
    "firstname":"john",
    "lastname":"smith",
    "email":"john.smith@inugami.io"
}
response:
status:500
datetime:1681071718203
duration:699
contentType:application/json
headers:
x-device-identifier: 7b9e8385-d857-4f07-ac32-e778cef99673
x-correlation-id: 0ec03a66-4015-4d78-af30-00c11e7ca526
x-conversation-id: 0ec03a66-4015-4d78-af30-00c11e7ca526
x-b3-traceid: cfbddee2-bc9a-423e-b877-d0dc8dfaec48
Access-Control-Allow-Origin: *
Access-Control-Allow-Methods: GET, POST, PUT, DELETE, PATCH, OPTIONS
Access-Control-Allow-Headers: x-device-identifier, x-correlation-id, x-b3-traceid, x-conversation-id, Authorization, x-device-type, x-device-system, x-device-class, x-device-version, x-device-os-version, x-device-network-type, x-device-network-speed-down, x-device-network-speed-up, x-device-network-speed-latency, clientIp, User-Agent, Accept-Language, country, Warning, errorCode, errorException, errorMessage, errorMessageDetail, x-front-version, x-application, Forwarded, X-Forwarded-For, X-Forwarded-Host, X-Forwarded-Proto, Via, Location, Refresh, From, Host, Referer, Referrer-Policy, Allow, Server, Last-Event-ID, NEL, Ping-From, Ping-To, Report-To, Transfer-Encoding, TE, Trailer, Sec-WebSocket-Key, Sec-WebSocket-Extensions, Sec-WebSocket-Accept, Sec-WebSocket-Protocol, Sec-WebSocket-Version, Date, Early-Data, Link, Retry-After, SourceMap, Upgrade, content-type, authorization
Access-Control-Expose-Headers: x-device-identifier, x-correlation-id, x-b3-traceid, x-conversation-id, Authorization, x-device-type, x-device-system, x-device-class, x-device-version, x-device-os-version, x-device-network-type, x-device-network-speed-down, x-device-network-speed-up, x-device-network-speed-latency, clientIp, User-Agent, Accept-Language, country, Warning, errorCode, errorException, errorMessage, errorMessageDetail, x-front-version, x-application, Forwarded, X-Forwarded-For, X-Forwarded-Host, X-Forwarded-Proto, Via, Location, Refresh, From, Host, Referer, Referrer-Policy, Allow, Server, Last-Event-ID, NEL, Ping-From, Ping-To, Report-To, Transfer-Encoding, TE, Trailer, Sec-WebSocket-Key, Sec-WebSocket-Extensions, Sec-WebSocket-Accept, Sec-WebSocket-Protocol, Sec-WebSocket-Version, Date, Early-Data, Link, Retry-After, SourceMap, Upgrade, content-type, authorization
Access-Control-Allow-Credentials: true
x-warnings:
Content-Type: application/json
Transfer-Encoding: chunked
Date: Sun, 09 Apr 2023 20:21:58 GMT
Connection: close
payload:
{
  "cause": {
    "cause": null,
    "stackTrace": [],
    "type": "about:blank",
    "title": "can't create user",
    "status": null,
    "detail": null,
    "instance": null,
    "parameters": {},
    "message": "can't create user",
    "suppressed": [],
    "localizedMessage": "can't create user"
  },
  "stackTrace": [],
  "type": "about:blank",
  "title": "can't create user",
  "status": "INTERNAL_SERVER_ERROR",
  "detail": "",
  "instance": null,
  "parameters": {
    "errorCode": "USER-1_4",
    "fields": [],
    "application": "inugami-demo-user",
    "version": "2.3.0-SNAPSHOT",
    "errorType": "technical",
    "errorCategory": "user"
  },
  "message": "can't create user: ",
  "suppressed": [],
  "localizedMessage": "can't create user: "
}
```