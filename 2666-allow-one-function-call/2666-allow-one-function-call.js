/**
 * @param {Function} fn
 * @return {Function}
 */
var once = function(fn) {
    let call = false
    let value = 0
    return function(...args){
        if(!call)
            {
                call = true
                // console.log(args)
                value = fn(...args)
                return value
            }
        
        return undefined
    }
};

/**
 * let fn = (a,b,c) => (a + b + c)
 * let onceFn = once(fn)
 *
 * onceFn(1,2,3); // 6
 * onceFn(2,3,6); // returns undefined without calling fn
 */
