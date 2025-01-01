/**
 * @param {Array} arr1
 * @param {Array} arr2
 * @return {Array}
 */
var join = function(arr1, arr2) {
    const map1 = new Map(arr1.map(obj => [obj.id, obj]));
    const map2 = new Map(arr2.map(obj => [obj.id, obj]));
    const allIds = new Set([...map1.keys(), ...map2.keys()]);
    
    const result = [];
    for (const id of allIds) {
        result.push({
            ...map1.get(id), // Spread properties from arr1
            ...map2.get(id), // Spread properties from arr2
        });
    }

    // Sort the result by id in ascending order
    result.sort((a, b) => a.id - b.id);

    return result;
};