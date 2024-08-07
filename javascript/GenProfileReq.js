const fs = require('fs');

const msisdnList = [
    {
      "msisdn": 6287884076185
    },
    {
      "msisdn": 6287883021842
    },
    {
      "msisdn": 6287884076214
    },
    {
      "msisdn": 6281944210270
    },
    {
      "msisdn": 6281995767267
    },
    {
      "msisdn": 6285959458235
    },
    {
      "msisdn": 6281995767299
    }
  ];

  function generateRandomUuid() {
    let chars = "xxxxxxxx-xxxx-4xxx-yxxx-xxxxxxxxxxxx";
    return chars.replace(/[xy]/g, function (c) {
      let r = Math.random() * 16 | 0, v = c === 'x' ? r : (r & 0x3 | 0x8);
      return v.toString(16);
    });
  }
  
  let requestList = [];
  for (let i = 0; i < msisdnList.length; i++) {
    let idx = i + 1;
    let msisdn = msisdnList[i].msisdn;
    let deviceId = generateRandomUuid();
    let firstName = "Test Automation";
    let lastName = "Update " + idx;

    let request = {};
    request["msisdn"] = msisdn;
    request["device-id"] = deviceId;
    request["first-name"] = firstName;
    request["last-name"] = lastName;

    requestList.push(request);
  }
  
  let jsonString = JSON.stringify(requestList);
  console.log(jsonString);

  let fileName = "/Users/aleph/Documents/profile-stress-test.json";
  console.log("Write file " + fileName);
  fs.writeFileSync(fileName, jsonString);
