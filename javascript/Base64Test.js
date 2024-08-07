let txt = "112233";
let txtEnc = Buffer.from(txt).toString('base64');
console.log("Encoded value from " + txt + ":" + txtEnc);
let txtDec = Buffer.from(txtEnc, 'base64').toString();
console.log("Decoded value from " + txtEnc + ":" + txtDec);