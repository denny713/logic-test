const fs = require('fs');

// const msisdnList = [
//     {
//         "msisdn": 6287884074188
//     },
//     {
//         "msisdn": 6281995767299
//     }
// ];

const msisdnList = [
    {
      "msisdn": "6287883022127"
    },
    {
      "msisdn": "6287884076214"
    },
    {
      "msisdn": "6281995767266"
    },
    {
      "msisdn": "6281995767267"
    },
    {
      "msisdn": "6281995767254"
    },
    {
      "msisdn": "6283869516480"
    },
    {
      "msisdn": "6285959458235"
    },
    {
      "msisdn": "6281995767301"
    },
    {
      "msisdn": "6287812349627"
    },
    {
      "msisdn": "6287884074017"
    },
    {
      "msisdn": "6287884074014"
    },
    {
      "msisdn": "6287884074096"
    },
    {
      "msisdn": "6287883021842"
    },
    {
      "msisdn": "6287884076185"
    },
    {
      "msisdn": "6281995767256"
    },
    {
      "msisdn": "6281995767299"
    },
    {
      "msisdn": "6281995767265"
    },
    {
      "msisdn": "6287899469567"
    },
    {
      "msisdn": "6281995767287"
    },
    {
      "msisdn": "6287889918142"
    },
    {
      "msisdn": "6287889918212"
    },
    {
      "msisdn": "6287884074092"
    },
    {
      "msisdn": "628195464943"
    },
    {
      "msisdn": "6285964418295"
    },
    {
      "msisdn": "6285964418303"
    },
    {
      "msisdn": "6281995767255"
    },
    {
      "msisdn": "628174839839"
    },
    {
      "msisdn": "6287884076330"
    },
    {
      "msisdn": "6283869516476"
    },
    {
      "msisdn": "6281911471848"
    },
    {
      "msisdn": "6281995767269"
    },
    {
      "msisdn": "6281995767300"
    },
    {
      "msisdn": "6287884074188"
    },
    {
      "msisdn": "628175257472"
    },
    {
      "msisdn": "6281365431232"
    },
    {
      "msisdn": "6285964418270"
    },
    {
      "msisdn": "6285964418283"
    },
    {
      "msisdn": "6287739649205"
    },
    {
      "msisdn": "6281703790381"
    },
    {
      "msisdn": "6285964418391"
    },
    {
      "msisdn": "6287889606832"
    },
    {
      "msisdn": "6281906717387"
    },
    {
      "msisdn": "6287883984628"
    },
    {
      "msisdn": "6287730016820"
    },
    {
      "msisdn": "6287883021814"
    },
    {
      "msisdn": "628195424846"
    },
    {
      "msisdn": "6281944210270"
    },
    {
      "msisdn": "6285964418351"
    },
    {
      "msisdn": "6285964418353"
    },
    {
      "msisdn": "628782095507"
    },
    {
      "msisdn": "6287883021819"
    },
    {
      "msisdn": "6285964418294"
    },
    {
      "msisdn": "6285964418296"
    }
  ];

function generateRandomUuid() {
    let chars = "xxxxxxxx-xxxx-4xxx-yxxx-xxxxxxxxxxxx";
    return chars.replace(/[xy]/g, function (c) {
        let r = Math.random() * 16 | 0, v = c === 'x' ? r : (r & 0x3 | 0x8);
        return v.toString(16);
    });
}

console.log("Data size: " + msisdnList.length);
let requestList = [];
for (let i = 0; i < msisdnList.length; i++) {
    let msisdn = msisdnList[i].msisdn;
    let deviceId = generateRandomUuid();

    let request = {};
    request["msisdn"] = msisdn;
    request["device-id"] = deviceId;

    requestList.push(request);
}

let jsonString = JSON.stringify(requestList);
console.log(jsonString);

let fileName = "/Users/aleph/Documents/pin-big-stress-test.json";
console.log("Write file " + fileName);
fs.writeFileSync(fileName, jsonString);