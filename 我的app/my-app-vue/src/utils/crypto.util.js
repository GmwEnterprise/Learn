import CryptoJS from 'crypto-js';

// SHA256
const sha256 = (data) => {
  return CryptoJS.SHA256(data).toString();
};

// MD5
const md5 = (data) => {
  return CryptoJS.MD5(data).toString();
};

export default {
  md5,
  sha256
};