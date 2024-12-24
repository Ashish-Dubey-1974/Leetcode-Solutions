/**
 * @param {Function} fn
 * @return {Function}
 */
function memoize(fn) {
    const cache = new Map(); // To store the cached results
    let callCount = 0; // To keep track of how many times the function is called

    return function(...args) {
        // Create a unique key for the current arguments
        const key = JSON.stringify(args);
        
        // If the result is in the cache, return it
        if (cache.has(key)) {
            return cache.get(key);
        }

        // Otherwise, call the function and store the result in the cache
        callCount += 1;
        const result = fn(...args);
        cache.set(key, result);
        return result;
    };
}

/** 
 * let callCount = 0;
 * const memoizedFn = memoize(function (a, b) {
 *   callCount += 1;
 *   return a + b;
 * })
 * console.log(memoizedFn(2, 3)); // 5
 * console.log(memoizedFn(2, 3)); // 5 (cached)
 * console.log(callCount); // 1 (function was only called once)
 */
