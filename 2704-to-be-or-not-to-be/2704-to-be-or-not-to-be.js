/**
 * @param {string} val
 * @return {Object}
 */
var expect = function(val) {
    var a = function toBe(compa){
        if(compa === val)
            return true
        else 
            throw "Not Equal"
    }
    
    var b = function notToBe(compa){
        if(compa !== val)
            return true
        else 
            throw "Equal"    
    }
    
  return { toBe: a, notToBe: b };
};

/**
 * expect(5).toBe(5); // true
 * expect(5).notToBe(5); // throws "Equal"
 */