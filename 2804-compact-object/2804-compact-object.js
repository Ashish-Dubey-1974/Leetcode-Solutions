/**
 * @param {Object|Array} obj
 * @return {Object|Array}
 */
var compactObject = function(obj) {
    if (Array.isArray(obj)) {
        return obj
            .filter(Boolean) // Remove falsy values
            .map(item => (typeof item === 'object' && item !== null ? compactObject(item) : item));
    } else if (typeof obj === 'object' && obj !== null) {
        const result = {};
        for (const key in obj) {
            if (Boolean(obj[key])) {
                result[key] = typeof obj[key] === 'object' && obj[key] !== null 
                    ? compactObject(obj[key]) 
                    : obj[key];
            }
        }
        return result;
    } else {
        return obj;
    }
};