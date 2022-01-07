# smart-doc
Version |  Update Time  | Status | Author |  Description
---|---|---|---|---
v2021-12-29 22:55:38|2021-12-29 22:55:38|auto|@keyon|Created by smart-doc



## 
### 
**URL:** http://localhost:8081/registerStaff

**Type:** POST


**Content-Type:** application/json; charset=utf-8

**Description:** 

**Body-parameters:**

Parameter | Type|Description|Required|Since
---|---|---|---|---
name|string|No comments found.|false|-
number|string|No comments found.|false|-
department|string|No comments found.|false|-

**Request-example:**
```
curl -X POST -H 'Content-Type: application/json; charset=utf-8' -i http://localhost:8081/registerStaff --data '{
  "name": "靖琪.莫",
  "number": "wn6vws",
  "department": "5t2scu"
}'
```
**Response-fields:**

Field | Type|Description|Since
---|---|---|---
code|int32|No comments found.|-
msg|string|No comments found.|-
data|object|No comments found.|-

**Response-example:**
```
{
  "code": 342,
  "msg": "um0gsw",
  "data": {
    "waring": "You may have used non-display generics."
  }
}
```


