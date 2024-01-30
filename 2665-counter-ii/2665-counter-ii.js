/**
 * @param {integer} init
 * @return { increment: Function, decrement: Function, reset: Function }
 */
var createCounter = function(init) {
    let p = init
    function inc(){
        p  = p+1
        return p
    }
    function dec(){
        p = p-1
        return p
    }
    function reset(){
        p = init
        return init
    }
    
    return {increment:inc, decrement:dec, reset: reset }
};

/**
 * const counter = createCounter(5)
 * counter.increment(); // 6
 * counter.reset(); // 5
 * counter.decrement(); // 4
 */