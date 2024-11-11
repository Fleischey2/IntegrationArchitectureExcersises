// Receives THe Bearer Token and Saves it as a Collection Variable
try {
    var response = await pm.sendRequest({
        url: "https://sepp-hrm.inf.h-brs.de/symfony/web/index.php/oauth/issueToken",
        method: "POST",
        body: {
        mode: "formdata",
        formdata: [
            {key: "client_id", value: "api_oauth_id"},
            {key: "client_secret", value: "oauth_secret"},
            {key: "grant_type", value: "password"},
            {key: "username", value: pm.collectionVariables.get("OrangeHRM_Username")},
            {key: "password", value: pm.collectionVariables.get("OrangeHRM_Password")}

        ]
        
    } 
    }
);
    console.log(response.json());
    var responseJson = response.json();
    pm.environment.set("OrangeHRM_Bearer", responseJson.access_token);
    console.log("OrangeHRM_Bearer: "+ responseJson.access_token);
} catch (err) {
    console.error(err);
}
