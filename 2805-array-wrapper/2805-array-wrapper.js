/**
 * @param {number[]} nums
 * @return {void}
 */
var ArrayWrapper = function(nums) {
    this.nums = nums; // Store the array of numbers
};

/**
 * @return {number}
 */
ArrayWrapper.prototype.valueOf = function() {
    // Calculate and return the sum of the array elements
    return this.nums.reduce((sum, num) => sum + num, 0);
};

/**
 * @return {string}
 */
ArrayWrapper.prototype.toString = function() {
    // Convert the array to a string representation
    return `[${this.nums.join(",")}]`;
};

/**
 * Example Usage:
 * const obj1 = new ArrayWrapper([1, 2]);
 * const obj2 = new ArrayWrapper([3, 4]);
 * console.log(obj1 + obj2); // 10
 * console.log(String(obj1)); // "[1,2]"
 * console.log(String(obj2)); // "[3,4]"
 */
