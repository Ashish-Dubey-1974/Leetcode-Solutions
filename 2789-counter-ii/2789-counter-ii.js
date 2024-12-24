/**
 * @param {integer} init
 * @return { increment: Function, decrement: Function, reset: Function }
 */
var createCounter = function(init) {
    let original = init; 
    let initial = init;  
    return {
        increment:()=> {
            return ++original;
        },
        reset:()=>{
            original = initial; 
            return original;
        },
        decrement:()=> {
            return --original; 
        }
    };
};

