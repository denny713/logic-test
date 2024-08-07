const fs = require('fs');

const msisdnList = [
  {
    "msisdn": "6287884076214",
    "device-id": "83b7ef6b-f9bf-485d-86ba-b9c61f030f2b"
  },
  {
    "msisdn": "6281995767266",
    "device-id": "9139506c-a357-460b-a8a1-be422049487f"
  },
  {
    "msisdn": "6281995767267",
    "device-id": "27fa778e-6a61-4c1c-9e36-2ca0c95f6843"
  },
  {
    "msisdn": "6281995767254",
    "device-id": "1ecb5515-10ac-438a-8181-5d3bd266ac9f"
  },
  {
    "msisdn": "6283869516480",
    "device-id": "0d1edac2-b325-4545-83b7-bc4b316c6ff8"
  },
  {
    "msisdn": "6285959458235",
    "device-id": "7fa1c8d7-1ae6-4e62-a312-dc3aae0d432f"
  },
  {
    "msisdn": "6281995767301",
    "device-id": "4cef7da6-8b2b-4e34-81f5-f467739cdeb2"
  },
  {
    "msisdn": "6287884074017",
    "device-id": "d95ed1d8-ca94-410c-b4ea-27cf10adb14c"
  },
  {
    "msisdn": "6287884074014",
    "device-id": "be754fd4-96e7-4428-a223-74c086afefb9"
  },
  {
    "msisdn": "6287884074096",
    "device-id": "1984e004-16d1-4868-bcf4-58f0e0d28bf0"
  },
  {
    "msisdn": "6287883021842",
    "device-id": "9e3adfe2-3bc6-4497-94d1-8ee06e30351c"
  },
  {
    "msisdn": "6287884076185",
    "device-id": "6e541987-cd9e-4d3c-93a6-d25f6bc94ac0"
  },
  {
    "msisdn": "6281995767256",
    "device-id": "9c9de990-14f0-45c0-a4f0-bb90d445e808"
  },
  {
    "msisdn": "6281995767299",
    "device-id": "9436a90c-b552-4fd6-848d-dfb3d5fb2e40"
  },
  {
    "msisdn": "6287889918142",
    "device-id": "64d97f7b-98a7-4b0e-8bf9-5f67a6e5c19c"
  },
  {
    "msisdn": "6287889918212",
    "device-id": "e3f50176-b194-4922-876f-4d0a1bed772b"
  },
  {
    "msisdn": "6287884074092",
    "device-id": "e50a0bb9-85b8-4bdd-9d43-db45455f7598"
  },
  {
    "msisdn": "6285964418295",
    "device-id": "78d02ace-b2d4-48f0-8caf-63bc79c34e32"
  },
  {
    "msisdn": "6285964418303",
    "device-id": "0fa44e86-d5b0-4709-bb72-64a9556a73ac"
  },
  {
    "msisdn": "6281995767255",
    "device-id": "a2f1d969-779c-47ba-91d6-4c781799557b"
  },
  {
    "msisdn": "6287884076330",
    "device-id": "147a9bb8-2f73-4913-bb87-bd00a2e4d768"
  },
  {
    "msisdn": "6283869516476",
    "device-id": "5695906c-72ae-4528-893b-1be5fd001c9a"
  },
  {
    "msisdn": "6281911471848",
    "device-id": "c58bc9d2-dcc5-462d-9090-9f3180f18519"
  },
  {
    "msisdn": "6281995767269",
    "device-id": "8817e4e8-84c9-42b6-84a7-db6ce2fc6bf6"
  },
  {
    "msisdn": "6287884074188",
    "device-id": "8339c4f4-524c-4837-8a79-224cb1a8a641"
  },
  {
    "msisdn": "628175257472",
    "device-id": "a2b5beb2-e950-466e-8c4a-b4483b83e013"
  },
  {
    "msisdn": "6285964418270",
    "device-id": "c08b59b4-9e86-4346-a5bc-0df147487224"
  },
  {
    "msisdn": "6285964418283",
    "device-id": "63b86e5d-3908-49ed-af0c-add7445919cb"
  },
  {
    "msisdn": "6287739649205",
    "device-id": "460e6a45-7c71-4906-8d5f-b9b259ecdfa1"
  },
  {
    "msisdn": "6285964418391",
    "device-id": "bfd807a8-50a7-47db-b71a-c4e8d6f19d4b"
  },
  {
    "msisdn": "6287889606832",
    "device-id": "0e9a0ad8-b2d7-4e18-aaa9-1d43ee876dd8"
  },
  {
    "msisdn": "6281906717387",
    "device-id": "ca07d174-6ab1-4d1f-b352-206f2d6d73db"
  },
  {
    "msisdn": "6287883984628",
    "device-id": "c78308e1-5d62-421b-8d9b-1f5a7fcbb25c"
  },
  {
    "msisdn": "6287730016820",
    "device-id": "925079bd-7e15-4e61-b6fd-d254fe2a914f"
  },
  {
    "msisdn": "6287883021814",
    "device-id": "57725459-1089-4781-b9b2-1933b0b84af1"
  },
  {
    "msisdn": "628195424846",
    "device-id": "a663aaa2-7bc5-4551-8c37-a2293add05fe"
  },
  {
    "msisdn": "6281944210270",
    "device-id": "0839a5ff-87c0-4cb5-b139-dc5f6145dccf"
  },
  {
    "msisdn": "6285964418351",
    "device-id": "bb7d3e01-bda8-4266-992a-07243f82f816"
  },
  {
    "msisdn": "6285964418353",
    "device-id": "1bb479ab-6eb8-4ee8-b476-ce886096eefb"
  },
  {
    "msisdn": "6287883021819",
    "device-id": "18b9ccd5-b0d8-41a2-9aee-9d884143d4d8"
  },
  {
    "msisdn": "6285964418294",
    "device-id": "522c82cd-eabe-4061-8c1f-93c8b25cbb1f"
  },
  {
    "msisdn": "6285964418296",
    "device-id": "3106dff0-12a6-4c7e-ae05-7f092e050f50"
  }
];

function generateRandomUuid() {
  let chars = "xxxxxxxx-xxxx-4xxx-yxxx-xxxxxxxxxxxx";
  return chars.replace(/[xy]/g, function (c) {
    let r = Math.random() * 16 | 0, v = c === 'x' ? r : (r & 0x3 | 0x8);
    return v.toString(16);
  });
}

const tokenList = [];
for (let i = 0; i < msisdnList.length; i++) {
  let msisdn = msisdnList[i].msisdn;
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
  let token = `${headerEncoded}.${payloadEncoded}`;
  let tokenDetail = { "access-token": token };
  tokenList.push(tokenDetail);
}

let jsonString = JSON.stringify(tokenList);
let fileName = "/Users/aleph/Documents/pin-stress-test-without-login.json";
//let fileName = "/Users/aleph/Documents/profile-stress-test.json";
console.log("Write file " + fileName);
fs.writeFileSync(fileName, jsonString);