/**
 * @param {Array} arr
 * @param {Function} fn
 * @return {Array}
 */
var sortBy = function(arr, fn) {
    return [...arr].sort((a, b) => {
        const keyA = fn(a);
        const keyB = fn(b);
        if (keyA < keyB) return -1;
        if (keyA > keyB) return 1;
        return 0;
    });
};