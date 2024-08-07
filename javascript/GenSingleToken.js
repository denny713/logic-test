console.log(generateToken("6287793649205"));

function generateRandomUuid() {
    let chars = "xxxxxxxx-xxxx-4xxx-yxxx-xxxxxxxxxxxx";
    return chars.replace(/[xy]/g, function (c) {
        let r = Math.random() * 16 | 0, v = c === 'x' ? r : (r & 0x3 | 0x8);
        return v.toString(16);
    });
}

function generateToken(msisdn) {
    let currentTime = Math.floor(Date.now() / 1000);
    let header = {
        "alg": "RS256",
        "typ": "JWT",
        "kid": "zNPOfkDcNSihIh09iM1GUIW3dWlelkVzMw_2yGPi0fE"
    };
    let payload = {
        "iat": currentTime,
        "exp": currentTime + 900,
        "jti": generateRandomUuid(),
        "iss": "https://semeru.ciam.xlaxiata.co.id/realms/xl-ciam",
        "aud": "account",
        "sub": generateRandomUuid(),
        "typ": "Bearer",
        "azp": generateRandomUuid(),
        "session_state": generateRandomUuid(),
        "acr": "1",
        "allowed_origins": [
            "/*"
        ],
        "realm_access": {
            "roles": [
                "default-roles-xl-ciam",
                "offline_access",
                "uma_authorization"
            ]
        },
        "resource_access": {
            "account": {
                "roles": [
                    "manage-account",
                    "manage-account-links",
                    "view-profile"
                ]
            }
        },
        "scope": "openid profile email",
        "sid": generateRandomUuid(),
        "birthdate": "-",
        "email_verified": false,
        "name": "- -",
        "preferred_username": msisdn,
        "given_name": "-",
        "msisdn": msisdn,
        "family_name": "-"
    };

    // Convert header and payload to JSON strings
    let headerJSON = JSON.stringify(header);
    let payloadJSON = JSON.stringify(payload);

    // Base64 encode the header and payload JSON strings
    let headerEncoded = Buffer.from(headerJSON).toString('base64');
    let payloadEncoded = Buffer.from(payloadJSON).toString('base64');

    // Create the final JWT token without signature
    return `${headerEncoded}.${payloadEncoded}`;
}