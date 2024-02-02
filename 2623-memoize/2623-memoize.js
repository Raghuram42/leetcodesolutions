/**
 * @param {Function} fn
 * @return {Function}
 */
function memoize(fn) {
    let map = {}
    return function(...args) {
        if(!(fn in map))
            map[fn] = {}
        let strK = JSON.stringify(args)
        if(strK in map[fn])
            return map[fn][strK]
        return map[fn][strK] = fn(...args)
    }
}


/** 
 * let callCount = 0;
 * const memoizedFn = memoize(function (a, b) {
 *	 callCount += 1;
 *   return a + b;
 * })
 * memoizedFn(2, 3) // 5
 * memoizedFn(2, 3) // 5
 * console.log(callCount) // 1 
 */