/**
 * @param {number[]} arr
 * @param {Function} fn
 * @return {number[]}
 */
var filter = function(arr, fn) {
    let newArr = [];
    arr.forEach(function(curr,index){
        if(fn(curr,index))newArr.push(curr);
    });return newArr;
};