## Authentications

### Bearer Token
The implementation of the Bearer Authentication for Postman can be found in the File
```
requestBearerTokenOrangeHRM.js
```
in this directory. It is set as a Pre-Script in Postman prior to the OrangeHRM-Collection Run. <br>

![alt text](image-3.png)

### Password
The implemenation of the Password authorization is done in Postman itself. <br> 
The Username and Password are set for the Collection and then inherited in every API-Call

#### Folder Configuration
![alt text](image-1.png)

#### API-Call Exanple 
![alt text](image-2.png)