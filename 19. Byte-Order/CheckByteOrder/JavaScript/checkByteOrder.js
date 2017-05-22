// 實例含有整數 1 的 ArrayBuffer
var buf = new Int32Array([1]).buffer;

// 以 8 bits 來 "view" (檢視) ArrayBuffer，
// 因此此陣列長度為 4
// 若為 小頭端，元素分別為 01 00 00 00 (hex)
// 若為 大頭端，元素分別為 00 00 00 01 (hex)
var endianness = new Int8Array(buf);

// 位元組順序 之 檢測結果
var result = "BIG_ENDIAN";

// 檢查到底是 01 還是 00
if (endianness[0] === 1) {
    result = "LITTLE_ENDIAN";
}

// 輸出結果
console.log(result);
alert(result);